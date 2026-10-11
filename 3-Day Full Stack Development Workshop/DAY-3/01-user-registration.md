# 1. User Registration

Until now, our Task Manager application has allowed users to create, view, and edit tasks. However, anyone who opens the application can potentially access the same task list.

In a real application, we usually want each user to have an account so that they can log in and manage their own tasks.

**User registration** is the process of creating a new user account in an application.

For example, a user might register with a username and password. Django stores the user account in the database, and the user can subsequently log in using their credentials.

## What Is Django Authentication?

Authentication is the process of verifying who a user is.

Django includes a built-in authentication system that provides functionality for:

- Creating user accounts.
- Checking usernames and passwords during login.
- Managing logged-in users through sessions.
- Logging users out.
- Supporting permissions and access restrictions.

Instead of implementing all these features ourselves, we can use Django's existing authentication functionality.

In this section, we will implement user registration for our Task Manager application.

## 1.1 Create the Registration Form

Open `tasks/forms.py` and add the following code:

```python
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User

class RegisterForm(UserCreationForm):
    class Meta:
        model = User
        fields = ["username", "password1", "password2"]
```

Let's understand each part.

**1. Import `UserCreationForm`**

```python
from django.contrib.auth.forms import UserCreationForm
```

Django provides `UserCreationForm` specifically for creating new user accounts.

It already includes functionality for handling passwords and checking that the submitted password values match.

We do not need to build all these features from scratch.

**2. Import the User model**

```python
from django.contrib.auth.models import User
```

Django provides a built-in `User` model that represents user accounts.

It stores information such as the username, password hash, and account status.

Passwords are not stored as plain text. Django's authentication system stores password hashes and verifies passwords using its password-hashing mechanisms.

**3. Create our registration form**

```python
class RegisterForm(UserCreationForm):
```

We create a class named `RegisterForm` that inherits from `UserCreationForm`.

Inheritance allows us to reuse the functionality Django has already implemented for user registration.

**4. Configure the form**

```python
class Meta:
    model = User
    fields = ["username", "password1", "password2"]
```

Here, we specify that our form is associated with Django's `User` model.

The selected fields are:

- `username`: The name the user will use to identify their account.
- `password1`: The password the user wants to set.
- `password2`: A second password entry used to confirm that both password entries match.

Notice that `password1` and `password2` are fields provided by `UserCreationForm`. They are not fields stored directly in the `User` database model.

Django also applies its configured password validation rules when validating the registration form.

## 1.2 Create the Registration View

Now we need a view to display the registration form and process the submitted details.

Add the following code to `tasks/views.py`:

```python
from django.contrib.auth import login
from .forms import RegisterForm

def register(request):
    if request.method == "POST":
        form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            return redirect("/")
    else:
        form = RegisterForm()

    return render(request, "tasks/register.html", {"form": form})
```

Make sure `views.py` also imports `RegisterForm`, `redirect`, and `render` from the appropriate modules.

Let's understand the workflow.

**1. Define the registration view**

```python
def register(request):
```

This function handles requests to the registration page.

It displays the form when the user first visits the page and processes the submitted information when the user registers.

**2. Check whether the form was submitted**

```python
if request.method == "POST":
```

When a user submits the registration form, the browser sends a POST request containing the entered information.

Django receives this request and passes the submitted data to the form.

**3. Create a form with the submitted data**

```python
form = RegisterForm(request.POST)
```

`request.POST` contains the username and password values submitted by the browser.

Django uses these values to populate the registration form.

**4. Validate the registration details**

```python
if form.is_valid():
```

Before creating an account, Django validates the submitted information.

For example, it checks that:

- The required username is provided.
- The username satisfies the applicable validation rules and is not already in use.
- Both password entries match.
- The password satisfies the configured password validation requirements.

If validation fails, Django does not create the account. The form is displayed again with the relevant errors so the user can correct them.

**5. Create the user account**

```python
user = form.save()
```

If the form is valid, `form.save()` creates a new user record in the database and returns the resulting user object.

The user's password is processed using Django's password-hashing system rather than being stored as plain text.

We assign the returned object to `user` because we will need it in the next step.

**6. Log in the newly registered user**

```python
login(request, user)
```

Creating an account and logging in are two different operations.

Creating an account stores the user's information in the database. Logging in establishes an authenticated session for that user.

Here, Django logs in the newly registered user, so the user does not need to visit a separate login page immediately after registration.

**7. Redirect to the dashboard**

```python
return redirect("dashboard")
```

After successful registration and login, the user is redirected to the URL named `dashboard`.

This URL name must exist in your project's URL configuration. We will use the dashboard as the destination after registration.

**8. Display an empty form for GET requests**

```python
else:
    form = RegisterForm()
```

When the user first opens the registration page, Django creates an empty registration form.

Finally:

```python
return render(request, "tasks/register.html", {"form": form})
```

This displays the registration template and passes the form to it.

If validation fails, the same statement renders the form again with the entered values and validation errors.

## 1.3 Add the Registration URL

Open `tasks/urls.py` and add this URL pattern to the existing `urlpatterns` list:

```python
path("register/", views.register, name="register"),
```

This connects the `/register/` URL to the `register` view.

The URL name `register` allows us to refer to this route elsewhere in our application without hardcoding the complete URL.

Make sure the file imports `path` and `views` as required by your existing configuration.

## 1.4 Create the Registration Template

Create the file `tasks/templates/tasks/register.html`:

```html
<h1>Create an Account</h1>

<form method="post">
    {% csrf_token %}
    {{ form.as_p }}

    <button type="submit">Register</button>
</form>
```

Let's understand the important parts.

- `<form method="post">` submits the registration details to Django using a POST request.
- `{% csrf_token %}` adds the CSRF protection token required for a standard protected POST form.
- `{{ form.as_p }}` displays the fields generated by `RegisterForm`, including the username and password fields, along with applicable help text and validation errors.
- The Register button submits the form.

Because we are using Django's form system, we do not need to manually create the username and password inputs or implement the basic password validation ourselves.

## 1.5 Test User Registration

Start the development server if it is not already running:

```bash
python manage.py runserver
```

Open this URL:

`http://127.0.0.1:8000/register/`

Now try the following:

1. Enter a new username.
2. Enter a password. (Ex@mpLe@1243)
3. Enter the same password again in the confirmation field.
4. Click Register.
5. If the details are valid, Django creates the user, logs them in, and redirects them to the dashboard.

You can also test validation by entering a username that already exists or entering two different passwords.

Django should display the relevant validation errors instead of creating an invalid account.

## 1.6 Important: What About the Dashboard?

Our registration view redirects the user to `dashboard`, so your application must have a URL pattern named `dashboard`.

Also, registration alone does not automatically make the task list private. At this stage, we have created accounts and logged users in, but we have not yet restricted access to the task pages or ensured that each user sees only their own tasks.

We will address access control and user-specific tasks as part of completing the authentication functionality.

**Key takeaway:** Django's built-in authentication tools save us from implementing account creation and password handling from scratch. Our `RegisterForm` collects and validates registration details, the view creates the account, and `login()` starts an authenticated session for the newly registered user.