index_of_max = 0
index_of_min = 0
a = [int(i) for i in input().split()]
for i in range(1, len(a)):
    if a[i] > a[index_of_max]:
        index_of_max = i
    if a[i] < a[index_of_min]:
        index_of_min = i
a[index_of_max], a[index_of_min] = a[index_of_min], a[index_of_max]
print(' '.join([str(i) for i in a]))