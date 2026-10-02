# 7. Create a Simple Database Model

In `tasks/models.py`:

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

`title` stores short text.

`description` stores longer text.

`completed` stores true/false.

`created_at` records when the task was created.

A model lets us describe database data using Python.
