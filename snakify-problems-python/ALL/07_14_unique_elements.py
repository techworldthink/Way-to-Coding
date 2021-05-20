a = [int(s) for s in input().split()]
uniqs = []
for elem in a:
    if a.count(elem) == 1:
        uniqs.append(elem)
print(' '.join([str(i) for i in uniqs]))


# developers solution
# a = [int(s) for s in input().split()]
# for i in range(len(a)):
#    for j in range(len(a)):
#        if i != j and a[i] == a[j]:
#            break
#    else:
#        print(a[i], end=' ')


# community solution
lst = [int(i) for i in input().split()]
for element in lst:
    if lst.count(element) == 1:
        print(element, end = ' ')