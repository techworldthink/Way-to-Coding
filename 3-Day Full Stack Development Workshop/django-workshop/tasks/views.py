from django.shortcuts import render
from .models import Task


# Create your views here.

# def home(request):
#     return render(request, 'tasks/home.html')

def home(request):
    tasks = Task.objects.all().order_by("-created_at")
    return render(request, "tasks/home.html", {"tasks": tasks})