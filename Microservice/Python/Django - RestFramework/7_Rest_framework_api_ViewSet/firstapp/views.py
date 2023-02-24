from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status
from firstapp.models import Employee
from firstapp.serializers import EmployeeSerializer
from rest_framework.views import APIView

from rest_framework import viewsets


# Create your views here.
class EmployeeViewSet(viewsets.ModelViewSet):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

"""
class EmployeeList(generics.ListCreateAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

class EmployeeDetails(generics.RetrieveUpdateDestroyAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer


"""
