from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def hello(request):
    return HttpResponse("hello world")

def calc(request):
    return render(request,"index.html",{'name':'Jobin'})

def add(request):
    val1 = int(request.GET['num1'])
    val2 = int(request.GET['num2'])
    val3 = val1+val2
    return render(request,"result.html",{'value':val3})