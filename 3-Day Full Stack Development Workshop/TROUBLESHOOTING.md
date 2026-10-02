# Troubleshooting

### `No module named django`
Activate the virtual environment and run `pip install django`.

### `can't open file manage.py`
Change directory to the folder containing `manage.py`.

### Port 8000 is busy
Run `python manage.py runserver 8001`.

### Templates are not found
Check that templates are inside `tasks/templates/tasks/` and that `tasks` is in `INSTALLED_APPS`.

### Model changes are not reflected
Run:
```bash
python manage.py makemigrations
python manage.py migrate
```

### Git includes `venv`
Ensure `venv/` is in `.gitignore`.
