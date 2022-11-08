def unique(get_list):
    get_set = set(get_list)
    get_list = list(get_set)
    return get_list

get_list=[]
count = int(input("Enter total number of list items : "))
for i in range(count):
    get_list.append(input("Enter "+ str(i+1)+"th element : "))
print(unique(get_list))
