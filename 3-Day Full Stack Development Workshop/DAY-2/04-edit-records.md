# 4. Edit Records

Add:

```python
from django.shortcuts import get_object_or_404

def task_edit(request, pk):
    task = get_object_or_404(Task, pk=pk)

    if request.method == "POST":
        form = TaskForm(request.POST, instance=task)
        if form.is_valid():
            form.save()
            return redirect("home")
    else:
        form = TaskForm(instance=task)

    return render(request, "tasks/task_form.html", {
        "form": form,
        "task": task,
    })
```

URL:

```python
path("tasks/<int:pk>/edit/", views.task_edit, name="task_edit"),
```

The `instance` tells Django which existing record should be edited.

Add an edit link to the task list:

```html
<a href="{% url 'task_edit' task.pk %}">Edit</a>
```
