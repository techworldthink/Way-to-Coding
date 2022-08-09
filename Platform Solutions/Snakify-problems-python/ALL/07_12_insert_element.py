a = [int(i) for i in input().split()]
k, C = [int(i) for i in input().split()]
a = a[:k] + [C] + a[k:]
print(' '.join([str(i) for i in a]))

# developers solution
# a = [int(s) for s in input().split()]

# обратите внимание на множественное присваивание:
# справа от "=" стоит список из двух элементов,
# а слева -- две переменные,
# поэтому так делать можно
# k, C = [int(s) for s in input().split()]

# a.append(0)
# for i in range(len(a) - 1, k, -1):
#    a[i] = a[i - 1]
# a[k] = C
# print(' '.join([str(i) for i in a]))



# community solution
# a = [int(s) for s in input().split()]
# k, c = [int(s) for s in input().split()]
# a.insert(k, c)
# print(' '.join([str(i) for i in a]))