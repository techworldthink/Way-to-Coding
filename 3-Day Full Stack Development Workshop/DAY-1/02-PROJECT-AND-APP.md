# Step 2 — Create the Django Project

Make sure `(venv)` appears in your terminal.

## Create the project

From inside `campus-task-manager`:

```bash
django-admin startproject campus_manager .
```

The dot (`.`) means "create the Django project in the current folder."

## What was created?

```text
campus-task-manager/
├── manage.py
└── campus_manager/
    ├── __init__.py
    ├── settings.py
    ├── urls.py
    ├── asgi.py
    └── wsgi.py
```

### manage.py

A command-line helper for Django.

Examples:

```bash
python manage.py runserver
python manage.py migrate
python manage.py makemigrations
```

### settings.py

Project configuration:
- installed apps
- database
- templates
- middleware
- static files
- security settings

### urls.py

Connects URL paths to views.

### wsgi.py / asgi.py

Entry points used when deploying Django with web servers.

You do not need to understand deployment details in this workshop.

## Start the server

```bash
python manage.py runserver
```

Open:

```text
http://127.0.0.1:8000/
```

You should see the Django welcome page.

Stop the server with:

```text
CTRL + C
```

## Create the tasks app

```bash
python manage.py startapp tasks
```

Now:

```text
campus-task-manager/
├── manage.py
├── campus_manager/
└── tasks/
    ├── admin.py
    ├── apps.py
    ├── migrations/
    ├── models.py
    ├── tests.py
    ├── views.py
    └── ...
```

## Project vs application

A **project** is the overall Django website configuration.

An **app** is a functional part of the website.

Our project:

```text
campus_manager
```

Our app:

```text
tasks
```

A larger project could contain apps such as:

```text
accounts
tasks
payments
reports
```

## Register the app

Open:

```text
campus_manager/settings.py
```

Find:

```python
INSTALLED_APPS = [
```

Add:

```python
"tasks",
```

Save the file.

## Check

Run:

```bash
python manage.py check
```

If Django reports no errors, continue.
