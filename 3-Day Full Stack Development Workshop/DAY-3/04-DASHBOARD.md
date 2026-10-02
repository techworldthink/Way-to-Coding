# Step 4 — Dashboard

A dashboard gives the user a quick summary.

## View

Add to `tasks/views.py`:

```python
@login_required
def dashboard(request):
    tasks = Task.objects.filter(
        user=request.user
    )

    total = tasks.count()
    completed = tasks.filter(
        completed=True
    ).count()
    pending = tasks.filter(
        completed=False
    ).count()

    return render(
        request,
        "tasks/dashboard.html",
        {
            "total": total,
            "completed": completed,
            "pending": pending,
        },
    )
```

## URL

In `tasks/urls.py`:

```python
path(
    "dashboard/",
    dashboard,
    name="dashboard",
),
```

## Template

Create:

```text
templates/tasks/dashboard.html
```

```html
{% extends "base.html" %}

{% block title %}Dashboard{% endblock %}

{% block content %}

<h1 class="mb-4">
    Welcome, {{ user.username }}
</h1>

<div class="row">

    <div class="col-md-4">
        <div class="card mb-3">
            <div class="card-body">
                <h6>Total Tasks</h6>
                <h2>{{ total }}</h2>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card mb-3">
            <div class="card-body">
                <h6>Completed</h6>
                <h2>{{ completed }}</h2>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card mb-3">
            <div class="card-body">
                <h6>Pending</h6>
                <h2>{{ pending }}</h2>
            </div>
        </div>
    </div>

</div>

<a
    href="{% url 'task_list' %}"
    class="btn btn-primary"
>
    View My Tasks
</a>

{% endblock %}
```

## Test

Create several tasks.

Complete some.

Open:

```text
/dashboard/
```

The numbers should update.
