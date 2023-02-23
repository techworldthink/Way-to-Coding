
from django.urls import path
from . import views

urlpatterns = [
    path('emp',views.EmployeeList.as_view()),
    path('emp/<int:pk>',views.EmployeeDetails.as_view()),
]
