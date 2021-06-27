"""
10. Define a class Mobile to store the details of a Mobile (company,
model,price) with the following methods.
a) set_details()- to set the values to the data attributes
b) display_details()-to display the data attribute values
Create an object of the class and invoke methods. Also find the
expensive mode
"""

class mobile:
    company=""
    model=""
    price=0

    def set_details(self,c,m,p):
        self.company = c
        self.model   = m
        self.price   = p
        
    def display_details(self):
        print("/////////////////////////////////////")
        print("Company : ",self.company)
        print("Model   : ",self.model)
        print("Price   : ",self.price)
        print("/////////////////////////////////////")

def main():
    obj1 = mobile()
    obj2 = mobile()

    obj1.set_details("MS","R",1235)
    obj2.set_details("MS","R2",1234)

    obj1.display_details()
    obj2.display_details()

    print("\n....................................\n")
    if(obj1.price>obj2.price):
        print(obj1.model," is costly")
    else:
        print(obj2.model," is costly")
    print("\n....................................\n")
    
main()
