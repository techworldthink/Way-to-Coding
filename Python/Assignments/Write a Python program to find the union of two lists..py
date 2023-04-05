#define first set
set1=set()
#to input total number of elements in the list
n=int(input("Enter total number of elements in set1: "))
print("No:of elements in set 1:",n)
#to input elements in the list
for i in range(0,n):
  ele=(input())
  #add- to add elements to the set
  set1.add(ele)
print(set1)
#define second set
set2=set()
#to input total number of elements in second set
m=int(input("Enter total number of elements in set2: "))
print("No:of elements in set 1:",m)
for i in range(0,m):
  ele=(input())
  set2.add(ele)
print(set2)
#union- perform union operation in set 1 and set 2. 
set3=set1.union(set2)
print(set3)
