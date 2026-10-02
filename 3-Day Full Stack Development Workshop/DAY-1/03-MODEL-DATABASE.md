# Step 3 — Create the Task Model and Database

A model is Python code that describes data we want Django to store.

For example, a Task needs:
- title
- description
- completed status
- creation time

## Open

```text
tasks/models.py
```

Replace its contents with:

```python
from django.db import models


class Task(models.Model):
    title = models.CharField(max_length=200)
    description = models.TextField(blank=True)
    completed = models.BooleanField(default=False)
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.title
```

## What does each field mean?

### title

```python
models.CharField(max_length=200)
```

A short text value with a maximum length of 200 characters.

### description

```python
models.TextField(blank=True)
```

Longer text.

`blank=True` means the form is allowed to leave it empty.

### completed

```python
models.BooleanField(default=False)
```

Stores either `True` or `False`.

New tasks start as incomplete.

### created_at

```python
models.DateTimeField(auto_now_add=True)
```

Django automatically records when the object is first created.

### __str__

```python
def __str__(self):
    return self.title
```

This makes Task objects display with their title in places such as Django Admin.

## Model → migration → database

Django does not immediately change the database when you edit `models.py`.

First create a migration:

```bash
python manage.py makemigrations
```

Then apply it:

```bash
python manage.py migrate
```

Think of this as:

```text
Python Model
    ↓
Migration instructions
    ↓
Database table
```

## What is SQLite?

Django's default workshop database is SQLite.

It is a small file-based database, convenient for learning.

You should see:

```text
db.sqlite3
```

in the project folder.

## Important

Do not manually edit `db.sqlite3`.

Use Django models and migrations.

## Check

Run:

```bash
python manage.py check
```

Then:

```bash
python manage.py showmigrations
```

You should see migrations marked as applied.
