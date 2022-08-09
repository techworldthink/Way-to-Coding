class rectangle:
    __area = 0
    __perimeter = 0
    def __init__(self,length,width):
        self.__length = length
        self.__width = width
    def calc_area(self):
        self.__area = self.__length*self.__width
        #print("Area is  :",self.__area)
        return self.__area
    def calc_perimeter(self):
        self.__perimeter = 2*(self.__length+self.__width)
        print("Perimeter is :",self.__perimeter)


 
  
while(True):
    length = int(input("Enter length of the rectangle : "))
    width = int(input("Enter width of the rectangle : "))
    obj = rectangle(length,width)
    opt = input("To find Area (a) \nTo find Perimeter (p) \nTo compare area (c) \noption  :: ")
    if opt=='a':
        obj.calc_area()
    elif opt=='p':
        obj.calc_perimeter()
    elif opt=='c':
        length2 = int(input("Enter length of the rectangle : "))
        width2 = int(input("Enter width of the rectangle : "))
        obj2 = rectangle(length2,width2)
        #obj.calc_area()
        #obj2.calc_area()
        if obj.calc_area() >= obj2.calc_area():
            if obj.calc_area() == obj2.calc_area():
                print("Rectangles area are  equal")
            else:
                print("Rectangle one is large")
        else:
            print("Rectangle Two is large")
    else:
        print("Options are wrong !!")












"""def __ge__(self,second):
        if self.__area >= second.__area:
            return True
        else:
            return False
    def __eq__(self,second):
        if self.__area == second.__area:
            return True
        else:
            return False"""
        
