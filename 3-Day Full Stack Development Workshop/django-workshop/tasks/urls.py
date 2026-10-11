from django.urls import path
from . import views

urlpatterns = [
    path("", views.home, name="home"),
    path("tasks/new/", views.task_create, name="task_create"),
]