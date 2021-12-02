from django.shortcuts import render

from travello.models import Destinations
from .models import Destinations

# Create your views here.
def home(request):
    
    dest = Destinations.objects.all()
    return render(request,"index.html",{'data':dest}) 