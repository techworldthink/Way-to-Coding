from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm
from .models import UserProfile

class UserRegistration(UserCreationForm):
	USER_TYPE = [('employee','EMPLOYEE'),('manager','MANAGER'),('admin','ADMIN')]
	email = forms.EmailField(required=True)
	user_type = forms.CharField(widget=forms.Select(choices=USER_TYPE))

	class Meta:
		model = User
		fields = ("username", "email", "password1", "password2")

	def save(self, commit=True):
		user = super(UserRegistration, self).save(commit=False)
		user.email = self.cleaned_data['email']
		userProfile = UserProfile()
		userProfile.user = user
		userProfile.user_type = self.cleaned_data['user_type']
		if commit:
			user.save()
			userProfile.save()
		return user