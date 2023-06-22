from django.shortcuts import render
from .models import SampleModel
from .forms import SampleForm
from .forms import SampleModelForm

def template(request):
    if(request.method == 'POST'):
        name = request.POST.get('name')
        email = request.POST.get('email')
        age = request.POST.get('age')

        if name and email and age:
            SampleModel.objects.create(name=name, email=email, age=age)

    print(SampleModel.objects.all().values())
    return render(request,"django_form_template.html")


def django_forms(request):
    if(request.method == 'POST'):
        form = SampleForm(request.POST)
        if form.is_valid():
            name = form.cleaned_data['name']
            email = form.cleaned_data['email']
            age = form.cleaned_data['age']

            if name and email and age:
                SampleModel.objects.create(name=name, email=email, age=age)
    print(SampleModel.objects.all().values())
    return render(request,"django_form.html",{"form" : SampleForm()})


def django_model_forms(request):
    if request.method == 'POST':
        form = SampleModelForm(request.POST)
        if form.is_valid():
            form.save()

    form = SampleModelForm()
    print(SampleModel.objects.all().values())
    return render(request, 'django_form.html', {'form': form})