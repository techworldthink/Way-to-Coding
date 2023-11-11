# Inheritance without overriding the parent's __init__()
class Parent1():
    def __init__(self):
        print("Parent constructor invoked")

class Child1(Parent1):
    pass

obj1 = Child1()
# Output: "Parent constructor invoked"
# Explanation: In this case, the child class (Child1) does not define its own __init__() method,
# so it inherits the __init__() method from the parent class (Parent1).

# Inheritance with the child class overriding the parent's __init__()
class Parent2():
    def __init__(self):
        print("Parent constructor invoked")

class Child2(Parent2):
    def __init__(self):
        print("Child constructor invoked")

obj2 = Child2()
# Output: "Child constructor invoked"
# Explanation: In this case, the child class (Child2) defines its own __init__() method,
# which overrides the __init__() method of the parent class (Parent2). 
# Therefore, when you create an instance of Child2, it calls the Child2 constructor.

# Using super() to call the parent class's __init__()
class Parent3():
    def __init__(self):
        print("Parent constructor invoked")

class Child3(Parent3):
    def __init__(self):
        super().__init__()  # Using super() to call the parent's constructor
        print("Child constructor invoked")

obj3 = Child3()
# Output:
# "Parent constructor invoked"
# "Child constructor invoked"
# Explanation: In this case, the child class (Child3) uses super().__init__() to explicitly call
# the constructor of the parent class (Parent3). This allows the child class to inherit and
# extend the behavior of the parent class's constructor.

# Note: The commented out lines like "Parent3.__init__(self)" are an alternative way to call
# the parent class's constructor, but using super() is considered a more Pythonic and flexible approach.
