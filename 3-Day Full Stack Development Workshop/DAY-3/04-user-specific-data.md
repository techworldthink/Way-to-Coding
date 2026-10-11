# 4. User-Specific Data

Until now, our Task Manager application has allowed users to register and log in. However, we must also ensure that each user can manage only their own tasks.

For example, if Jobin creates a task called “Complete Workshop Notes” and another student creates a task called “Build My Project,” each student should see and manage their own tasks without accessing the other student's data.

To achieve this, we need to associate every task with the user who created it.

## Step 1: Update the Task Model

Open `tasks/models.py` and add an `owner` field to the `Task` model.

```python
from django.conf import settings

owner = models.ForeignKey(
    settings.AUTH_USER_MODEL,
    on_delete=models.CASCADE,
    related_name="tasks",
)
```

Let's understand the important parts.

**`from django.conf import settings`**

Django's settings module allows us to access the project's configuration. Here, we use it to refer to the user model configured for the project.

**`owner = models.ForeignKey(...)`**

A `ForeignKey` creates a relationship between two database models. In this case, it connects each task to one user.

For example:

| Task | Owner |
|---|---|
| Complete Workshop Notes | Jobin |
| Build My Project | Student 2 |
| Prepare Presentation | Jobin |

Multiple tasks can belong to the same user, but each task has one owner.

**`settings.AUTH_USER_MODEL`**

This refers to the user model configured in Django. Using this setting is preferable to directly referencing Django's built-in `User` model because it also supports projects that use a custom user model.

**`on_delete=models.CASCADE`**

This specifies what happens if the associated user is deleted. With `CASCADE`, that user's related tasks are also deleted.

**`related_name="tasks"`**

This provides a convenient way to access a user's tasks through the user object. For example, `request.user.tasks.all()` retrieves tasks belonging to that user.

## Step 2: Apply the Database Changes

Run these commands in the terminal:

```bash
python manage.py makemigrations
python manage.py migrate
```

**`makemigrations`** creates a migration file describing the database changes needed for the new `owner` field.

**`migrate`** applies those changes to the database.

### What if the database already contains old tasks?

If the existing tasks do not have owners, Django cannot automatically determine which user created them.

For this classroom project, you can start with a clean Day 3 database if the old sample data is no longer needed:

1. Stop the development server.
2. Delete `db.sqlite3` from the project folder.
3. Run `python manage.py migrate`.
4. Create a new administrator account if required:

```bash
python manage.py createsuperuser
```

**Warning:** Deleting `db.sqlite3` removes the existing database data, including users, tasks, and other records stored in it. Do this only if you are comfortable losing that data.

## Step 3: Assign the Logged-In User When Creating a Task

When a user creates a task, the application must automatically assign that task to the currently logged-in user.

Update the task creation logic in `tasks/views.py`:

```python
task = form.save(commit=False)
task.owner = request.user
task.save()
```

Let's understand each line.

**`form.save(commit=False)`**

Normally, `form.save()` saves the object immediately. The `commit=False` argument creates the model object without saving it to the database yet.

This gives us an opportunity to set additional values before saving.

**`task.owner = request.user`**

`request.user` represents the user making the current request. This line assigns that user as the task's owner.

**`task.save()`**

Now the task is saved to the database with its owner assigned.

We use this approach because the user should not need to select their own username in the task form. The server already knows who is logged in.

## Step 4: Display Only the Current User's Tasks

When displaying tasks, retrieve only the tasks owned by the logged-in user:

```python
tasks = Task.objects.filter(owner=request.user)
```

**`Task.objects.filter(...)`** retrieves database records that match the specified condition.

Here, `owner=request.user` means Django returns only tasks belonging to the current user.

For example, if Jobin is logged in, his task list will not include tasks created by other students.

This filtering must happen in the Django view, not just in the HTML template. Hiding other users' tasks in the interface alone does not prevent unauthorized access.

## Step 5: Protect Editing and Deleting

Suppose Student 2 tries to edit Jobin's task by manually changing the task ID in the browser URL.

For example:

`http://127.0.0.1:8000/tasks/1/edit/`

To prevent this, the server must check both the task's ID and its owner.

Use this query in the edit and delete views:

```python
task = get_object_or_404(
    Task,
    pk=pk,
    owner=request.user,
)
```

Let's understand it.

- `Task` tells Django which model to search.
- `pk=pk` finds the task with the requested primary key (database ID).
- `owner=request.user` ensures that the task belongs to the currently logged-in user.
- `get_object_or_404()` returns the matching task if it exists. Otherwise, Django raises a 404 response.

If a user tries to access another user's task, the query will not find a matching record because the owner condition fails.

Use the same ownership check in both editing and deleting operations. Also protect these views with `@login_required` so unauthenticated users cannot access them.


## Step 6: Update the Home Page to Show User-Specific Tasks

We have updated the task creation, editing, and deleting logic to respect task ownership. We must also update the home page so that each user sees only their own tasks.

Currently, our `home()` view retrieves all tasks from the database:

```python
def home(request):
    tasks = Task.objects.all().order_by("-created_at")
    return render(request, "tasks/home.html", {"tasks": tasks})
```

The problem is this line:

```python
tasks = Task.objects.all().order_by("-created_at")
```

`Task.objects.all()` retrieves **every task in the database**, including tasks created by other users. Even though we have added an `owner` field, this query does not use it.

### Update the home view

Open `tasks/views.py` and replace the existing `home()` function with:

```python
@login_required
def home(request):
    tasks = Task.objects.filter(
        owner=request.user
    ).order_by("-created_at")

    return render(request, "tasks/home.html", {"tasks": tasks})
```

Make sure you have these imports at the top of `tasks/views.py`:

```python
from django.contrib.auth.decorators import login_required
from .models import Task
```

### Understanding the changes

**1. `@login_required`**

This ensures that only logged-in users can access the home page. If an unauthenticated user tries to open it, Django redirects them to the login page.

**2. `Task.objects.filter(owner=request.user)`**

This retrieves only the tasks belonging to the currently logged-in user.

For example, if Jobin has five tasks and another student has three tasks, Jobin will see only his five tasks.

**3. `.order_by("-created_at")`**

This sorts the tasks by their creation date, with the newest tasks appearing first. The minus sign (`-`) indicates descending order.

**4. `render(...)`**

This sends the filtered task list to `tasks/home.html`, where the template displays the tasks.

### Test the changes

1. Log in as the first user and create two tasks.
2. Log out and register or log in as a second user.
3. Create a task using the second account.
4. Return to the home page for each account.

Each user should see only the tasks they created.

**Important:** Filtering tasks on the home page is not enough by itself. We must also keep the ownership checks in the edit and delete views so users cannot access another user's tasks by changing the ID in a URL.


## What Have We Learned?

- Every task has an owner.
- New tasks are assigned to the logged-in user.
- Users see only their own tasks.
- Editing and deleting require an ownership check on the server.
- Changing a task ID in the URL must not allow access to another user's data.

**Key principle:** Authentication tells us who the user is. Authorization determines what that user is allowed to access or change.