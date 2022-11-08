#this program evaluate the norm of a partition
a=float(input("Enter the lower limit: "))
b=float(input("Enter the upper limit: "))
n=int(input("Enter the size of the partition: "))
partition=[a,b]
print("insert {} points between [{},{}]".format(n-2,a,b))
for i in range(1,n-1):
    x=float(input())
    partition.append(x)
partition.sort()
print()
print("partition you have entered is",partition)
norm = 0
for i in range(0,n-1):
    if norm < partition[i+1]-partition[i]:
        norm=partition[i+1]-partition[i]
print()
print("norm of the partition is",norm)
print()
