
from django.urls import path
from . import views

urlpatterns = [
    path('emp_static',views.employeeView),
    path('emp_db',views.employeeViewDb)
]
