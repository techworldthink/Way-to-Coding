# Step 4 — Django Admin

Django provides an administration interface so developers can manage database records.

## Register Task

Open:

```text
tasks/admin.py
```

Use:

```python
from django.contrib import admin
from .models import Task

admin.site.register(Task)
```

## Create an administrator

```bash
python manage.py createsuperuser
```

Enter:
- username
- email (optional depending on configuration)
- password

Do not share the password.

## Start server

```bash
python manage.py runserver
```

Open:

```text
http://127.0.0.1:8000/admin/
```

Log in.

You should see Tasks.

## Add sample tasks

Create 3–5 records, for example:

1. Complete Python Assignment
2. Prepare Presentation
3. Learn Django Models
4. Build Mini Project
5. Read Documentation

## Why are we using Admin?

It lets us quickly put test data into the database.

Later, users will create tasks through our own frontend.

## Checkpoint

If you create a task in Admin and refresh the Tasks list, it should remain stored in the database.
