# global scope
global data

data = 123

def test():
    # local scope
    data = 4
    print(data) 

test() # 4
print(data) # 123