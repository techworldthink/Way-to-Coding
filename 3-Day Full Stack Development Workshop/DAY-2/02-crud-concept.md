# 2. CRUD Concept

CRUD is a common term in software development. It represents the four basic operations we perform when managing data in an application.

CRUD stands for:

```text
C → Create
R → Read
U → Update
D → Delete
```

Almost every application that manages data uses these operations in some form.

For example, consider applications such as a student management system, an inventory application, or our Task Manager. Users need to add new information, view existing information, modify it, and remove it when it is no longer needed.

Let's understand each operation using our Task Manager application.

## 2.1 Create

**Create means adding new data to the application.**

Suppose a user wants to add a new task:

- Title: Complete Django homework
- Description: Finish the exercises given in the workshop.
- Completed: No

The user enters these details into a form and submits it. Our Django application processes the submitted data and saves the new task to the database.

In our application, we will use a Django Form to collect the task details and a view to validate and save them.

## 2.2 Read

**Read means retrieving and displaying existing data.**

Our application already has this functionality.

For example, when the user opens the task list page, the application retrieves the existing tasks from the database and displays them.

A task list might look like this:

| Title | Status |
|---|---|
| Complete Django homework | Pending |
| Read Python documentation | Completed |
| Practise HTML and CSS | Pending |

The user can see the tasks without accessing the database directly.

In Django, we typically retrieve these records through the model and pass them to a template for display.

## 2.3 Update

**Update means modifying existing data.**

Suppose a user created a task but later wants to change its description or mark it as completed.

Instead of creating another task, the user should be able to open the existing task, edit its details, and save the changes.

For example:

Before updating:

```text
Title: Complete Django homework
Completed: No
```

After updating:

```text
Title: Complete Django homework
Completed: Yes
```

Django can use the same `TaskForm` we created earlier to edit an existing task. The form is connected to the existing task instance, so saving it updates that record rather than creating a new one.

## 2.4 Delete

**Delete means removing existing data from the application.**

Suppose a user created a task by mistake or no longer needs it.

The application should provide an option to delete that task.

For example:

```text
Task: Practise HTML and CSS

[Edit] [Delete]
```

When the user chooses Delete and confirms the action, the application removes the corresponding task record from the database.

We should use a POST request for the deletion and include CSRF protection, rather than deleting records through a simple GET link.

## 2.5 How CRUD Works in Our Task Manager

Let's connect all four operations to our project.

| Operation | User action | Result |
|---|---|---|
| Create | Add a task | A new task is saved |
| Read | Open the task list | Existing tasks are displayed |
| Update | Edit a task | An existing task is modified |
| Delete | Delete a task | A task is removed |

Together, these operations allow users to manage their tasks without directly interacting with the database or using Django's admin site.

## 2.6 What Will We Build on Day 2?

Our application already supports **Read**, so we will extend it with the remaining operations.

- **Create:** Add new tasks using a Django Form.
- **Update:** Edit existing tasks using the same form.
- **Delete:** Remove tasks safely.
- **Basic styling:** Use Bootstrap to make the pages easier to use and more presentable.

By the end of this section, students will have implemented the core CRUD functionality of the Task Manager.

**Key takeaway:** CRUD is the foundation of data management in many applications. Once you understand how to implement these four operations, you can apply the same concepts to student records, products, expenses, employees, and many other types of data.