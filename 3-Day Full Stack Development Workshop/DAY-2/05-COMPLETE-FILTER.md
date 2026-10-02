# Step 5 — Complete and Filter

## Mark a task complete

Add to `tasks/views.py`:

```python
def task_complete(request, task_id):
    task = get_object_or_404(
        Task,
        id=task_id,
    )

    if request.method == "POST":
        task.completed = True
        task.save()

    return redirect("task_list")
```

## URL

```python
path(
    "complete/<int:task_id>/",
    task_complete,
    name="task_complete",
),
```

## Button

Inside the task card:

```html
{% if not task.completed %}
<form
    method="post"
    action="{% url 'task_complete' task.id %}"
    class="d-inline"
>
    {% csrf_token %}

    <button class="btn btn-success btn-sm">
        Complete
    </button>
</form>
{% endif %}
```

## Filter

Change `task_list`:

```python
def task_list(request):
    status = request.GET.get("status")

    tasks = Task.objects.all().order_by("-created_at")

    if status == "completed":
        tasks = tasks.filter(completed=True)

    elif status == "pending":
        tasks = tasks.filter(completed=False)

    return render(
        request,
        "tasks/task_list.html",
        {"tasks": tasks},
    )
```

## Add filter buttons

```html
<div class="mb-3">
    <a href="/" class="btn btn-secondary btn-sm">
        All
    </a>

    <a
        href="/?status=pending"
        class="btn btn-warning btn-sm"
    >
        Pending
    </a>

    <a
        href="/?status=completed"
        class="btn btn-success btn-sm"
    >
        Completed
    </a>
</div>
```

## What is `request.GET`?

For:

```text
/?status=pending
```

Django can read:

```python
request.GET.get("status")
```

which gives:

```text
pending
```

This is a simple example of passing information through a URL query parameter.
