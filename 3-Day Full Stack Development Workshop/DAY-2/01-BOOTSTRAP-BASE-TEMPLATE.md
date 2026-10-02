# Step 1 — Base Template and Bootstrap

We do not want to repeat the complete HTML structure on every page.

Django templates support template inheritance.

## Create

```text
templates/base.html
```

Use:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1"
    >

    <title>
        {% block title %}Campus Task Manager{% endblock %}
    </title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
    >
</head>

<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/">
            Campus Task Manager
        </a>
    </div>
</nav>

<main class="container py-4">
    {% block content %}
    {% endblock %}
</main>

</body>
</html>
```

## Update task_list.html

Replace its HTML with:

```html
{% extends "base.html" %}

{% block title %}Tasks{% endblock %}

{% block content %}

<div class="d-flex justify-content-between align-items-center mb-4">
    <h1>Tasks</h1>

    <a href="{% url 'task_create' %}" class="btn btn-primary">
        Add Task
    </a>
</div>

{% for task in tasks %}

<div class="card mb-3">
    <div class="card-body">

        <h5 class="card-title">
            {{ task.title }}
        </h5>

        <p class="card-text">
            {{ task.description }}
        </p>

        {% if task.completed %}
            <span class="badge bg-success">
                Completed
            </span>
        {% else %}
            <span class="badge bg-warning text-dark">
                Pending
            </span>
        {% endif %}

    </div>
</div>

{% empty %}

<p>No tasks found.</p>

{% endfor %}

{% endblock %}
```

## Why use `{% extends %}`?

`base.html` contains common structure.

Each page only supplies its own content.

This prevents repeated code.
