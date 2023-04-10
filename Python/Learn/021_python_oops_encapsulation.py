
"""
Encapsulation is the process of hiding the complexity of an object 
by exposing only the necessary details and hiding the implementation details.

we can achieve encapsulation by using private variables and methods.
"""
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

person = Person("techworldthink", 5)
print(person.get_name())