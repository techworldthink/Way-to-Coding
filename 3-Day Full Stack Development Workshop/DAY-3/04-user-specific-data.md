# 4. User-Specific Data

Each task must belong to the user who created it.

Update the model:

```python
from django.conf import settings

owner = models.ForeignKey(
    settings.AUTH_USER_MODEL,
    on_delete=models.CASCADE,
    related_name="tasks",
)
```

Run:

```bash
python manage.py makemigrations
python manage.py migrate
```

For a classroom project with old sample records, a clean Day 3 database can be used: stop the server, delete `db.sqlite3`, run `python manage.py migrate`, and create a new superuser if required.

When creating a task:

```python
task = form.save(commit=False)
task.owner = request.user
task.save()
```

When listing tasks:

```python
tasks = Task.objects.filter(owner=request.user)
```

When editing/deleting:

```python
task = get_object_or_404(
    Task,
    pk=pk,
    owner=request.user,
)
```

This is important: ownership must be checked on the server/database query, not only hidden in the HTML.

A user should never be able to edit another user's task simply by changing an ID in the URL.
