# parent class
class Author():
    author_name=""

    def __init__(self,name):
        self.author_name = name

    def __str__(self):
        return f"{self.author_name}"

# child class
class Book(Author):
    book_name = ""

    def __init__(self,bname,aname):
        #Author.__init__(self,aname)
        super().__init__(aname)
        self.book_name = bname
    
    def __str__(self):
        return f"{self.author_name} - {self.book_name}"

# create object
obj = Book("sherlock","holmes")
print(obj)

