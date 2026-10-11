from django.shortcuts import render, redirect
from .models import Task
from .forms import TaskForm

# Create your views here.

# def home(request):
#     return render(request, 'tasks/home.html')

def home(request):
    tasks = Task.objects.all().order_by("-created_at")
    return render(request, "tasks/home.html", {"tasks": tasks})



def task_create(request):
    if request.method == "POST":
        form = TaskForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("home")
    else:
        form = TaskForm()

    return render(request, "tasks/task_form.html", {"form": form})