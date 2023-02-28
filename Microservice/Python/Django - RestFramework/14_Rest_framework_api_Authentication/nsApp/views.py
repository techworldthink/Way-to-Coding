
from .models import Author,Book
from nsApp.serializers import AuthorSerializer,BookSerializer
from rest_framework import generics
from rest_framework.authentication import BasicAuthentication
from rest_framework.permissions import IsAuthenticated

# Create your views here.

class AuthorListView(generics.ListCreateAPIView):
    queryset=Author.objects.all()
    serializer_class=AuthorSerializer
    authentication_classes=[BasicAuthentication]
    permission_classes=[IsAuthenticated]

class AuthorDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset=Author.objects.all()
    serializer_class=AuthorSerializer

class BookListView(generics.ListCreateAPIView):
    queryset=Book.objects.all()
    serializer_class=BookSerializer

class BookDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset=Book.objects.all()
    serializer_class=BookSerializer