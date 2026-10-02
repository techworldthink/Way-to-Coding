# Step 2 — Create Task with a Django ModelForm

A form collects data from a user.

Django's `ModelForm` can build a form from a model.

## Create forms.py

Create:

```text
tasks/forms.py
```

Use:

```python
from django import forms

from .models import Task


class TaskForm(forms.ModelForm):
    class Meta:
        model = Task
        fields = [
            "title",
            "description",
        ]
```

If you added `priority` on Day 1, include it:

```python
fields = [
    "title",
    "description",
    "priority",
]
```

## Create view

Open:

```text
tasks/views.py
```

Add:

```python
from django.shortcuts import redirect, render

from .forms import TaskForm


def task_create(request):
    if request.method == "POST":
        form = TaskForm(request.POST)

        if form.is_valid():
            form.save()
            return redirect("task_list")
    else:
        form = TaskForm()

    return render(
        request,
        "tasks/task_form.html",
        {"form": form},
    )
```

## Understand GET and POST

When a user first opens the form:

```text
GET
 ↓
Show empty form
```

When they submit it:

```text
POST
 ↓
Receive submitted data
 ↓
Validate
 ↓
Save
 ↓
Redirect
```

## Add URL

Open:

```text
tasks/urls.py
```

Add:

```python
path(
    "create/",
    task_create,
    name="task_create",
),
```

## Create template

Create:

```text
templates/tasks/task_form.html
```

Use:

```html
{% extends "base.html" %}

{% block title %}Add Task{% endblock %}

{% block content %}

<h1 class="mb-4">Add Task</h1>

<form method="post">

    {% csrf_token %}

    {{ form.as_p }}

    <button class="btn btn-primary">
        Save Task
    </button>

    <a href="{% url 'task_list' %}" class="btn btn-secondary">
        Cancel
    </a>

</form>

{% endblock %}
```

## Why `{% csrf_token %}`?

Django uses CSRF protection to help prevent malicious sites from submitting unwanted forms using a user's authenticated browser session.

For POST forms in Django, include:

```text
{% csrf_token %}
```

## Test

Open:

```text
http://127.0.0.1:8000/create/
```

Create a task.

You should be redirected to the task list.

## Checkpoint

You have now implemented:

```text
Browser
 ↓
Form
 ↓
POST
 ↓
View
 ↓
Model
 ↓
Database
 ↓
Redirect
 ↓
Task List
```
