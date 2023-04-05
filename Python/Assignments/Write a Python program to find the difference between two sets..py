#defining first set
set1=set()
#inputting total number of elements in first set
n=int(input("Enter total number of elements in set1: "))
print("No:of elements in set 1:",n)
#for inputting elements in first set 
for i in range(0,n):
  ele=(input())
  #adding elements to set
  set1.add(ele)
print(set1)
#defining second set
set2=set()
#inputting total number of elements in second set
m=int(input("Enter total number of elements in set2: "))
print("No:of elements in set 1:",m)
#for inputting elements in second set
for i in range(0,m):
  ele=(input())
  #adding elements to set
  set2.add(ele)
print(set2)
#calculating difference of set 1 and set 2
set3=set1.difference(set2)
print(set3)
