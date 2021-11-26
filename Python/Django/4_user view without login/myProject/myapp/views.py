from django.shortcuts import render
from django.http import HttpResponse

from .models import Products

#http://127.0.0.1:8000/myapp/
def index(request):
    products = Products.objects.all()
    #return HttpResponse("<h1>welcome</h1>")
    #return render(request,"index.html",{'products':products,'name':'hai'})
    return render(request,"index.html",{'products':products})

# http://127.0.0.1:8000/myapp/about
def about(request):
    return HttpResponse("<h1>welcome to about</h1>")

# http://127.0.0.1:8000/myapp/contacts
def contact(request):
    return HttpResponse("<h1>welcome to contacts</h1>")


