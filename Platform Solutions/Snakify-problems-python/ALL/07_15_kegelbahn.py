N, K = [int(i) for i in input().split()]
kegels = ['I'] * N
for j in range(K):
    l, r = [int(i) for i in input().split()]
    kegels[l-1:r] = ['.'] * (r-l+1)
print(''.join([str(i) for i in kegels]))


# developers solution
# n, k = [int(s) for s in input().split()]
# bahn = ['I'] * n
# for i in range(k):
#    left, right = [int(s) for s in input().split()]
#    for j in range(left - 1, right):
#        bahn[j] = '.'
# print(''.join(bahn))