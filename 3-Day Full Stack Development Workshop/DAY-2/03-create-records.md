# 3. Create Records

In `tasks/views.py`:

```python
from django.shortcuts import redirect, render
from .forms import TaskForm

def task_create(request):
    if request.method == "POST":
        form = TaskForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("home")
    else:
        form = TaskForm()

    return render(request, "tasks/task_form.html", {"form": form})
```

Add to `tasks/urls.py`:

```python
path("tasks/new/", views.task_create, name="task_create"),
```

Create `tasks/templates/tasks/task_form.html`:

```html
<h1>Add Task</h1>

<form method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <button type="submit">Save Task</button>
</form>

<a href="{% url 'home' %}">Back</a>
```

GET displays the form. POST validates and saves it.
