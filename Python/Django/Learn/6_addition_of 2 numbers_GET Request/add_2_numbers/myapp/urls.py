from django.urls import path
from . import views

urlpatterns = [
    path('', views.hello),
    path('calc', views.calc),
    path('add', views.add),
]