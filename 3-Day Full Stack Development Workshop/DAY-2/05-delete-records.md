# 5. Delete Records

In this step, we will allow users to delete tasks from our Task Manager.

For example, if a user no longer needs a task, they can click **Delete**, confirm the action, and remove the task from the database.

## Step 1: Create the Delete View

Open `tasks/views.py`.

Make sure these imports are available:

```python
from django.shortcuts import get_object_or_404, redirect, render
from .models import Task
```

Add the following view:

```python
def task_delete(request, pk):
    task = get_object_or_404(Task, pk=pk)

    if request.method == "POST":
        task.delete()
        return redirect("home")

    return render(request, "tasks/task_confirm_delete.html", {
        "task": task,
    })
```

**How it works:**

- `get_object_or_404()` finds the task using its ID. If it doesn't exist, Django returns a 404 error.
- `request.method == "POST"` checks whether the user submitted the confirmation form.
- `task.delete()` deletes the task from the database.
- `redirect("home")` takes the user back to the task list.
- `render()` displays the confirmation page before deletion.

The task is not deleted when the confirmation page first opens. It is deleted only when the user submits the form.

## Step 2: Add the URL

Open `tasks/urls.py` and add this URL pattern to the existing `urlpatterns` list:

```python
path(
    "tasks/<int:pk>/delete/",
    views.task_delete,
    name="task_delete",
),
```

Make sure `tasks/urls.py` already imports `path` and `views`.

The URL might look like `/tasks/3/delete/`, where `3` is the task's ID.

## Step 3: Create the Confirmation Template

Create this file:

`tasks/templates/tasks/task_confirm_delete.html`

Add the following HTML:

```html
<h1>Delete Task</h1>

<p>Are you sure you want to delete "{{ task.title }}"?</p>

<form method="post">
    {% csrf_token %}
    <button type="submit">Yes, Delete</button>
</form>

<a href="{% url 'home' %}">Cancel</a>
```

This page asks the user to confirm before deleting the task.

`{% csrf_token %}` adds a security token required for Django's POST form protection.

## Step 4: Add the Delete Button to the Home Page

Now users need a way to open the confirmation page.

Open your existing home page template, usually:

`tasks/templates/tasks/home.html`

Find the code that displays each task. It might look something like this:

```html
{% for task in tasks %}
    <h3>{{ task.title }}</h3>
    <p>{{ task.description }}</p>
{% endfor %}
```

Add the Delete link inside the loop:

```html
{% for task in tasks %}
    <h3>{{ task.title }}</h3>
    <p>{{ task.description }}</p>

    <a href="{% url 'task_delete' task.pk %}">
        Delete
    </a>
{% endfor %}
```

**Important:** If your home page already has a task loop, do not add a second loop. Just add the Delete link inside the existing loop.

The link uses `task.pk` to tell Django which task the user wants to delete.

Clicking Delete opens the confirmation page; it does not immediately delete the record.

## Step 5: Test the Feature

1. Start the development server:

   ```bash
   python manage.py runserver
   ```

2. Open the Task Manager home page.
3. Click Delete next to a task.
4. Check that the confirmation page displays the correct task title.
5. Click **Yes, Delete**.
6. Confirm that the task no longer appears on the home page.
7. Try clicking Cancel and verify that the task remains.

## What We Learned

- How to find a database record using its ID.
- How to display a confirmation page.
- How to delete a record from the database.
- How to connect a button or link to a Django URL.
- Why we use POST for the actual deletion rather than deleting data through a simple GET link.