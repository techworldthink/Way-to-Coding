
from .models import Author,Book
from nsApp.serializers import AuthorSerializer,BookSerializer
from rest_framework import generics
from rest_framework.pagination import PageNumberPagination,LimitOffsetPagination


# Create your views here.

class AuthorPagination(PageNumberPagination):
    page_size = 1

class AuthorListView(generics.ListCreateAPIView):
    queryset=Author.objects.all()
    serializer_class=AuthorSerializer
    pagination_class=AuthorPagination
    #pagination_class=LimitOffsetPagination

class AuthorDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset=Author.objects.all()
    serializer_class=AuthorSerializer

class BookListView(generics.ListCreateAPIView):
    queryset=Book.objects.all()
    serializer_class=BookSerializer

class BookDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset=Book.objects.all()
    serializer_class=BookSerializer