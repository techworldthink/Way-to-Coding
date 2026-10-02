# 6. URLs, Views & Templates

Create:

```text
tasks/templates/tasks/home.html
```

`home.html`:
```html
<!DOCTYPE html>
<html>
<head>
    <title>Task Manager</title>
</head>
<body>
    <h1>Task Manager</h1>
    <p>Welcome to our Django application.</p>
</body>
</html>
```

`tasks/views.py`:
```python
from django.shortcuts import render

def home(request):
    return render(request, "tasks/home.html")
```

Create `tasks/urls.py`:
```python
from django.urls import path
from . import views

urlpatterns = [
    path("", views.home, name="home"),
]
```

Connect it in `config/urls.py`:
```python
from django.contrib import admin
from django.urls import include, path

urlpatterns = [
    path("admin/", admin.site.urls),
    path("", include("tasks.urls")),
]
```

Run the server and open `http://127.0.0.1:8000/`.

The flow is now:

```text
/ → tasks.urls → views.home → home.html
```
