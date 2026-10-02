# What Is Full Stack Development?

Before learning Full Stack Development, let's first understand what a **web application** is.

## What Is a Web Application?

A web application is a software application that we use through a web browser.

For example:

* Gmail — sending and receiving emails
* YouTube — watching videos
* Amazon — buying products
* Online banking — managing your bank account
* A Task Manager — creating and managing tasks

When we use these applications, we normally see a webpage with buttons, text boxes, menus, images, and other elements.

But there is much more happening behind that page.

For example, when you create a task in a Task Manager:

```text
You enter a task
       ↓
The application receives it
       ↓
The application processes it
       ↓
The task is stored
       ↓
The task appears on the screen
```

So, a web application has different parts working together.

---

# The Three Main Parts of a Web Application

A simple way to understand a web application is to divide it into three parts:

### 1. Frontend — What the User Sees

The **frontend** is the visible part of the application.

It includes things such as:

* Text
* Buttons
* Forms
* Menus
* Tables
* Pages
* Colors and layouts

For example, when you open a Task Manager and see:

```text
My Tasks

[ Buy groceries       ] [Edit] [Delete]

[ Complete assignment ] [Edit] [Delete]

[ + Add Task ]
```

Everything you see and interact with is part of the frontend.

---

### 2. Backend — What Happens Behind the Screen

The **backend** is the part of the application that works behind the scenes.

The user normally does not see it directly.

For example, when you click **Add Task**, the backend can:

1. Receive the information you entered.
2. Check whether the information is valid.
3. Process the request.
4. Save the task.
5. Send a response back to the webpage.

So, the backend is responsible for the **logic and processing** of the application.

---

### 3. Database — Where Information Is Stored

Applications usually need to remember information.

For example, a Task Manager needs to remember:

* Task name
* Task description
* Whether the task is completed
* When the task was created

This information can be stored in a **database**.

Think of a database as an organized digital storage system for an application.

When you create a task, the application can store it in the database.

Later, when you open the Task Manager again, the application can retrieve the task from the database and show it to you.

---

# How Do These Parts Work Together?

Let's take a simple example.

Suppose you type:

```text
Complete Django assignment
```

and click **Add Task**.

The process is roughly:

```text
        USER
          ↓
       Frontend
          ↓
        Backend
          ↓
       Database
          ↓
        Backend
          ↓
       Frontend
          ↓
        USER
```

The frontend collects the information.

The backend processes it.

The database stores it.

The backend gets the result and sends it back to the frontend.

The frontend then shows the result to the user.

This interaction happens very quickly, so we normally don't notice all these steps.

---

# Then What Does "Full Stack" Mean?

Now we can understand the term **Full Stack Development**.

A **Full Stack Developer** works with the different parts required to build a complete web application.

That includes:

```text
Frontend
   +
Backend
   +
Database
   =
Complete Web Application
```

Instead of working only on the webpage or only on the server-side code, Full Stack Development gives us an understanding of the **complete application** and how its different parts communicate with each other.

---

# Technologies We Will Use in This Workshop

Now that we understand the basic idea, let's look at the technologies we will use.

### Frontend

We will use:

* **HTML** — to create the structure of webpages
* **CSS** — to control the appearance and layout
* **Bootstrap** — to make the interface cleaner and responsive

### Backend

We will use:

* **Python** — the programming language
* **Django** — a Python framework used to build web applications

### Database

We will use:

* **SQLite** — a simple database that is suitable for our workshop project

### Version Control

We will also use:

* **Git** — to track changes in our project
* **GitHub** — to store and share our project online

So our workshop technology stack is:

```text
Frontend
HTML + CSS + Bootstrap
          ↓
Backend
Python + Django
          ↓
Database
SQLite
          ↓
Version Control
Git + GitHub
```

During this workshop, we will not study these technologies separately. Instead, we will learn them **while building one complete application — a Task Manager**.

By the end of the three days, we will have connected the frontend, backend, and database into one working web application.
