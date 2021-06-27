dict1={}
dict2={}
dict3={}

n1=int(input("Total number of elements in dict 1 : "))
for i in range(n1):
    dict1[i]=int(input("Enter element : "))
    
n2=int(input("Total number of elements in dict 2 : "))
for i in range(3,3+n2):
    dict2[i]=int(input("Enter element : "))
    
print(dict1)
print(dict2)

for i in dict1:
    if i not in dict2:
        new = {i:dict1[i]}
        dict3.update(new)
    else:
        new = {i:dict1[i]+dict2[i]}
        dict3.update(new)
        
for i in dict2:
    if i not in dict1:
        new = {i:dict2[i]}
        dict3.update(new)
        
print(dict3)
