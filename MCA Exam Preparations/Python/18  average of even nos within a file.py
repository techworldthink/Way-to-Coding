"""
Create a file with 10 integer numbers.
write a python program to
find the average of even number
"""

count=0
sum=0

f=open("18_sample.txt","r")
for i in map(int,f.readline().split()):
    if i%2==0:
        count = count + 1
        sum = sum + i
print("Average of even numbers : ",sum/count)


f.close()


