
def sum_list(get_list):
    print(get_list)
    return sum(get_list)

count = int(input("Total number of list items : "))
list_get=[]
for i in range(count):
    list_get.append(int(input("List item : ")))
lsum = sum_list(list_get)
print(lsum)    
