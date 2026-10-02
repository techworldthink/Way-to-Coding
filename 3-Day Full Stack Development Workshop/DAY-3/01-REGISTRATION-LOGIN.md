# Step 1 — User Registration and Login

Django has a built-in authentication system.

We will use Django's `User` model rather than creating a custom authentication system during this short workshop.

## Registration

Open:

```text
tasks/views.py
```

Add imports:

```python
from django.contrib import messages
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User
```

Add:

```python
def register(request):
    if request.method == "POST":
        username = request.POST.get("username", "").strip()
        password = request.POST.get("password", "")

        if not username or not password:
            messages.error(
                request,
                "Username and password are required.",
            )
        elif User.objects.filter(username=username).exists():
            messages.error(
                request,
                "That username already exists.",
            )
        else:
            user = User.objects.create_user(
                username=username,
                password=password,
            )

            login(request, user)

            return redirect("dashboard")

    return render(
        request,
        "registration/register.html",
    )
```

## Registration URL

In `tasks/urls.py`:

```python
path(
    "register/",
    register,
    name="register",
),
```

## Registration template

Create:

```text
templates/registration/register.html
```

Use:

```html
{% extends "base.html" %}

{% block title %}Register{% endblock %}

{% block content %}

<div class="row justify-content-center">
    <div class="col-md-6">

        <h1 class="mb-4">Create Account</h1>

        {% if messages %}
            {% for message in messages %}
                <div class="alert alert-{{ message.tags }}">
                    {{ message }}
                </div>
            {% endfor %}
        {% endif %}

        <form method="post">

            {% csrf_token %}

            <div class="mb-3">
                <label class="form-label">
                    Username
                </label>

                <input
                    class="form-control"
                    type="text"
                    name="username"
                    required
                >
            </div>

            <div class="mb-3">
                <label class="form-label">
                    Password
                </label>

                <input
                    class="form-control"
                    type="password"
                    name="password"
                    required
                >
            </div>

            <button class="btn btn-primary">
                Register
            </button>

            <a
                href="{% url 'login' %}"
                class="btn btn-link"
            >
                Already have an account?
            </a>

        </form>

    </div>
</div>

{% endblock %}
```

## Login view

Add:

```python
def user_login(request):
    if request.method == "POST":
        username = request.POST.get("username", "").strip()
        password = request.POST.get("password", "")

        user = authenticate(
            request,
            username=username,
            password=password,
        )

        if user is not None:
            login(request, user)
            return redirect("dashboard")

        messages.error(
            request,
            "Invalid username or password.",
        )

    return render(
        request,
        "registration/login.html",
    )
```

## Login URL

```python
path(
    "login/",
    user_login,
    name="login",
),
```

## Login template

Create:

```text
templates/registration/login.html
```

```html
{% extends "base.html" %}

{% block title %}Login{% endblock %}

{% block content %}

<div class="row justify-content-center">
    <div class="col-md-6">

        <h1 class="mb-4">Login</h1>

        {% if messages %}
            {% for message in messages %}
                <div class="alert alert-{{ message.tags }}">
                    {{ message }}
                </div>
            {% endfor %}
        {% endif %}

        <form method="post">

            {% csrf_token %}

            <div class="mb-3">
                <label class="form-label">
                    Username
                </label>

                <input
                    class="form-control"
                    type="text"
                    name="username"
                    required
                >
            </div>

            <div class="mb-3">
                <label class="form-label">
                    Password
                </label>

                <input
                    class="form-control"
                    type="password"
                    name="password"
                    required
                >
            </div>

            <button class="btn btn-primary">
                Login
            </button>

            <a
                href="{% url 'register' %}"
                class="btn btn-link"
            >
                Create account
            </a>

        </form>

    </div>
</div>

{% endblock %}
```

## Logout

Add:

```python
def user_logout(request):
    logout(request)
    return redirect("login")
```

URL:

```python
path(
    "logout/",
    user_logout,
    name="logout",
),
```

## Test

1. Open `/register/`.
2. Create a user.
3. You should be logged in.
4. Log out.
5. Open `/login/`.
6. Log in again.
