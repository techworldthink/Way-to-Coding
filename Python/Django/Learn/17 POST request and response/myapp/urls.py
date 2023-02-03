from django.urls import path
from . import views

urlpatterns = [
    path('', views.calc),
    path('add', views.add),
]