# Step 3 — Make Tasks Belong to Users

Right now every task belongs to the application.

We need:

```text
User A
 ├── Task 1
 └── Task 2

User B
 ├── Task 3
 └── Task 4
```

## Update model

Open `tasks/models.py`.

Add:

```python
from django.contrib.auth.models import User
```

Update Task:

```python
class Task(models.Model):
    user = models.ForeignKey(
        User,
        on_delete=models.CASCADE,
    )

    title = models.CharField(max_length=200)
    description = models.TextField(blank=True)
    completed = models.BooleanField(default=False)
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.title
```

If you added `priority` or other fields, keep them.

## Migration issue

Because existing Task records do not have a user, Django may ask how to populate the new field.

For this workshop database, the simplest student reset is:

Stop the server.

Delete:

```text
db.sqlite3
```

Inside:

```text
tasks/migrations/
```

delete migration files you created, but keep:

```text
__init__.py
```

Then:

```bash
python manage.py makemigrations
python manage.py migrate
```

Create a new admin user if needed:

```bash
python manage.py createsuperuser
```

This is acceptable for a disposable workshop database.

In a real application, you would plan a proper data migration instead of deleting the production database.

## Save the current user

In `task_create`:

```python
if form.is_valid():
    task = form.save(commit=False)
    task.user = request.user
    task.save()

    return redirect("task_list")
```

`commit=False` means:

> Create the Python object from the form, but do not write it to the database yet.

That gives us time to assign the user.

## Show only the current user's tasks

In `task_list`:

```python
tasks = Task.objects.filter(
    user=request.user
).order_by("-created_at")
```

Now User A cannot see User B's tasks through the normal list.

## Important security point

Do not only hide buttons in HTML.

The backend must check ownership too.

For the edit/delete/complete views, use:

```python
task = get_object_or_404(
    Task,
    id=task_id,
    user=request.user,
)
```

This means Django searches for a task matching BOTH:
- the requested ID
- the logged-in user

If another user guesses the ID, they will not get that task.

## Update all task views

Use this pattern for:

```text
edit
delete
complete
```

For example:

```python
task = get_object_or_404(
    Task,
    id=task_id,
    user=request.user,
)
```

This is an important real-world backend security concept.
