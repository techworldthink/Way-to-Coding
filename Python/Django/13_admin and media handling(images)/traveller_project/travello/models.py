from django.db import models
from django.db.models.fields import CharField

# Create your models here.
class Destinations(models.Model):

    name    = models.CharField(max_length=30)
    image   = models.ImageField(upload_to='pictures')
    desc    = models.TextField()
    price   = models.IntegerField() 
    offer   = models.BooleanField(default=False)