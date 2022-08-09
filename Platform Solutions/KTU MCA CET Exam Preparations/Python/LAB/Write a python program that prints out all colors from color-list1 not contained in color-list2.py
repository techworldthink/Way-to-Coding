list1=[]
list2=[]
list3=[]

n1=int(input("Total elements in list one :"))
for i in range(n1):
    value=input("Enter a color : ")
    list1.append(value)
n2=int(input("Total elements in list two :"))

for i in range(n2):
    value=input("Enter a color : ")
    list2.append(value)

list3=[each for each in list1 if each not in list2]
print(list3)
