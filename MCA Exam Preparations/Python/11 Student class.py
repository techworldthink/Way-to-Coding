"""
Define a class Student with details such as rollno, name,
course and 2 marks. Create 3 student objects and print their details.
Also find the total marks scored by each student.
expensive mode
"""

class student:
    rollno=0
    name=""
    course=""
    mark1=0
    mark2=0
    total=0

    def set_details(self,r,n,c,m1,m2):
        self.rollno = r
        self.name   = n
        self.course = c
        self.mark1  = m1
        self.mark2  = m2
        self.total  = m1+m2
        
    def display_details(self):
        print("/////////////////////////////////////")
        print("Rollno  : ",self.rollno)
        print("Name    : ",self.name)
        print("Course  : ",self.course)
        print("Mark 1  : ",self.mark1)
        print("Mark 2  : ",self.mark2)
        print("Total   : ",self.total)
        print("/////////////////////////////////////")

def main():
    obj1 = student()
    obj2 = student()

    obj1.set_details(1,"Jobin","CS",10,12)
    obj2.set_details(2,"jith","M",12,12)

    obj1.display_details()
    obj2.display_details()

    
main()
