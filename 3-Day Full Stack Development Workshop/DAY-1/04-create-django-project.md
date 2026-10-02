# 4. Create Django Project

## 1. Check Python
```bash
python --version
```

## 2. Create a folder
```bash
mkdir django-workshop
cd django-workshop
```

## 3. Create and activate a virtual environment

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

A virtual environment keeps project packages isolated.

## 4. Install Django
```bash
pip install django
```

## 5. Create the project
```bash
django-admin startproject config .
```

## 6. Create the app
```bash
python manage.py startapp tasks
```

## 7. Add the app

Open `config/settings.py` and add `"tasks"` to `INSTALLED_APPS`.

## 8. Run the server
```bash
python manage.py runserver
```

Open `http://127.0.0.1:8000/`.
