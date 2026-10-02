# Command Reference

## Environment

```bash
python -m venv venv
```

Windows:

```text
venv\Scripts\activate
```

Linux/macOS:

```bash
source venv/bin/activate
```

## Packages

```bash
pip install django
pip freeze > requirements.txt
```

## Project

```bash
django-admin startproject campus_manager .
python manage.py startapp tasks
```

## Development

```bash
python manage.py runserver
```

## Database

```bash
python manage.py makemigrations
python manage.py migrate
```

## Admin

```bash
python manage.py createsuperuser
```

## Diagnostics

```bash
python manage.py check
python manage.py showmigrations
```

## Git

```bash
git init
git status
git add .
git commit -m "Workshop project"
git branch -M main
git remote add origin YOUR_REPOSITORY_URL
git push -u origin main
```
