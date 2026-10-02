# Step 3 — Edit Task

Editing is similar to creating, but we load an existing object first.

## Add import

In `tasks/views.py`:

```python
from django.shortcuts import get_object_or_404
```

## Add view

```python
def task_edit(request, task_id):
    task = get_object_or_404(
        Task,
        id=task_id,
    )

    if request.method == "POST":
        form = TaskForm(
            request.POST,
            instance=task,
        )

        if form.is_valid():
            form.save()
            return redirect("task_list")
    else:
        form = TaskForm(instance=task)

    return render(
        request,
        "tasks/task_form.html",
        {
            "form": form,
            "task": task,
        },
    )
```

## Why `get_object_or_404`?

It tries to find the object.

If it does not exist, the user gets a 404 response rather than a confusing error.

## URL

Add:

```python
path(
    "edit/<int:task_id>/",
    task_edit,
    name="task_edit",
),
```

## Add button

Inside each task card:

```html
<a
    href="{% url 'task_edit' task.id %}"
    class="btn btn-warning btn-sm"
>
    Edit
</a>
```

## Test

Create a task.

Click Edit.

Change the title.

Save.

Refresh.

The database value should have changed.
