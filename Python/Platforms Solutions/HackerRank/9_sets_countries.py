# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(input())
country_list = set([ input() for line in range(n) ])
print(len(country_list))
