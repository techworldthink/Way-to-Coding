N=int(input("umber of name : "))
listed = []
count=0
for i in range(N):
    name = input("Enter name : ")
    listed.append(name)
for i in listed:
    for j in i:
        if(j=="a"):
            count=count+1;
print(count)

        

