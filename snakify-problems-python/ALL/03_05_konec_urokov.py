n = int(input())
sb = n // 2
lb = n - sb - 1
t = n * 45 + sb * 5 + lb * 15
print(t // 60 + 9, t % 60)