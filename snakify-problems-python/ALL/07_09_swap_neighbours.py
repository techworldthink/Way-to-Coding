a = [int(i) for i in input().split()]
for i in range(0,len(a)-1,2):
    a[i], a[i+1] = a[i+1], a[i]
print(' '.join([str(i) for i in a]))