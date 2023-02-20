from django.shortcuts import render
from django.http import JsonResponse
from firstapp.models import Employee


def addDemoValues():
    data = Employee(1,"abc",23)
    data.save()
    data = Employee(2,"dfc",26)
    data.save()
    data = Employee(3,"dbc",29)
    data.save()
# Create your views here.

def employeeView(request):
    emp = {
        'id' : 1,
        'name' : 'techwolrdthink',
        'age' : 3
    }
    return JsonResponse(emp)

def employeeViewDb(request):
    addDemoValues()
    data = Employee.objects.all()
    response = {"employee" : list(data.values('name','age'))}
    return JsonResponse(response)