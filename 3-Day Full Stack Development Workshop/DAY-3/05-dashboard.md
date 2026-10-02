# 5. Basic Dashboard

A dashboard can summarize the logged-in user's tasks.

```python
@login_required
def dashboard(request):
    tasks = Task.objects.filter(owner=request.user)

    total = tasks.count()
    completed = tasks.filter(completed=True).count()
    pending = tasks.filter(completed=False).count()

    return render(request, "tasks/dashboard.html", {
        "total": total,
        "completed": completed,
        "pending": pending,
    })
```

Template:

```html
<h1>Dashboard</h1>

<p>Welcome, {{ request.user.username }}!</p>

<div class="row">
    <div class="col-md-4">
        <div class="card p-3">
            <h2>{{ total }}</h2>
            <p>Total Tasks</p>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card p-3">
            <h2>{{ completed }}</h2>
            <p>Completed</p>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card p-3">
            <h2>{{ pending }}</h2>
            <p>Pending</p>
        </div>
    </div>
</div>
```

The dashboard is intentionally basic. The goal is to understand how database information can be summarized for a user.
