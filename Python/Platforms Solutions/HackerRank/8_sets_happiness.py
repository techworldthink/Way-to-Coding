# Enter your code here. Read input from STDIN. Print output to STDOUT
n,m = input().split()
data = input().split()
a = set(input().split())
b = set(input().split())


happiness = sum([1 for each in data if each in a])
happiness = happiness -  sum([1 for each in data if each in b])

print(happiness)
