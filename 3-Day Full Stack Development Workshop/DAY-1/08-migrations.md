# 8. Run Migrations

Create migration instructions:

```bash
python manage.py makemigrations
```

Apply them:

```bash
python manage.py migrate
```

Django now creates the database tables in SQLite.

Whenever you change a model, normally run both commands again:

```bash
python manage.py makemigrations
python manage.py migrate
```
