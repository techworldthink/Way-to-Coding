# Step 4 — Delete Task

Deleting permanently removes a database record.

Because it changes data, we will use POST for the actual delete operation.

## View

Add:

```python
def task_delete(request, task_id):
    task = get_object_or_404(
        Task,
        id=task_id,
    )

    if request.method == "POST":
        task.delete()
        return redirect("task_list")

    return render(
        request,
        "tasks/task_confirm_delete.html",
        {"task": task},
    )
```

## URL

```python
path(
    "delete/<int:task_id>/",
    task_delete,
    name="task_delete",
),
```

## Confirmation template

Create:

```text
templates/tasks/task_confirm_delete.html
```

Use:

```html
{% extends "base.html" %}

{% block title %}Delete Task{% endblock %}

{% block content %}

<h1>Delete Task</h1>

<p>
    Are you sure you want to delete
    <strong>{{ task.title }}</strong>?
</p>

<form method="post">
    {% csrf_token %}

    <button class="btn btn-danger">
        Yes, Delete
    </button>

    <a
        href="{% url 'task_list' %}"
        class="btn btn-secondary"
    >
        Cancel
    </a>
</form>

{% endblock %}
```

## Add button

```html
<a
    href="{% url 'task_delete' task.id %}"
    class="btn btn-danger btn-sm"
>
    Delete
</a>
```

## Test

Click Delete.

Confirm.

The task should disappear from the list.
