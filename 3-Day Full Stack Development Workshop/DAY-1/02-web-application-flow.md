# 2. Basic Web Application Flow

A simplified Django request flow is:

```text
Browser
 ↓
URL
 ↓
Django URL configuration
 ↓
View
 ↓
Model / Database
 ↓
Template
 ↓
HTML response
 ↓
Browser
```

For example, `/tasks/` is matched by a URL pattern, which calls a view. The view can read the database and pass data to a template.

A key Django idea is:

```text
URL → View → Model → Template
```
