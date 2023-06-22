
from django.urls import path
from . import views

urlpatterns = [
    path('template/',views.template),
    path('django_form/',views.django_forms),
    path('django_model_form/',views.django_model_forms),
]
