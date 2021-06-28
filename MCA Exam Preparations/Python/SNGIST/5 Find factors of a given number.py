
def main():
    fact=1
    number = int(input("Enter a number : "))
    for i in range(number,0,-1):
        fact = fact * i
    print("Factorial is : ",fact)
    
while(True):    
    main()
