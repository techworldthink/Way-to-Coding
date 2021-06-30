
a=[]
b=[]
count1 = int(input("list count 1 : "))
for i in range(count1):
    a.append(int(input("enter value : ")))
count2 = int(input("list count 2 : "))
for i in range(count2):
    b.append(int(input("enter value : ")))

f1=open("a.txt","w")
f2=open("b.txt","w")
f3=open("c.txt","w")

for i in a:
    f1.write(str(i)+" ")
for i in b:
    f2.write(str(i)+" ")
for i in b:
    if i not in a:
        f3.write(str(i)+" ")
for i in a:
    if i not in b:
        f3.write(str(i)+" ")
    
f1.close()
f2.close()
f3.close()

