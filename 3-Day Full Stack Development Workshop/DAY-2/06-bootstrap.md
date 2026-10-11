# 6. Basic Bootstrap Styling

So far, our Task Manager works, but the pages look very basic. We can use CSS to improve their appearance.

**Bootstrap** is a CSS framework that provides ready-made styles for buttons, forms, tables, navigation bars, and other webpage elements. Instead of writing all the CSS ourselves, we can use Bootstrap classes.

## Step 1: Load Bootstrap

We will use Bootstrap through a CDN (Content Delivery Network). This allows the browser to download Bootstrap from an online server.

Add this line inside the `<head>` section of your HTML:

```html
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
>
```

An internet connection is required to load Bootstrap using this method.

## Step 2: Create a Base Template

Most pages in our application share common elements, such as the page structure, navigation bar, and Bootstrap stylesheet.

Instead of repeating this code on every page, Django allows us to create a **base template** and reuse it.

Create the following file:

`tasks/templates/tasks/base.html`

Add this code:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>{% block title %}Task Manager{% endblock %}</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
    >
</head>
<body class="bg-light">

    <nav class="navbar navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="{% url 'home' %}">
                Task Manager
            </a>
        </div>
    </nav>

    <main class="container">
        {% block content %}{% endblock %}
    </main>

</body>
</html>
```

### Understanding the important parts

- `navbar` creates a navigation bar.
- `bg-dark` gives it a dark background.
- `container` keeps content aligned and provides spacing.
- `{% block title %}` allows each page to define its own title.
- `{% block content %}` marks the area where each page's content will appear.

The base template provides the common layout. Individual pages will supply their own content.

## Step 3: Update the Home Page

Open your existing home page template:

`tasks/templates/tasks/home.html`

Replace its contents with the following example, adapting the task fields and URL names if your existing code uses different ones:

```html
{% extends "tasks/base.html" %}

{% block title %}My Tasks{% endblock %}

{% block content %}

<div class="d-flex justify-content-between align-items-center mb-4">
    <h1>My Tasks</h1>

    <a href="{% url 'task_create' %}" class="btn btn-primary">
        Add Task
    </a>
</div>

<div class="card">
    <div class="card-body">

        {% for task in tasks %}
            <div class="border-bottom py-3">
                <h5>{{ task.title }}</h5>

                <p class="text-muted">
                    {{ task.description }}
                </p>

                <a href="{% url 'task_edit' task.pk %}"
                   class="btn btn-sm btn-primary">
                    Edit
                </a>

                <a href="{% url 'task_delete' task.pk %}"
                   class="btn btn-sm btn-danger">
                    Delete
                </a>
            </div>
        {% empty %}
            <p class="text-muted mb-0">
                No tasks available. Click Add Task to create one.
            </p>
        {% endfor %}

    </div>
</div>

{% endblock %}
```

This example assumes your view passes the task list using the name `tasks`, and your edit URL is named `task_edit`. Keep your existing view and URL names consistent with the template.

Notice that we use:

```html
{% extends "tasks/base.html" %}
```

This tells Django to use the base template.

The content between `{% block content %}` and `{% endblock %}` is inserted into the base template's content block.

## Step 4: Apply Bootstrap to the Task Form

Open the existing template:

`tasks/templates/tasks/task_form.html`

Update it to use the base template and Bootstrap styling:

```html
{% extends "tasks/base.html" %}

{% block title %}Task Form{% endblock %}

{% block content %}

<div class="card">
    <div class="card-body">

        <h1 class="mb-4">
            {% if task %}Edit Task{% else %}Add Task{% endif %}
        </h1>

        <form method="post">
            {% csrf_token %}

            {{ form.as_p }}

            <button type="submit" class="btn btn-primary">
                Save Task
            </button>

            <a href="{% url 'home' %}" class="btn btn-secondary">
                Cancel
            </a>
        </form>

    </div>
</div>

{% endblock %}
```

This template supports both creating and editing tasks, provided the edit view passes `task` to the template.

**Note:** `{{ form.as_p }}` generates the form fields, but it does not automatically add Bootstrap's `form-control` class to every input. We can improve the form styling further later.

## Step 5: Apply Bootstrap to the Delete Confirmation Page

Open:

`tasks/templates/tasks/task_confirm_delete.html`

Update it to:

```html
{% extends "tasks/base.html" %}

{% block title %}Delete Task{% endblock %}

{% block content %}

<div class="card">
    <div class="card-body">

        <h1>Delete Task</h1>

        <p>
            Are you sure you want to delete
            <strong>{{ task.title }}</strong>?
        </p>

        <form method="post">
            {% csrf_token %}

            <button type="submit" class="btn btn-danger">
                Yes, Delete
            </button>

            <a href="{% url 'home' %}" class="btn btn-secondary">
                Cancel
            </a>
        </form>

    </div>
</div>

{% endblock %}
```

## Step 6: Test the Application

Run the development server:

```bash
python manage.py runserver
```

Open the Task Manager in your browser and check:

1. The navigation bar appears at the top.
2. The task list is displayed inside a card.
3. The Add Task, Edit, and Delete buttons have Bootstrap styling.
4. The task form uses the same layout as the home page.
5. The delete confirmation page uses the same layout.
6. All existing features still work.

## What We Learned

- Bootstrap provides ready-made CSS classes.
- A base template lets us reuse common HTML.
- Django's `{% extends %}` and `{% block %}` tags support template inheritance.
- Bootstrap classes such as `btn`, `btn-primary`, `btn-danger`, and `card` help improve the interface without writing all the CSS ourselves.