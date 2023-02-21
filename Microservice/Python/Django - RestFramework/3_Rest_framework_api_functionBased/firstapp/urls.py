
from django.urls import path
from . import views

urlpatterns = [
    path('emp',views.employee),
    path('emp/<int:id>',views.employee_detail),
]
