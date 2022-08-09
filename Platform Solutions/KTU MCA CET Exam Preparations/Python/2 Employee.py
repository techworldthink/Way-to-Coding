class Employee:
    empid   =''
    empname =''
    designation =''
    salary =''

    def __init__(self,id,name,des,salary):
        self.empid = id
        self.empname = name
        self.designation =des
        self.salary = salary

    def display(self):
        print("\n ///////////////////////////\n")
        print("ID : ",self.empid)
        print("Name : ",self.empname)
        print("Designation : ",self.designation)
        print("Salary : ",self.salary)

def main():
    emp_1 = Employee("1","Jobin","Hacker","100000")
    emp_2 = Employee("2","Man","Programmer","10000")

    emp_1.display()
    emp_2.display()

main()
