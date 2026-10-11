Here is your section expanded with more explanation for teaching beginners, while keeping your same code, file names, URL, and Task Manager example.

# 3. Create Records

In the previous section, we learned about CRUD and its four operations. Now, let's implement the first operation: **Create**.

Create means adding a new record to the database. In our Task Manager application, this means allowing users to add new tasks through a form.

We have already created `TaskForm` in `tasks/forms.py`. Now, we will connect that form to a Django view and template so that users can submit task details.

## 3.1 Create the View

Open `tasks/views.py` and add the following code:

```
from django.shortcuts import redirect, render
from .forms import TaskForm


def task_create(request):
    if request.method == "POST":
        form = TaskForm(request.POST)

        if form.is_valid():
            form.save()
            return redirect("home")
    else:
        form = TaskForm()

    return render(
        request,
        "tasks/task_form.html",
        {"form": form}
    )
```

Let's understand how this code works.

**1. Import the required functions and form**

```
from django.shortcuts import redirect, render
from .forms import TaskForm
```

- `render()` is used to display an HTML template.
- `redirect()` sends the user to another URL after an operation succeeds.
- `TaskForm` is the form we created earlier to collect task details.

**2. Define the view**

```
def task_create(request):
```

This function is called a *view* in Django.

A view receives an HTTP request, processes it, and returns an HTTP response. Here, it handles requests to create a new task.

**3. Check the request method**

```
if request.method == "POST":
```

There are two important HTTP methods in this example: GET and POST.

- **GET:** The user opens the page to see the form.
- **POST:** The user submits the form containing task details.

We handle these two situations differently.

**4. Pass the submitted data to the form**

```
form = TaskForm(request.POST)
```

`request.POST` contains the data submitted by the browser.

For example, the submitted data might contain:

```
title = Complete Django homework
description = Finish today's exercises
completed = False
```

Django uses this data to populate the form so that it can be validated.

**5. Validate the form**

```
if form.is_valid():
```

Before saving anything, we check whether the submitted data is valid.

For example, Django checks the applicable field validation rules, including whether required fields have values and whether the title exceeds its maximum permitted length.

If the data is invalid, Django does not execute the save operation. Instead, the form is rendered again with the submitted values and validation errors.

**6. Save the record**

```
form.save()
```

Because `TaskForm` is a `ModelForm` connected to our `Task` model, calling `save()` creates a new task record in the database.

We do not need to write a separate database insertion query ourselves.

**7. Redirect after saving**

```
return redirect("home")
```

After the task is saved successfully, the user is redirected to the URL named `home`.

This name must match a URL pattern defined in our project. In our existing application, `home` is the destination that displays the task list.

Redirecting after a successful POST also helps prevent accidental duplicate submissions when the user refreshes the resulting page.

**8. Display an empty form for GET requests**

```
else:
    form = TaskForm()
```

When the user first opens the page, Django creates an empty form for the user to fill in.

Finally:

```
return render(
    request,
    "tasks/task_form.html",
    {"form": form}
)
```

This renders the `task_form.html` template and passes the form to it.

The dictionary `{"form": form}` makes the Python form object available in the template under the name `form`.

## 3.2 Add the URL

Open `tasks/urls.py` and add this URL pattern to the existing `urlpatterns` list:

```
path("tasks/new/", views.task_create, name="task_create"),
```

Make sure the file already imports `path` and `views`, as required by your existing URL configuration.

This URL connects the browser request to our view.

- URL path: `/tasks/new/`
- View function: `task_create`
- URL name: `task_create`

The URL name can be used elsewhere in Django templates and views to refer to this route without hardcoding its full path.

## 3.3 Create the HTML Template

Create the file `tasks/templates/tasks/task_form.html`:

```
<h1>Add Task</h1>

<form method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <button type="submit">Save Task</button>
</form>

<a href="{% url 'home' %}">Back</a>
```

Let's understand the important parts.

**`<form method="post">`**

Creates an HTML form that submits its data using the POST method.

**`{% csrf_token %}`**

Adds Django's CSRF protection token. This helps protect the application against cross-site request forgery attacks. It should be included in internal POST forms when Django's standard CSRF middleware is enabled.

**`{{ form.as_p }}`**

Displays the fields generated by our `TaskForm`. Django renders the field labels and input controls, generally placing each field inside a paragraph element.

Because we use the same form created earlier, we do not need to write separate HTML inputs for the title, description, and completion status.

**`<button type="submit">Save Task</button>`**

Submits the form to the server.

**`{% url 'home' %}`**

Generates the URL associated with the `home` URL name, providing a link back to the task list.

## 3.4 Run and Test the Application

Start the Django development server if it is not already running:

```
python manage.py runserver
```

Open the following URL in your browser:

[http://127.0.0.1:8000/tasks/new/](http://127.0.0.1:8000/tasks/new/)

You should see the Add Task form.

1. Enter a task title.
2. Enter a description if required.
3. Select the completion status if needed.
4. Click **Save Task**.
5. If the form is valid, Django saves the task and redirects you to the home page.
6. Check the task list to confirm that the new task appears.

Try submitting the form without a required title to see how validation errors are handled.

## 3.5 Understand the Complete Workflow

The following sequence explains what happens behind the scenes:

```
User opens /tasks/new/
          |
          v
    GET request
          |
          v
    Create empty form
          |
          v
    Display HTML page
          |
          v
 User enters task details
          |
          v
   Submit the form
          |
          v
    POST request
          |
          v
    Validate the form
          |
          v
      Is it valid?
       /       \
     Yes        No
      |          |
      v          v
  Save task   Show form
      |       with errors
      v
 Redirect to home
```

**Key takeaway:** The view connects the form to the database workflow. The template displays the form, the URL makes the view accessible, and the `ModelForm` handles validation and saving the task.

Add the complete tasks URL fileClarify the project URL prefix