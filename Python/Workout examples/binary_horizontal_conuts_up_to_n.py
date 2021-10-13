number = int(input("Enter hex number : "))
for i in range(8):
    for j in range(number):
        print(format(j+1,'08b')[i], end =" ")
    print("\n")
    


"""for j in range(8):
    for i in range(int(number)):
        print(format(number+1,'08b')[count], end =" ")
        count = count +1
    print("\n")
    count=0"""
