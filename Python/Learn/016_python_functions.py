# function is a block of code which only runs when its called

# demo function
def demo():
    pass

# function without arguments
def send_email():   # function definition
    print("Success")
send_email() # function call

# function with arguments
def send_email(to_email):
    print(to_email," - Email sent successfully")
send_email("twt@gmail.com")

# function without any return value
def send_email():
    print("Success")
send_email() 

# function with a return value
def send_email():
    return "Success"
print(send_email()) 

# multiple arguments
def print_name(fname,lname):
    print(fname,lname)
print_name("fname","lname")

# arbitary arguments - *args
def print_name(*name):
    print(name[0],name[1])
print_name("fname","lname")

# keyword arguments
def print_name(fname,lname):
    print(fname,lname)
print_name(fname="fname",lname="lname")

# arbitary keyword arguments - *kwargs
def print_name(**name):
    print(name['fname'],name['lname'])
print_name(fname="fname",lname="lname")

# default parameter value
def distance(dis,unit="m"):
    print(dis,unit)
distance(100)

# passing list as argument
def print_(data):
    print(data)
print_([1,2,3])

# return multiple values
def print_(data):
    return [data,data*2]
print(print_([1,2,3]))