from django.contrib import admin

# Register your models here.
from .models import Products

#admin.site.register(Products)

class ProductAdmin(admin.ModelAdmin):
    list_display = ('name','price','image')

admin.site.register(Products,ProductAdmin)