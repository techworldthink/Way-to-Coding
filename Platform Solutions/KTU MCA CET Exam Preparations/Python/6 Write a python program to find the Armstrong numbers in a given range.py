def check_armstrong(num):
    sum = 0
    temp=num
    while(temp!=0):
        sum = sum + pow(temp%10,3)
        temp = temp//10
    return True if (num==sum) else False
    
def main():
    start = int(input("Enter starting no : "))
    stop = int(input("Enter ending no : "))
    for i in range(start,stop+1):
        if(check_armstrong(i)):
            print(i)
    
main()
