from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status
from firstapp.models import Employee
from firstapp.serializers import EmployeeSerializer
from rest_framework.views import APIView

from rest_framework import mixins,generics


# Create your views here.

class EmployeeList(generics.ListCreateAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

class EmployeeDetails(generics.RetrieveUpdateDestroyAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

"""
class EmployeeList(mixins.ListModelMixin,mixins.CreateModelMixin,generics.GenericAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

    def get(self,request):
        return self.list(request)
    
    def post(self,request):
        return self.create(request)

class EmployeeDetails(mixins.RetrieveModelMixin,mixins.UpdateModelMixin,mixins.DestroyModelMixin,generics.GenericAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer
    
    def get(self,request,pk):
        return self.retrieve(request,pk)
    
    def put(self,request,pk):
        return self.update(request,pk)
    
    def delete(self,request,pk):
        return self.destroy(request,pk)
"""
