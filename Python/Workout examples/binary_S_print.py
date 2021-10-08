n=int(input("Enter number of frame"))
array1=[16]

print("S\n")
for i in range(0,n+1,1):
    for j in range(8):
        for k in array1:
            print(format(k,'08b')[j],end="")
        print("\n")
    print("A\n")
print("S\n")
        

