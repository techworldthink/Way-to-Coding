"""
URL configuration for django_views project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('',views.home,name='home'),
    path('hello',views.hello,name='hello'),
    path('greet/<str:name>',views.greet,name='greet'),
    path('post/<int:post_id>',views.post_detail,name='post'),
    path('api',views.api_data,name='api'),
    path('redirect',views.redirect_to_home,name='to_home'),
]


