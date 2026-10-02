# Troubleshooting

## 1. `No module named django`

Activate venv:

```bash
source venv/bin/activate
```

or Windows:

```text
venv\Scripts\activate
```

Then:

```bash
pip install django
```

## 2. `python` not found

Try:

```bash
python3 --version
```

If Python is not installed, install it first.

## 3. PowerShell activation problem

Use Command Prompt and:

```text
venv\Scripts\activate
```

or use your organization's approved PowerShell configuration.

## 4. Port already in use

Run:

```bash
python manage.py runserver 8001
```

Then open:

```text
http://127.0.0.1:8001/
```

## 5. TemplateDoesNotExist

Check:

```text
templates/
    tasks/
        task_list.html
```

And:

```python
"DIRS": [BASE_DIR / "templates"],
```

in settings.

## 6. No such table

Run:

```bash
python manage.py makemigrations
python manage.py migrate
```

## 7. URL not found

Check:
- `tasks/urls.py`
- `campus_manager/urls.py`
- spelling of URL names
- whether the development server needs restarting

## 8. Changes to model do not appear

Run:

```bash
python manage.py makemigrations
python manage.py migrate
```

## 9. CSS does not appear

Check that the Bootstrap `<link>` is inside `base.html` and that the browser has internet access.

## 10. User sees another user's task

This is a serious application logic issue.

Task queries should include:

```python
user=request.user
```

For object operations use:

```python
get_object_or_404(
    Task,
    id=task_id,
    user=request.user,
)
```
