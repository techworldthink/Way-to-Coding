# Step 5 — URL, View and Template

This is one of the most important Django concepts.

## The three parts

### URL

Answers:

> Which code should handle this web address?

### View

Answers:

> What should happen when the request arrives?

### Template

Answers:

> What HTML should the user receive?

The flow is:

```text
Browser requests /
      ↓
URL
      ↓
View
      ↓
Database
      ↓
Template
      ↓
HTML response
```

## Create template folder

At project root:

```text
templates/
└── tasks/
```

Create:

```text
templates/tasks/task_list.html
```

## Configure templates

Open:

```text
campus_manager/settings.py
```

Find:

```python
"DIRS": [],
```

Change it to:

```python
"DIRS": [BASE_DIR / "templates"],
```

## Create the view

Open:

```text
tasks/views.py
```

Use:

```python
from django.shortcuts import render

from .models import Task


def task_list(request):
    tasks = Task.objects.all().order_by("-created_at")

    return render(
        request,
        "tasks/task_list.html",
        {"tasks": tasks},
    )
```

### What is `request`?

Django passes information about the browser request into the view.

### What is `Task.objects.all()`?

It asks Django's ORM for all Task records.

### What is `order_by("-created_at")`?

The minus sign means newest first.

### What does `render()` do?

It combines:
- a template
- data
- the request

and produces an HTML response.

## Create app URLs

Create:

```text
tasks/urls.py
```

Use:

```python
from django.urls import path

from .views import task_list


urlpatterns = [
    path("", task_list, name="task_list"),
]
```

## Connect app URLs to project URLs

Open:

```text
campus_manager/urls.py
```

Use:

```python
from django.contrib import admin
from django.urls import include, path


urlpatterns = [
    path("admin/", admin.site.urls),
    path("", include("tasks.urls")),
]
```

## Create the HTML template

Open:

```text
templates/tasks/task_list.html
```

Use:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Campus Task Manager</title>
</head>
<body>

    <h1>Campus Task Manager</h1>

    {% for task in tasks %}
        <article>
            <h2>{{ task.title }}</h2>
            <p>{{ task.description }}</p>

            {% if task.completed %}
                <strong>Completed</strong>
            {% else %}
                <strong>Pending</strong>
            {% endif %}
        </article>
        <hr>
    {% empty %}
        <p>No tasks found.</p>
    {% endfor %}

</body>
</html>
```

## Django template syntax

### Print a value

```text
{{ task.title }}
```

### Loop

```text
{% for task in tasks %}
{% endfor %}
```

### Condition

```text
{% if task.completed %}
{% else %}
{% endif %}
```

These are Django template language features.

## Test

Run:

```bash
python manage.py runserver
```

Open:

```text
http://127.0.0.1:8000/
```

The tasks you created through Admin should appear.

## Day 1 checkpoint

You have now connected:

```text
SQLite
  ↑
Model
  ↑
View
  ↑
URL
  ↑
Browser
  ↓
Template
```
