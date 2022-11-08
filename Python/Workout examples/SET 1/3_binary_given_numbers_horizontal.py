count = int(input("How much numbers need to add  : "))
value=[]
for i in range(count):
    get =int(input("Enter values : "))
    value.append(get)

for i in range(8):
    for j in value:
        print(format(j,'08b')[i], end =" ")
    print("\n")
