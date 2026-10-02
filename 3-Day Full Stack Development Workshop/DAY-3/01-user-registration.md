# 1. User Registration

Django includes a built-in authentication system.

In `tasks/forms.py`:

```python
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User

class RegisterForm(UserCreationForm):
    class Meta:
        model = User
        fields = ["username", "password1", "password2"]
```

View:

```python
from django.contrib.auth import login

def register(request):
    if request.method == "POST":
        form = RegisterForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            return redirect("dashboard")
    else:
        form = RegisterForm()

    return render(request, "tasks/register.html", {"form": form})
```

URL:

```python
path("register/", views.register, name="register"),
```

Registration creates a Django user and logs that user in.
