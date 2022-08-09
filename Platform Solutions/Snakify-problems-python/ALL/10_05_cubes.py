n, m = [int(j) for j in input().split()]
A = set()
B = set()
for i in range(n):
    A.add(int(input()))
for i in range(m):
    B.add(int(input()))
C = A & B
D = A - B
Е = B - A
print(len(C))
print(*sorted(C), key=int)
print(len(D))
print(*sorted(D), key=int)
print(len(Е))
print(*sorted(Е), key=int)