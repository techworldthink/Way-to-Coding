import module_unique as u

get_list=[]
count = int(input("Enter total number of list items : "))
for i in range(count):
    get_list.append(input("Enter "+ str(i+1)+"th element : "))
print(u.unique(get_list))
