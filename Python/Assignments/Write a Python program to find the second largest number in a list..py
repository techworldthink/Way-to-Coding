#define list
lst=[]
#to input total number of elements
n=int(input("Enter total number of elements in the list"))
print("No:of elements in set 1:",n)
#for inputting elements in list
for i in range(0,n):
  ele=int(input())
  # append- to add element to the list
  lst.append(ele)
print(lst)
#remove- eliminating maximum value from the list
lst.remove(max(lst))
print(lst)
#assinging the new list to a variable 'a'
a=lst
#second maximum value in the list will be displayed
print("Second maximum number is",max(a))
