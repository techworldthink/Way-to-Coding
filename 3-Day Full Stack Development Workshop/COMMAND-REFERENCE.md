# Command Reference

## Virtual environment

Windows:
```bash
python -m venv venv
venv\Scripts\activate
```

macOS/Linux:
```bash
python3 -m venv venv
source venv/bin/activate
```

## Install Django
```bash
pip install django
```

## Project and app
```bash
django-admin startproject config .
python manage.py startapp tasks
```

## Run
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

## Requirements
```bash
pip freeze > requirements.txt
```

## Git
```bash
git init
git add .
git commit -m "Complete Django task manager"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```
