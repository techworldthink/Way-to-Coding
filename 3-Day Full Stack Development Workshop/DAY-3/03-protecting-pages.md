# 3. Protecting Pages

Use Django's `login_required` decorator:

```python
from django.contrib.auth.decorators import login_required

@login_required
def dashboard(request):
    return render(request, "tasks/dashboard.html")
```

URL:

```python
path("dashboard/", views.dashboard, name="dashboard"),
```

Now unauthenticated users are redirected to the login page.

A protected page should require authentication before displaying private data or performing private actions.
