# 5. Django App Structure

Important files:

```text
manage.py
config/
    settings.py
    urls.py
    asgi.py
    wsgi.py
tasks/
    admin.py
    apps.py
    models.py
    views.py
    migrations/
```

`manage.py` runs Django commands.

`settings.py` contains project configuration.

`urls.py` connects browser paths to views.

`models.py` defines database data.

`views.py` handles requests and responses.

An app represents one area of functionality inside a Django project.
