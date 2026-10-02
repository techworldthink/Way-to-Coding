# Final Project Structure

A completed project should look approximately like:

```text
campus-task-manager/
│
├── manage.py
├── requirements.txt
├── .gitignore
├── db.sqlite3
│
├── campus_manager/
│   ├── __init__.py
│   ├── settings.py
│   ├── urls.py
│   ├── asgi.py
│   └── wsgi.py
│
├── tasks/
│   ├── __init__.py
│   ├── admin.py
│   ├── apps.py
│   ├── forms.py
│   ├── models.py
│   ├── urls.py
│   ├── views.py
│   ├── tests.py
│   └── migrations/
│
└── templates/
    ├── base.html
    ├── registration/
    │   ├── login.html
    │   └── register.html
    └── tasks/
        ├── dashboard.html
        ├── task_list.html
        ├── task_form.html
        └── task_confirm_delete.html
```

## Request flow examples

### View tasks

```text
GET /
 ↓
tasks.urls
 ↓
task_list()
 ↓
Task.objects.filter(...)
 ↓
task_list.html
 ↓
Browser
```

### Create task

```text
GET /create/
 ↓
Show form

POST /create/
 ↓
Validate
 ↓
Assign request.user
 ↓
Save
 ↓
Redirect
```

### Login

```text
POST /login/
 ↓
authenticate()
 ↓
login()
 ↓
session created
 ↓
dashboard
```
