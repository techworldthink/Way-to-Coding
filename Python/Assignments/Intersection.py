lst1=[]
n=int(input("Enter total number of elements in list1: "))
print("No:of elements in list 1:",n)
for i in range(0,n):
  ele= int(input())
  lst1.append(ele)
print(lst1)
lst2=[]
m=int(input("Enter total number of elements in list2: "))
print("No:of elements in list 2:",m)
for j in range(0,m):
  ele2= int(input())
  lst2.append(ele2)
print(lst2)
set1=set(lst1)
set2=set(lst2)
set3=set1.intersection(set2)
print(set3)