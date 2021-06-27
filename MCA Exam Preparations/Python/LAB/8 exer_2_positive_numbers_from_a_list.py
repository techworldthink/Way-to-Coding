N=int(input("Enter Total number of elements in list : "))
lists=[]
for i in range(N):
    value=int(input("Enter a number :"))
    lists.append(value)
    
test = [each for each in lists if each>0]
print(test)


"""for i in lists:
     if i>0:
        print(i)"""
