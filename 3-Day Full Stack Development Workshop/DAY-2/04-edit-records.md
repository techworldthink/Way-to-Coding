# 4. Edit Records

In the previous section, we learned how to create a new task. Now, let's implement the **Update** operation in CRUD.

In a real application, users may need to correct a task title, change its description, or mark it as completed. We should allow them to edit an existing task instead of creating a new one.

For example, suppose a user has created this task:

```text
Title: Complete Django homework
Description: Finish the exercises
Completed: No
```

Later, the user wants to change the completion status to Yes.

Instead of creating another task, we will open the existing task, display its current details in a form, and save the changes.

## 4.1 Create the Edit View

Open `tasks/views.py` and add the following code. This uses the `TaskForm` we created earlier.

```python
from django.shortcuts import get_object_or_404

def task_edit(request, pk):
    task = get_object_or_404(Task, pk=pk)

    if request.method == "POST":
        form = TaskForm(request.POST, instance=task)
        if form.is_valid():
            form.save()
            return redirect("home")
    else:
        form = TaskForm(instance=task)

    return render(request, "tasks/task_form.html", {
        "form": form,
        "task": task,
    })
```

Make sure `views.py` already imports `Task` from `.models`, `TaskForm` from `.forms`, and `redirect` and `render` from `django.shortcuts`. You can add `get_object_or_404` to the existing shortcuts import rather than importing it twice.

Let's understand each part.

### 1. Define the view

```python
def task_edit(request, pk):
```

This function handles requests to edit an existing task.

Here, `request` contains information about the browser's request, and `pk` is the primary key of the task we want to edit.

A primary key is a unique identifier for a database record. Django normally creates an `id` field automatically if we do not define a primary key ourselves.

For example, our database might contain:

| ID | Title |
|---:|---|
| 1 | Complete Django homework |
| 2 | Practise Python |
| 3 | Read documentation |

If we want to edit the second task, its primary key is `2`.

### 2. Find the existing task

```python
task = get_object_or_404(Task, pk=pk)
```

Before editing a record, we need to retrieve it from the database.

Here:

- `Task` identifies the model we want to search.
- `pk=pk` tells Django to find the task whose primary key matches the value received in the URL.
- `get_object_or_404()` returns the matching task if it exists. If no matching task exists, Django returns an HTTP 404 Not Found response.

Why is this useful?

Suppose someone manually enters a URL containing an ID that does not exist. Without checking, our application could fail when trying to access that task. This function handles the missing-record situation properly.

### 3. Handle the POST request

```python
if request.method == "POST":
    form = TaskForm(request.POST, instance=task)
```

When the user submits the edited form, the browser sends a POST request containing the new values.

Notice that we pass two arguments to `TaskForm`:

- `request.POST` contains the newly submitted form data.
- `instance=task` tells Django which existing database record the form should update.

**Why is `instance=task` important?**

Remember our create view:

```python
form = TaskForm(request.POST)
```

When we use the form without an existing instance, a successful `form.save()` creates a new record.

For editing, we provide the existing task as the instance. Django then uses the submitted values to update that record instead of creating another one.

This is the main difference between creating and editing records with a `ModelForm`.

### 4. Validate and save the changes

```python
if form.is_valid():
    form.save()
    return redirect("home")
```

Just as we did when creating a task, we validate the submitted information before saving it.

If the data is valid, `form.save()` updates the existing task because the form has an existing instance.

After saving successfully, `redirect("home")` sends the user back to the task list.

If the data is invalid, Django continues to the `render()` statement and displays the form again with the submitted values and validation errors.

### 5. Display the existing values

```python
else:
    form = TaskForm(instance=task)
```

This part handles a GET request, which normally occurs when the user first opens the edit page.

Here, we create a form using the existing task instance.

Unlike an empty form, this form is pre-filled with the task's current values.

For example, if the saved task is:

```text
Title: Complete Django homework
Description: Finish the exercises
Completed: No
```

These values will already appear in the form. The user only needs to change the fields they want to update.

### 6. Render the template

```python
return render(request, "tasks/task_form.html", {
    "form": form,
    "task": task,
})
```

We reuse the same `task_form.html` template from the Create Records section.

The context dictionary passes two values to the template:

- `form`: the form containing either the existing values or the submitted data and validation errors.
- `task`: the existing task object, which is available if the template needs to display information about that task.

Reusing the template avoids creating a separate HTML form just for editing.

## 4.2 Add the URL

Open `tasks/urls.py` and add this URL pattern to the existing `urlpatterns` list:

```python
path(
    "tasks/<int:pk>/edit/",
    views.task_edit,
    name="task_edit",
),
```

This URL contains a dynamic part:

`<int:pk>`

It tells Django to capture an integer from the URL and pass it to the view as the argument `pk`.

For example:

- `/tasks/1/edit/` edits the task with primary key `1`.
- `/tasks/2/edit/` edits the task with primary key `2`.
- `/tasks/3/edit/` edits the task with primary key `3`.

The URL name `task_edit` lets us refer to this route elsewhere in our application.

## 4.3 Add an Edit Link to the Task List

Now users need a way to open the edit page for a particular task.

Inside the existing loop that displays tasks in your task-list template, add this link:

```html
<a href="{% url 'task_edit' task.pk %}">Edit</a>
```

For example, if the template loop uses `task` to represent the current task, `task.pk` provides that task's primary key.

Django uses the URL name and primary key to generate the correct edit URL.

If the task has primary key `2`, the generated link will point to:

`/tasks/2/edit/`

When the user clicks Edit, Django retrieves that task and displays its existing values in the form.

## 4.4 Test the Edit Functionality

1. Start the development server if it is not already running.
2. Open the task list at `http://127.0.0.1:8000/`.
3. Click Edit next to an existing task.
4. Check that the form contains the task's current values.
5. Change the title or completion status.
6. Click Save Task.
7. Confirm that the task list displays the updated information.

Also, try opening an edit URL with an ID that does not exist. You should receive a 404 Not Found response.

## 4.5 Create vs. Edit: What's the Difference?

| Create | Edit |
|---|---|
| Starts with an empty form. | Starts with existing values. |
| Uses `TaskForm(request.POST)`. | Uses `TaskForm(request.POST, instance=task)`. |
| Saves a new record. | Updates an existing record. |
| Does not need an existing task ID. | Needs the task's primary key. |

**Key takeaway:** The `instance` argument tells Django which existing record the form represents. By reusing `TaskForm` and `task_form.html`, we can support both creating and editing tasks with very little additional code.