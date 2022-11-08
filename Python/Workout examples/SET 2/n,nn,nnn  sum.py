num = int(input("Enter a number : "))
nsum=0
for i in range(num):
    nsum = nsum + pow(num,i+1)
print(nsum)
