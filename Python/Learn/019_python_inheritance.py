# Parent class
class Author():
    author_name = ""  # Class attribute to store author's name

    def __init__(self, name):
        self.author_name = name  # Constructor initializes the author_name attribute

    def __str__(self):
        return f"{self.author_name}"  # String representation of the Author object

# Child class
class Book(Author):
    book_name = ""  # Class attribute to store book's name

    def __init__(self, bname, aname):
        # Initialize the Book object, calling the parent class's constructor
        super().__init__(aname)
        self.book_name = bname

    def __str__(self):
        return f"{self.author_name} - {self.book_name}"  # String representation of the Book object

# Create an object
obj = Book("sherlock", "holmes")
print(obj)  # Print the string representation of the Book object

# Output:
# holmes - sherlock
