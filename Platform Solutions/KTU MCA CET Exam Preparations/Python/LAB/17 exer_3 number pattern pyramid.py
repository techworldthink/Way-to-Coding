def pattern(number):
    for i in range(1,number+1):
        for j in range(1,i+1):
            print(j*i,end=" ")
        print("\n")

n=int(input("Limit : "))
pattern(n)
