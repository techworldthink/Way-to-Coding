# Step 2 — Protect Application Pages

A task application should not allow anonymous users to manage tasks.

Django provides `login_required`.

## Import

In `tasks/views.py`:

```python
from django.contrib.auth.decorators import login_required
```

## Add decorator

For example:

```python
@login_required
def task_list(request):
    ...
```

Do this for:
- task list
- create
- edit
- delete
- complete
- dashboard

## Configure login URL

In `campus_manager/settings.py`:

```python
LOGIN_URL = "/login/"
```

Now an unauthenticated user visiting a protected page is sent to login.

## Navbar

Update `base.html`.

Inside the navbar:

```html
{% if user.is_authenticated %}

    <span class="navbar-text text-white me-3">
        Hi, {{ user.username }}
    </span>

    <a
        href="{% url 'dashboard' %}"
        class="btn btn-outline-light me-2"
    >
        Dashboard
    </a>

    <a
        href="{% url 'logout' %}"
        class="btn btn-outline-light"
    >
        Logout
    </a>

{% else %}

    <a
        href="{% url 'login' %}"
        class="btn btn-outline-light me-2"
    >
        Login
    </a>

    <a
        href="{% url 'register' %}"
        class="btn btn-primary"
    >
        Register
    </a>

{% endif %}
```

## Authentication concept

Authentication answers:

> Who is this user?

Authorization answers:

> What is this user allowed to access?

Today we mainly implement authentication and basic ownership of task data.
