lst=[]
n=int(input("Enter total number of elements in the list"))
print("No:of elements in set 1:",n)
for i in range(0,n):
  ele=int(input())
  lst.append(ele)
print(lst)
lst.remove(max(lst))
print(lst)
a=lst
print("Second maximum number is",max(a))