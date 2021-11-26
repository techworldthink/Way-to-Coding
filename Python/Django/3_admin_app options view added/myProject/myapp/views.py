from django.shortcuts import render
from django.http import HttpResponse

#http://127.0.0.1:8000/myapp/
def index(request):
    return HttpResponse("<h1>welcome</h1>")

# http://127.0.0.1:8000/myapp/about
def about(request):
    return HttpResponse("<h1>welcome to about</h1>")

# http://127.0.0.1:8000/myapp/contacts
def contact(request):
    return HttpResponse("<h1>welcome to contacts</h1>")


