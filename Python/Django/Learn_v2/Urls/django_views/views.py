
from django.http import HttpResponse
from django.shortcuts import render
from django.http import JsonResponse
from django.shortcuts import redirect


# Basic View
def hello(request):
    return HttpResponse("Hello, world!")
  
# Dynamic View
def greet(request, name):
    return HttpResponse(f"Hello, {name}!")

# Template View
def home(request):
    return render(request, 'home.html')

# Dynamic Template View
def post_detail(request, post_id):
    context = {
        "data": 123
    }
    return render(request, 'post_detail.html', context)

def article_detail(request, article_id):
    return HttpResponse(f"You're viewing article {article_id}")