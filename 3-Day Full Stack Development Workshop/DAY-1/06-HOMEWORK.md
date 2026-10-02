# Day 1 Homework

Complete the following before Day 2.

## Required

### 1. Add priority

Add:

```python
priority = models.CharField(
    max_length=10,
    default="Medium"
)
```

Run:

```bash
python manage.py makemigrations
python manage.py migrate
```

### 2. Display priority

Add to the template:

```html
<p>Priority: {{ task.priority }}</p>
```

### 3. Add at least five tasks

Use Django Admin.

## Optional

Add a due date:

```python
due_date = models.DateField(null=True, blank=True)
```

Remember to run migrations.

## Important

If you add fields to a model, Django needs a migration.

```text
Change model
    ↓
makemigrations
    ↓
migrate
```
