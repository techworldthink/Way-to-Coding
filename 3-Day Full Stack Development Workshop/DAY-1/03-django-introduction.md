# 3. Django Introduction

Now that we understand how a web application works, let's look at **Django**, the technology we will use to build our application.

## What Is Django?

**Django is a web framework for Python.**

Before understanding what a framework is, think about building a house.

If you build everything from the beginning, you need to create the foundation, walls, doors, windows, electrical system, and many other things yourself.

But if you have a good structure already prepared, you can focus on building the things you actually need.

A web framework works in a similar way.

Django provides many of the common things required to build a web application, so we don't have to build everything from scratch.

---

## Why Do We Use Django?

A web application needs to perform many common tasks.

For example:

* Decide what should happen when a user visits a URL
* Process requests from the browser
* Work with a database
* Display information on webpages
* Accept information from users through forms
* Allow users to log in and log out

Django provides tools to handle these tasks.

For example:

```text
User visits /tasks/
        ↓
Django finds the URL
        ↓
Django calls the appropriate view
        ↓
View gets data from the database
        ↓
Django displays the data in a webpage
```

This is why Django makes it easier to build complete web applications using Python.

---

## Some Important Django Features

Django provides tools for:

* **URL routing** — deciding which code handles a URL
* **Views** — handling application requests and logic
* **Templates** — creating HTML pages
* **Models** — working with database data
* **Migrations** — creating and updating database structures
* **Forms** — collecting and validating user input
* **Authentication** — handling users, login, and logout
* **Admin** — managing application data through an administration interface

We will learn these features gradually throughout the workshop.

---

## Django in Our Workshop

We will use Django to build our **Task Manager** application.

The basic structure will be:

```text
Browser
   ↓
Django
   ↓
SQLite Database
```

Django will handle the application logic and communicate with the database, while HTML and CSS will be used to create the pages that users see.

We will learn Django by **building the application step by step**, rather than learning all of Django before writing any code.

For this workshop, we will use **Django + SQLite** because they provide a simple setup that allows us to focus on understanding the basic concepts of web application development.
