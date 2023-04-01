#define list 1
lst1=[]
# To enter total number of elements in list 1
n=int(input("Enter total number of elements in list1: "))
print("No:of elements in list 1:",n)
#to input elements in list 1 
for i in range(0,n):
  #ele is the variable used for inputting elements
  ele= int(input())
  # append- to add elements to list 1
  lst1.append(ele)
print(lst1)
#define list 2
lst2=[]
# To enter total number of elements in list 1
m=int(input("Enter total number of elements in list2: "))
print("No:of elements in list 2:",m)
#to input elements in list 1 
for j in range(0,m):
  ele2= int(input())
  #to add elements to list 2
  lst2.append(ele2)
print(lst2)
#conversion of created list to set for performing difference operation
set1=set(lst1)
set2=set(lst2)
#set3 final output after performing intersection operation
set3=set1.difference(set2)
print(set3)
