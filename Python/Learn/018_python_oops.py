
# create a class
class TestClass:
    data = 123
    num = 0
    demo = 21
    
    # constructor
    def __init__(self,num):
        self.num = num
        print("This is a constructor") 
    
    def __str__(self):
        return f"{self.data} - {self.num}"

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

# delete object property
del obj.demo
# print(obj.demo)