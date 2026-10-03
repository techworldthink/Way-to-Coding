# 2. Basic Web Application Flow

Now that we understand what a web application is, let's see what happens when a user opens a page.

Imagine a user opens:

```text
http://localhost:8000/tasks/
```

The browser sends a request to our application asking:

> "I want to see the Tasks page."

The application then needs to figure out what page to show and what information to display.

A simplified flow looks like this:

```text
User
 ↓
Browser
 ↓
URL
 ↓
Django
 ↓
Application Logic
 ↓
Database
 ↓
Web Page
 ↓
Browser
```

Let's understand each step.

### 1. Browser

The user opens a webpage using a browser such as Chrome or Firefox.

### 2. URL

The URL tells the application which page the user wants.

For example:

```text
/tasks/
```

This could represent the Tasks page in our application.

### 3. Django Finds the Correct Code

Django checks the URL and finds which part of our application should handle that request.

### 4. View

The **view** contains the logic for handling the request.

For example, it can say:

> "Get the user's tasks from the database and display them."

### 5. Database

The application gets the required information from the database.

For our Task Manager, this could be:

```text
Task 1 — Complete assignment
Task 2 — Learn Django
Task 3 — Build project
```

### 6. Template

Django then uses a **template** to decide how this information should appear on the webpage.

The template contains the HTML structure of the page.

### 7. Browser Displays the Page

Finally, Django sends the generated HTML back to the browser.

The browser displays the page to the user.

So the complete simplified flow is:

```text
Browser
   ↓
URL
   ↓
Django URL
   ↓
View
   ↓
Database
   ↓
Template
   ↓
HTML
   ↓
Browser
```

### A Simple Django Idea

As we start working with Django, you will frequently see these four terms:

```text
URL → View → Model → Template
```

In simple words:

* **URL** → Which page was requested?
* **View** → What should the application do?
* **Model** → How do we work with the database?
* **Template** → What should the user see?

We will learn each of these step by step while building our Task Manager application.
