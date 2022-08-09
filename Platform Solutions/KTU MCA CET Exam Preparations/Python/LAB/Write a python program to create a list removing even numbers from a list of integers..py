list1=[]
odd=[]
num=int(input("Total elements : "))
for i in range(num):
    list1.append(int(input("Enter a number  :")))
odd=[each for each in list1 if each%2!=0]
print(odd)
