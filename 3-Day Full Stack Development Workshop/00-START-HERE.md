# Start Here

## 1. What are we building?

We are building a web application called **Campus Task Manager**.

A user can log in and manage personal tasks.

Example:

```text
Campus Task Manager

Welcome, Anu

Total: 5    Completed: 2    Pending: 3

[ Add Task ]

--------------------------------
Complete Python Assignment
High Priority
[Edit] [Complete] [Delete]
--------------------------------
```

## 2. What is Full Stack Development?

A full-stack application has several connected parts:

```text
Browser
  |
  | HTTP request
  v
Django Backend
  |
  | database query
  v
SQLite Database
  |
  | result
  v
Django Backend
  |
  v
HTML Template
  |
  v
Browser
```

### Frontend
The interface the user sees.

We use:
- HTML
- CSS
- Bootstrap
- small amounts of JavaScript where useful

### Backend
The server-side application.

We use:
- Python
- Django

### Database
Where data is stored.

We use:
- SQLite

## 3. What is Django?

Django is a Python web framework. It gives us tools for:
- URLs
- views
- templates
- database models
- forms
- authentication
- administration
- security features

Instead of building all of these from zero, we use Django's built-in features.

## 4. Basic Django flow

When a browser requests `/tasks/`:

```text
Browser
  |
  v
URL configuration
  |
  v
View
  |
  v
Model / Database
  |
  v
Template
  |
  v
HTML response
  |
  v
Browser
```

## 5. Before starting

Install:
- Python 3
- VS Code or another code editor
- A modern web browser
- Git (recommended)

Check Python:

```bash
python --version
```

On some Linux/macOS systems:

```bash
python3 --version
```

## 6. Workshop rule

Do not just copy code and move on.

After every major step:
1. Run the application.
2. Test what you just built.
3. Read the explanation.
4. Make the small homework change.

That is how the concepts become clear.
