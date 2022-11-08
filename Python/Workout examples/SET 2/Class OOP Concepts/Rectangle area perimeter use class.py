class rectangle:
    __width = 0
    __length = 0
    __area = 0
    __perimeter = 0
    def __init__(self,length,width):
        self.__length = length
        self.__width = width
    def calc_area(self):
        self.__area = self.__length*self.__width
        print("Area is  :",self.__area)
    def calc_perimeter(self):
        self.__perimeter = 2*(self.__length+self.__width)
        print("Perimeter is :",self.__perimeter)

while(True):
    length = int(input("Enter length of the rectangle : "))
    width = int(input("Enter width of the rectangle : "))
    obj = rectangle(length,width)
    opt = input("To find Area (a) \nTo find Perimeter (p) \noption  :: ")
    if opt=='a':
        obj.calc_area()
    elif opt=='p':
        obj.calc_perimeter()
    else:
        print("Options are wrong !!")

        
