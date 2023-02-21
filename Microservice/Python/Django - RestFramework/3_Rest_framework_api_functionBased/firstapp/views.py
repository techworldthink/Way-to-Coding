from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status
from firstapp.models import Employee
from firstapp.serializers import EmployeeSerializer
from rest_framework.decorators import api_view


def add_demo_values():
    data = Employee(1,"abc",23)
    data.save()
    data = Employee(2,"dfc",26)
    data.save()
    data = Employee(3,"dbc",29)
    data.save()

# Create your views here.

@api_view(['GET','POST'])
def employee(request):
    add_demo_values()

    if request.method == 'GET':
        data = Employee.objects.all()
        serializer = EmployeeSerializer(data,many=True)
        return Response(serializer.data)
    
    elif request.method == 'POST':
        serializer = EmployeeSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data,status=status.HTTP_201_CREATED)
        return Response(serializer.errors,status=status.HTTP_400_BAD_REQUEST)

@api_view(['GET','PUT','DELETE'])
def employee_detail(request,id):
    try:
        employee = Employee.objects.get(id=id)
    except Employee.DoesNotExist:
        return Response(status.HTTP_404_NOT_FOUND)
    
    if request.method == 'GET':
        serializer = EmployeeSerializer(employee)
        return Response(serializer.data)
    elif request.method == 'PUT':
        serializer = EmployeeSerializer(employee,data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors,status=status.HTTP_400_BAD_REQUEST)
    elif request.method == 'DELETE':
        employee.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)