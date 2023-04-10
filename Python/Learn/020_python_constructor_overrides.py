
class Parent1():
    def __init__(self):
        print("Parent constructor invoked")
class Child1(Parent1):
    pass
obj1 = Child1()


"""
When you define an __init__() function in the child class, 
it will override the parent's __init__() function and 
the child class will no longer inherit the parent's __init__() function.
"""
class Parent2():
    def __init__(self):
        print("Parent constructor invoked")
class Child2(Parent2):
    def __init__(self):
        print("Child constructor invoked")
obj2 = Child2()


"""
super().__init__() is used to call the constructor of the parent class 
from within the constructor of the child class.
"""
class Parent3():
    def __init__(self):
        print("Parent constructor invoked")
class Child3(Parent3):
    def __init__(self):
        #Parent3.__init__(self)
        super().__init__()
        print("Child constructor invoked")
obj3 = Child3()