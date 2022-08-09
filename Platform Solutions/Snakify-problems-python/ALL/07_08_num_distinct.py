a = [int(i) for i in input().split()]
num_of_diff = 1
for i in range(1,len(a)):
    if a[i] > a[i-1]:
        num_of_diff += 1
print(num_of_diff)