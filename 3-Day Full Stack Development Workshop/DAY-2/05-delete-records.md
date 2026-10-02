# 5. Delete Records

View:

```python
def task_delete(request, pk):
    task = get_object_or_404(Task, pk=pk)

    if request.method == "POST":
        task.delete()
        return redirect("home")

    return render(request, "tasks/task_confirm_delete.html", {
        "task": task,
    })
```

URL:

```python
path("tasks/<int:pk>/delete/", views.task_delete, name="task_delete"),
```

Confirmation template:

```html
<h1>Delete Task</h1>

<p>Are you sure you want to delete "{{ task.title }}"?</p>

<form method="post">
    {% csrf_token %}
    <button type="submit">Yes, Delete</button>
</form>

<a href="{% url 'home' %}">Cancel</a>
```

Use a POST request for the actual deletion.
