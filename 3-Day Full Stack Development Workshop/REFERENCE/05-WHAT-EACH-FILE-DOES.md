# What Each File Does

## Project files

### manage.py
Runs Django commands.

### settings.py
Controls project configuration.

### urls.py
Maps URLs to Django applications.

## App files

### models.py
Defines database data structures.

### views.py
Contains request/response logic.

### forms.py
Defines forms and validation.

### admin.py
Controls Django Admin.

### urls.py
Maps app URLs to views.

### migrations/
Stores database change instructions.

## Templates

### base.html
Shared layout.

### task_list.html
Displays tasks.

### task_form.html
Create/edit form.

### task_confirm_delete.html
Delete confirmation.

### dashboard.html
Statistics page.

### registration/
Login and registration pages.

## Mental model

If you receive a URL such as:

```text
/edit/7/
```

ask:

1. Which URL pattern matches it?
2. Which view is called?
3. What database object does the view load?
4. What happens to submitted data?
5. Which template is returned?
