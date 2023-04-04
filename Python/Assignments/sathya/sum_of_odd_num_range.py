#print("Sum of Odd Number using for loop ")

start = int(input("Enter the starting value : "))
end   = int(input("Enter the ending value : "))

result=0

for x in range(start,end):
    if(x % 2 == 1):
        result=result+x
        
print("Sum of odd number is ",result)
