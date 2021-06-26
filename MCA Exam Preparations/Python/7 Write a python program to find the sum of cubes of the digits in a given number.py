def main():
    number = int(input("Enter  no : "))
    sum = 0
    while(number!=0):
        sum = sum + pow(number%10,3)
        number = number//10
    print("sum of cubes of disgits is : ",sum)

while(True):    
    main()
