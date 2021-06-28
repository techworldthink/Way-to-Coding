
def main():
    fact=1
    number = int(input("Enter limit : "))
    for i in range(number+1):
        for j in range(1,i+1):
            print(j,"\t",end="")
        print("\n")
    
while(True):    
    main()
