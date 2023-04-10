
# create a class
class TestClass:
    # public attributes
    data = 123
    num = 0
    
    # constructor
    def __init__(self,num):
        self.num = num
        self.num_2 = num
        print("This is a constructor") 
    
    def __str__(self):
        return f"{self.data} - {self.num} - {self.num_2}"

    # object method
    # self - this parameter is a reference to the current instance.
    def get_data(self):
        return self.data
        

# create object of class TestClass
obj = TestClass(456)

print(obj.data) # 123
print(obj.num)  # 456
# print an object
print(obj)  # 123 - 456
print(obj.get_data()) # 123

# modify object property
obj.data = 89
print(obj.data) # 89

# its a class attribute, so it will set default value
del obj.data
print(obj)

print(obj.num_2)
del obj.num_2
# AttributeError: 'TestClass' object has no attribute 'num_2'
# print(obj.num_2)

# delete object
del obj

