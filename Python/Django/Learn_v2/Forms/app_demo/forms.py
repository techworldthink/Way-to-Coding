from django import forms

class SampleForm(forms.Form):
    name = forms.CharField(max_length=100)
    email = forms.EmailField()
    age = forms.IntegerField()



from .models import SampleModel

class SampleModelForm(forms.ModelForm):
    class Meta:
        model = SampleModel
        fields = ['name', 'email', 'age']
