from django.db import models
from django.db.models.signals import post_save
from django.dispatch import receiver
from rest_framework.authtoken.models import Token
from django.conf import settings

# Create your models here.
class Employee(models.Model):
    id = models.IntegerField(primary_key = True)
    name = models.CharField(max_length = 20)
    age = models.IntegerField()

@receiver(post_save,sender=settings.AUTH_USER_MODEL)
def createAuthToken(sender,instance,created,**kwargs):
	if created:
		Token.objects.create(user=instance)