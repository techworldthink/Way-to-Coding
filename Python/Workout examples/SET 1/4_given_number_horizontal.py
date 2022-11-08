a=1
b=2
c=4
d=6
array=[]
array.append(a)
array.append(b)
array.append(c)
array.append(d)

for i in range(8):
    for j in array:
        print(format(j,'08b')[i], end =" ")
    print("\n")
