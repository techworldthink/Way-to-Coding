


count = int(input("Total no of numbers: "))
content = [int(x) for x in input().split()]

def sort_list(get_list):
    for i in range(len(get_list)):
        for j in range(len(get_list)-1):
            if(get_list[j]>get_list[j+1]):
                temp = get_list[j]
                get_list[j] = get_list[j+1]
                get_list[j+1] = temp
    return get_list

def printbar_minus(get_no):
    print("|",end="")
    space = 10 - get_no
    for i in range(space):
        print(" ",end="")
    for i in range(10-space):
        print("*",end="")
    print("|",end="")
    for i in range(10):
        print(" ",end="")
    print("|",end="")
    print("")
    
def printbar_plus(get_no):
    space = 10 - get_no
    print("|",end="")
    for i in range(10):
        print(" ",end="")
    print("|",end="")
    for i in range(10-space):
        print("*",end="")
    for i in range(space):
        print(" ",end="")
    print("|",end="")
    print("")
    
sorted_list = sort_list(content)
print(sorted_list)

for each in sorted_list:
    if(each<0):
        printbar_minus(int(each/-1))
    else:
        printbar_plus(each)




