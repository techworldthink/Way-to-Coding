# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(input())
nums = [ int(num) for num in input().split()]
nums.reverse()
numbers  = set(nums)
N = int(input())



for rounds in range(N):
    operation_value = input().split()
    if(operation_value[0] == "remove"):
        if(int(operation_value[1]) in numbers):
            numbers.remove(int(operation_value[1]))
    elif(operation_value[0] == "discard"):
        numbers.discard(int(operation_value[1]))
    else:
        numbers.pop()

    
print(sum(numbers))
            
