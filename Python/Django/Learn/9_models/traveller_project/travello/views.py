from django.shortcuts import render

from travello.models import Destinations
from .models import Destinations

# Create your views here.
def home(request):
    dest1 = Destinations()
    dest1.id=2
    dest1.name="Kerala"
    dest1.price=1230
    dest1.desc="nothing to say"
    dest1.image="d"
    return render(request,"index.html",{'data':dest1}) 