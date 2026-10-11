from django.urls import path
from . import views
from django.contrib.auth import views as auth_views



urlpatterns = [
    path("", views.home, name="home"),
    path("tasks/new/", views.task_create, name="task_create"),
    path("tasks/<int:pk>/edit/", views.task_edit, name="task_edit"),
    path("tasks/<int:pk>/delete/", views.task_delete, name="task_delete"),
    path("register/", views.register, name="register"),
    path("login/",auth_views.LoginView.as_view(template_name="tasks/login.html"),name="login",),
    path("logout/",auth_views.LogoutView.as_view(),name="logout",),
    path("dashboard/", views.dashboard, name="dashboard"),
]