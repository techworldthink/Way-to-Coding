# 2. Login & Logout

Django provides ready-made authentication views.

In `config/urls.py`:

```python
from django.contrib.auth import views as auth_views

path(
    "login/",
    auth_views.LoginView.as_view(
        template_name="tasks/login.html"
    ),
    name="login",
),
path(
    "logout/",
    auth_views.LogoutView.as_view(),
    name="logout",
),
```

Create `login.html`:

```html
{% extends "tasks/base.html" %}

{% block content %}
<h1>Login</h1>

<form method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <button class="btn btn-primary">Login</button>
</form>

<a href="{% url 'register' %}">Register</a>
{% endblock %}
```

In settings:

```python
LOGIN_URL = "/login/"
LOGIN_REDIRECT_URL = "/dashboard/"
LOGOUT_REDIRECT_URL = "/login/"
```
