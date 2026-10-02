# 1. Django Forms

Create `tasks/forms.py`:

```python
from django import forms
from .models import Task

class TaskForm(forms.ModelForm):
    class Meta:
        model = Task
        fields = ["title", "description", "completed"]
```

A `ModelForm` connects form fields to a model and provides validation.

The user will submit the form instead of using the admin site.
