# 6. Basic Bootstrap Styling

Bootstrap gives us ready-made CSS classes.

A simple base template can load Bootstrap from its CDN:

```html
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
>
```

Useful classes:

```text
container
card
btn
btn-primary
btn-danger
form-control
table
alert
```

Create `base.html`:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>{% block title %}Task Manager{% endblock %}</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-dark mb-4">
    <div class="container">
        <a class="navbar-brand" href="{% url 'home' %}">Task Manager</a>
    </div>
</nav>

<main class="container">
    {% block content %}{% endblock %}
</main>
</body>
</html>
```

Templates can use:

```html
{% extends "tasks/base.html" %}
```

This avoids repeating the same HTML structure on every page.
