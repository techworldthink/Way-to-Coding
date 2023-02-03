from django.shortcuts import render

from travello.models import Destinations
from .models import Destinations

# Create your views here.
def home(request):
    
    dest1 = Destinations()
    dest1.id=2
    dest1.name="Light"
    dest1.price=1230
    dest1.desc="nothing to say"
    dest1.image="bg.jpg"
    dest1.offer = True
    
    dest2 = Destinations()
    dest2.id=3
    dest2.name="Fridge"
    dest2.price=3455
    dest2.desc="good"
    dest2.image="bg.jpg"
    dest2.offer = False

    dest = [dest1,dest2]

    return render(request,"index.html",{'data':dest}) 