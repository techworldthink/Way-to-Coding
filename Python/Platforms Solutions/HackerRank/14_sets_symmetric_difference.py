# Enter your code here. Read input from STDIN. Print output to STDOUT
n_1 = int(input())
set_1 = set([int(num) for num in input().split()])
n_2 = int(input())
set_2 = set([int(num) for num in input().split()])

print(len(set_1.symmetric_difference(set_2)))
