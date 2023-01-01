from django.shortcuts import HttpResponse
from django.shortcuts import render
from django.contrib.auth.decorators import login_required

from .forms import UserRegistration
from .models import UserProfile


def permission_required(user_type):
    def decorator_(function):
        def wrapper(*args, **kwargs):
            print(args[0])
            if args[0].user.is_authenticated:
                user = args[0].user
                userProfile = UserProfile.objects.get(user=user)
                if(userProfile.user_type == user_type):
                    return function(*args, **kwargs)
            return home(args[0])
        return wrapper
    return decorator_


# Create your views here.
def home(request):
    return  render(request,"home.html")

def user_register(request):
    form = UserRegistration()
    if request.method=='POST':
        form=UserRegistration(request.POST)
        if form.is_valid():
            form.save()
        return home(request)
    return render(request,'registration/register.html', context={"register_form":form})

@login_required
@permission_required(user_type="employee")
def employee(request):
    return  render(request,"employee.html")

@login_required
@permission_required(user_type="manager")
def manager(request):
    return  render(request,"manager.html")

@login_required
@permission_required(user_type="admin")
def admin(request):
    return  render(request,"admin.html")


