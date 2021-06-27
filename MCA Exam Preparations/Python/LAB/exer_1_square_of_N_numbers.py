N=int(input("Enter Total number of elements in list : "))
lists=[]
for i in range(N):
    value=int(input("Enter a number :"))
    lists.append(value)
    
for i in lists:
    print("Square of ",i," is : ",pow(i,2))
