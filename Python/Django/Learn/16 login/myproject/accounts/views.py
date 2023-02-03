from django.http.response import HttpResponse
from django.shortcuts import redirect, render

from django .contrib.auth.models import User,auth
from django .contrib import messages

# Create your views here.

def registration(request):
    if request.method == "POST":
        first_name  = request.POST['fname']
        last_name   = request.POST['lname']
        username    = request.POST['uname']
        password1   = request.POST['pass1']
        password2   = request.POST['pass2']
        email       = request.POST['email']

        if(password1 == password2):
            if(User.objects.filter(username=username).exists()):
                messages.info(request,'username taken')
                return redirect('register')
            elif(User.objects.filter(email=email).exists()):
                messages.info(request,'email taken')
            else:
                user = User.objects.create_user(username=username,password=password1,email=email,first_name=first_name,last_name=last_name)
                user.save()
                messages.info(request,'succesfull')
                return redirect('login')
        else:
            #messages.info(request,'password not match')
            return redirect('register')
    else:
        return render(request,"register.html") 

def login(request):
    if request.method == "POST":
        username    = request.POST['uname']
        password    = request.POST['pass']

        user = auth.authenticate(username=username,password=password)
        if user is not None:
            auth.login(request,user)
            return redirect('home')
        else:
            messages.info(request,'un succesfull')
            return redirect('login')

    return render(request,"login.html") 

def logout(request):
    auth.logout(request)
    return render(request,"index.html") 

def home(request):
    return render(request,"home.html") 

def index(request):
    return render(request,"index.html") 