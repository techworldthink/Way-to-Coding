"""
sum of squares of the digits in
the even position.
"""

def main():
    sum=0
    iter=0
    number = int(input("Enter a number to check Krishnamoorthy number  : "))
    num_string = str(number)
    for each in num_string:
        iter = iter + 1
        if(iter%2==0):
            sum = sum + int(each)* int(each)
    print("sum is : ",sum)
    

while True:   
    main()
