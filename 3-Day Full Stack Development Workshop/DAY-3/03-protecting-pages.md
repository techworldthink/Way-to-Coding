## 3. Protecting Pages

So far, we have created registration, login, and logout functionality. However, creating a login system does not automatically protect every page in our application.

For example, a user who has not logged in should not be able to open the dashboard and access private task information. We can protect pages using Django's `login_required` decorator.

### Step 1: Import `login_required`

In `tasks/views.py`, add this import:

```
from django.contrib.auth.decorators import login_required
```

- `django.contrib.auth.decorators` is a Django module that provides decorators for authentication-related tasks.
- `login_required` is a decorator that checks whether the current user is logged in before allowing them to access a view.

A decorator is a way to add extra behavior to a function without rewriting the function's main logic.

### Step 2: Protect the dashboard view

Add the following view to `tasks/views.py`:

```python
@login_required
def dashboard(request):    
    return render(request, "tasks/dashboard.html")
```

Let's understand each part.

`@login_required`

This tells Django to check whether the user is authenticated before running the `dashboard()` view.

- If the user is logged in, Django allows the view to run.
- If the user is not logged in, Django redirects them to the login page.

`def dashboard(request):`

This defines a Django view function named `dashboard`.

\- `request` contains information about the incoming HTTP request, including the current user's authentication status.

`return render(request, "tasks/dashboard.html")`

This tells Django to render the `dashboard.html` template and return it as the response.

The template must exist at the expected location. With the usual app template structure, create:

`tasks/templates/tasks/dashboard.html`

For example, it can contain:

```
<h1>Dashboard</h1>
<p>Welcome to your Task Manager!</p>
```

This is only a basic dashboard for now. We can add the task information later.

### Step 3: Add the dashboard URL

In `config/urls.py`, add the dashboard URL pattern:

```
path("dashboard/", views.dashboard, name="dashboard"),
```

This connects the URL `/dashboard/` to the `dashboard()` view.

- `dashboard/` is the URL path.
- `views.dashboard` is the function Django calls.
- `name="dashboard"` gives the URL a name that can be used in redirects and templates.

Now, when someone opens `http://127.0.0.1:8000/dashboard/`, Django calls the dashboard view and checks whether the user is logged in.

### Step 4: Configure the login redirect

In `config/settings.py`, configure these settings:

```python
LOGIN_URL = "/login/"
LOGIN_REDIRECT_URL = "/dashboard/
LOGOUT_REDIRECT_URL = "/login/"
```

These settings control where users are sent during authentication:

- `LOGIN_URL`: the login page used when an unauthenticated user tries to access a protected page.
- `LOGIN_REDIRECT_URL`: the destination after a successful login, unless the login request specifies a valid `next` destination.
- `LOGOUT_REDIRECT_URL`: the destination after logout.

Important: If your current home page is `/` and you haven't created the dashboard yet, either create the dashboard as shown above or keep `LOGIN_REDIRECT_URL = "/"`. The redirect destination must match a URL that actually exists.

### Step 5: Test the protection

1. Log out of the application.
2. Open `http://127.0.0.1:8000/dashboard/` directly.
3. Django should redirect you to `/login/`.
4. Log in with your account.
5. Open the dashboard again. It should now be accessible.

### What have we learned?

The `login_required` decorator protects a view from unauthenticated access. It does not, by itself, ensure that users can only see their own tasks. We will need to filter task records by the logged-in user when we implement user-specific task management.