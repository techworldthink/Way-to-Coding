# 1. Django Forms

In our Task Manager application, we need a way for users to enter task details, such as the title, description, and completion status.

We could create an HTML form manually and write Python code to process the submitted values. However, Django provides a built-in Forms system that makes this process easier.

## What Is a Django Form?

A Django Form is a Python class that helps us collect user input, validate the submitted data, and process it on the server.

For example, when a user creates a task, they might enter the following information:

- **Title:** Complete Django homework
- **Description:** Finish the exercises given in the workshop.
- **Completed:** No

Django Forms help us handle this information before it is saved to the database.

### Why Do We Need Django Forms?

Imagine that a user enters a very long task title or submits a form without providing the required title.

If we handle all the input manually, we need to write code to check these conditions ourselves.

Django Forms simplify this process by providing several useful features:

1. **Field creation:** Django creates form fields based on our configuration.
2. **Data validation:** It checks whether submitted values satisfy the field's validation rules.
3. **Error handling:** It identifies invalid input and helps us display error messages.
4. **Data cleaning:** It converts submitted values into appropriate Python data types where necessary.
5. **Database integration:** When we use a `ModelForm`, we can save validated data to the database through the associated model.

## Understanding ModelForm

Django provides different ways to create forms. One commonly used option is `ModelForm`.

A `ModelForm` is a form that is connected to an existing Django model.

Remember that our `Task` model defines the structure of a task in the database. It specifies fields such as `title`, `description`, and `completed`.

Instead of defining these fields again manually, we can use a `ModelForm` to generate the form fields from the model.

## Creating a Task Form

Create `tasks/forms.py`:

```python
from django import forms
from .models import Task

class TaskForm(forms.ModelForm):
    class Meta:
        model = Task
        fields = ["title", "description", "completed"]
```

Let's understand each part of this code.

**1. Importing Django Forms**

```python
from django import forms
```

This imports Django's forms functionality, which allows us to create and configure forms in Python.

**2. Importing the Task Model**

```python
from .models import Task
```

We import the `Task` model because our form will be connected to it.

The dot (`.`) means that we are importing from the current Django app.

**3. Creating the Form Class**

```python
class TaskForm(forms.ModelForm):
```

Here, we create a class named `TaskForm` that inherits from Django's `ModelForm`.

Inheritance allows our class to use the functionality already provided by Django.

We do not have to implement field generation and basic validation from scratch.

**4. Configuring the Form Using Meta**

```python
class Meta:
    model = Task
    fields = ["title", "description", "completed"]
```

The inner `Meta` class provides configuration for our form.

- `model = Task` tells Django which model the form is associated with.
- `fields` specifies which model fields should be included in the form.

In this example, Django generates form fields for the task title, description, and completion status.

We can choose only the fields that users should be allowed to enter or change. The model might contain other fields that we do not want to expose in this form.

## How Does Django Generate the Fields?

Django looks at the selected fields in the `Task` model and creates corresponding form fields.

For example:

| Model field | Form field |
|---|---|
| `CharField` | Text input |
| `TextField` | Usually a multi-line text area |
| `BooleanField` | Checkbox |

This means we do not need to manually create each corresponding form field in Python.

Django also uses the model's field configuration to apply appropriate validation rules. For example, a `CharField` with `max_length=200` restricts the title to the configured maximum length.

However, remember that a form only includes the fields we select in `fields`. Connecting a form to a model does not automatically include every model field.

## How Does Form Validation Work?

Validation means checking whether the information provided by a user is acceptable.

Suppose the user submits a task with a title longer than the maximum length allowed by the model.

Django can detect this problem during form validation and report an error rather than accepting the invalid value.

Validation can include:

- Checking whether required fields have values.
- Checking maximum or minimum lengths where configured.
- Converting submitted values into appropriate data types.
- Applying additional validation rules defined by the developer.

Django does not automatically know every business rule in our application. If we want a special rule, such as preventing a particular word from appearing in a task title, we need to define that validation ourselves.

## Does Creating a ModelForm Automatically Save Data?

No. This is an important distinction.

Our `TaskForm` defines how Django should collect and validate the selected task fields. It does not automatically save a task simply because the form class exists.

The application must use the form when processing the user's request, check whether the submitted data is valid, and then save the form if appropriate.

For a valid form, calling `form.save()` creates a new database record when the form is being used to create a task. When a form is connected to an existing model instance, it can also be used to update that instance.

## What Is the Difference Between a Form and a Model?

These two concepts serve different purposes:

- **Model:** Defines the structure of the data stored in the database.
- **Form:** Defines how user input is collected and validated.
- **ModelForm:** Connects the form to a model so that fields and validation can be derived from it, and validated data can be saved through the model.

Think of our Task Manager: the model represents a task stored in the database, while the form provides a convenient way for the user to enter or edit its details.

**Remember:** A Django Form helps us handle user input. A `ModelForm` makes this easier when the form's data corresponds to a Django model.