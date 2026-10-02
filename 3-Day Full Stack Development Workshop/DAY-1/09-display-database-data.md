# 9. Display Database Data

Update `tasks/views.py`:

```python
from django.shortcuts import render
from .models import Task

def home(request):
    tasks = Task.objects.all().order_by("-created_at")
    return render(request, "tasks/home.html", {"tasks": tasks})
```

Update `home.html`:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Task Manager</title>
</head>
<body>
    <h1>Task Manager</h1>

    {% if tasks %}
        <ul>
            {% for task in tasks %}
                <li>
                    <strong>{{ task.title }}</strong>
                    - {{ task.description }}
                </li>
            {% endfor %}
        </ul>
    {% else %}
        <p>No tasks found.</p>
    {% endif %}
</body>
</html>
```

To create sample records, register the model in `tasks/admin.py`:

```python
from django.contrib import admin
from .models import Task

admin.site.register(Task)
```

Create an admin user:

```bash
python manage.py createsuperuser
```

Open `/admin/`, add several tasks, then return to `/`.

The data path is:

```text
SQLite → Task model → View → Template → Browser
```
