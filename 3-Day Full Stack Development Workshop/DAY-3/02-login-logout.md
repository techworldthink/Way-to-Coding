# 2. Login & Logout

In the previous section, we implemented user registration. Users can now create their own accounts in our Task Manager application.

However, after registering, users also need a way to log in again when they revisit the application. They should also be able to log out when they finish using it.

Django provides a built-in authentication system that includes ready-made views for handling login and logout. We can use these instead of writing all the authentication logic ourselves.

**Login** verifies a user's credentials and establishes an authenticated session.

**Logout** ends the user's authenticated session.

## 2.1 Configure the Login and Logout URLs

Open `config/urls.py` and add the following code to your existing URL configuration:

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

Make sure `config/urls.py` already imports `path` from `django.urls`.

Let's understand each part.

**1. Import Django's authentication views**

```python
from django.contrib.auth import views as auth_views
```

Django provides built-in views for common authentication operations.

Here, we import those views and give the module the shorter name `auth_views`. This lets us refer to the login and logout views as `auth_views.LoginView` and `auth_views.LogoutView`.

**2. Configure the login URL**

```python
path(
    "login/",
    auth_views.LoginView.as_view(
        template_name="tasks/login.html"
    ),
    name="login",
),
```

This URL connects `/login/` to Django's built-in `LoginView`.

Let's understand the important parts:

- `"login/"` is the URL path users visit to log in.
- `LoginView` provides the functionality for displaying the login form and processing submitted credentials.
- `as_view()` makes the class-based view usable as a URL handler.
- `template_name="tasks/login.html"` tells Django which HTML template to use for the login page.
- `name="login"` gives the URL a name that we can use elsewhere in the application.

Django's built-in login view uses an authentication form to check the submitted username and password. If the credentials are valid, it logs the user in. Otherwise, it displays the form again with an error.

**3. Configure the logout URL**

```python
path(
    "logout/",
    auth_views.LogoutView.as_view(),
    name="logout",
),
```

This connects `/logout/` to Django's built-in `LogoutView`.

When the logout view is invoked, Django logs out the current user and ends their authenticated session.

Notice that we do not need to write a separate logout function in `views.py`. Django already provides this functionality.

For this example, we will use the default logout behavior. In modern Django versions, the built-in `LogoutView` expects a POST request, so logout should be triggered using a POST form rather than a normal GET link.

## 2.2 Create the Login Template

Create the file `tasks/templates/tasks/login.html`:

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

Let's understand the important parts.

**1. Extend the base template**

```html
{% extends "tasks/base.html" %}
```

We created a base template earlier to provide a common layout for our application.

It may contain the navigation bar, Bootstrap CSS, and other shared elements.

By extending the base template, our login page can reuse that layout instead of duplicating the same HTML structure on every page.

**2. Define the content block**

```html
{% block content %}
...
{% endblock %}
```

The `content` block is a named section defined by the base template.

We place the login page's content inside this block. Django inserts it into the corresponding block in `base.html` when rendering the page.

**3. Display the login form**

```html
<form method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <button class="btn btn-primary">Login</button>
</form>
```

Here:

- `method="post"` submits the login credentials to Django using a POST request.
- `{% csrf_token %}` includes Django's CSRF protection token.
- `{{ form.as_p }}` renders the form provided by Django's built-in login view.
- `class="btn btn-primary"` applies Bootstrap's primary button styling, assuming Bootstrap is loaded by the base template.

We do not need to define a separate login form class for this example because Django's `LoginView` supplies its default authentication form.

**4. Provide a registration link**

```html
<a href="{% url 'register' %}">Register</a>
```

A user who does not have an account can click this link to open the registration page we created earlier.

The `{% url 'register' %}` template tag generates the URL associated with the `register` URL name.

## 2.3 Configure Authentication Settings

Open `config/settings.py` and add these settings:

```python
LOGIN_URL = "/login/"
LOGIN_REDIRECT_URL = "/dashboard/"
LOGOUT_REDIRECT_URL = "/login/"
```

These settings tell Django where to direct users during common authentication workflows.

**1. `LOGIN_URL`**

```python
LOGIN_URL = "/login/"
```

This specifies the login page URL.

Django uses this setting, for example, when an unauthenticated user tries to access a view protected by the `login_required` decorator and needs to log in first.

**2. `LOGIN_REDIRECT_URL`**

```python
LOGIN_REDIRECT_URL = "/dashboard/"
```

This specifies the default destination after a successful login when no other destination has been requested.

In our Task Manager, we want users to reach the dashboard after logging in.

Make sure your project has a URL and view that serve `/dashboard/`.

**3. `LOGOUT_REDIRECT_URL`**

```python
LOGOUT_REDIRECT_URL = "/login/"
```

This specifies where users should be redirected after logging out.

In this example, users return to the login page.

## 2.4 How Does the Login Process Work?

The workflow is:

1. The user opens `/login/`.
2. Django's `LoginView` displays the login form.
3. The user enters their username and password.
4. The browser submits the form using POST.
5. Django checks the credentials.
6. If they are valid, Django establishes an authenticated session.
7. The user is redirected to the requested page or the configured login redirect destination.
8. If the credentials are invalid, the login form is displayed again with an error.

The important point is that Django handles credential verification and session management for us.

## 2.5 How Does Logout Work?

When a logged-in user wants to leave their account, the application sends a POST request to `/logout/`.

Django's `LogoutView` ends the authenticated session and redirects the user to the configured logout destination.

Since our configuration uses:

```python
LOGOUT_REDIRECT_URL = "/login/"
```

the user returns to the login page after logging out.

A logout control can be added to the navigation bar using a POST form:

```html
<form method="post" action="{% url 'logout' %}">
    {% csrf_token %}
    <button type="submit">Logout</button>
</form>
```

This is preferable to a normal link because logout changes the user's session state and should not be triggered through a GET request.

## 2.6 Test Login and Logout

Start the development server if it is not already running:

```bash
python manage.py runserver
```

Test the following URLs:

- Login: `http://127.0.0.1:8000/login/`
- Registration: `http://127.0.0.1:8000/register/`

Then:

1. Register a new account if you have not already created one.
2. Log in using the account's username and password.
3. Confirm that Django redirects you to the configured destination.
4. Click the Logout button.
5. Confirm that you are redirected to the login page.
6. Try logging in again with an incorrect password and observe the error.

**Important:** Login and logout provide authentication, but they do not automatically restrict every page in your application. We must explicitly protect the relevant views and ensure that users can access only their own tasks.

**Key takeaway:** Django's built-in `LoginView` and `LogoutView` provide most of the login and logout functionality we need. URL configuration connects these views to the browser, the login template controls the page's appearance, and authentication settings define the default redirect destinations.