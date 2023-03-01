from firstapp.models import Employee
from firstapp.serializers import EmployeeSerializer
from rest_framework import viewsets
from rest_framework.permissions import IsAuthenticated


# Create your views here.
class EmployeeViewSet(viewsets.ModelViewSet):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer
    permission_classes = (IsAuthenticated,)

"""
class EmployeeList(generics.ListCreateAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer

class EmployeeDetails(generics.RetrieveUpdateDestroyAPIView):
    queryset = Employee.objects.all()
    serializer_class = EmployeeSerializer


"""
