from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status
from firstapp.models import Employee
from firstapp.serializers import EmployeeSerializer
from rest_framework.views import APIView


def add_demo_values():
    data = Employee(1,"abc",23)
    data.save()
    data = Employee(2,"dfc",26)
    data.save()
    data = Employee(3,"dbc",29)
    data.save()

# Create your views here.

class EmployeeList(APIView):
    def get(self,request):
        add_demo_values()
        data = Employee.objects.all()
        serializer = EmployeeSerializer(data,many=True)
        return Response(serializer.data)

    def post(self,request):
        serializer = EmployeeSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data,status=status.HTTP_201_CREATED)
        return Response(serializer.errors,status=status.HTTP_400_BAD_REQUEST)


class EmployeeDetails(APIView):
     
    def get_object(self,pk):
        add_demo_values()
        try:
            return Employee.objects.get(pk=pk)
        except Employee.DoesNotExist:
            return Response(status.HTTP_404_NOT_FOUND)
    
    def get(self,request,pk):
        employee = self.get_object(pk)
        serializer = EmployeeSerializer(employee)
        return Response(serializer.data)

    def put(self,request,pk):
        employee = self.get_object(pk)
        serializer = EmployeeSerializer(employee,data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors,status=status.HTTP_400_BAD_REQUEST)
    
    def delete(self,request,pk):
        employee = self.get_object(pk)
        employee.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)