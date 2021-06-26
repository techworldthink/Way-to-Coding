def fact(num):
    pro=1
    for each in range(1,num+1):
        pro = pro * each
    return pro

def main():
    sum=0
    number = int(input("Enter a number to check Krishnamoorthy number  : "))
    num_string = str(number)
    for each in num_string:
        sum = sum + fact(int(each))
    print("sum is : ",sum)
    if(sum==number): print("Krishnamoorthy number")
    else           : print("Not Krishnamoorthy number")

while True:   
    main()
