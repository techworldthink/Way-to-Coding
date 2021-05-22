n, m = [int(j) for j in input().split()]
a = [[int(j) for j in input().split()] for i in range(n)]
max_row = 0
max_col = 0
max = a[max_row][max_col]
for i in range(n):
    for j in range(m):
        if max < a[i][j]:
            max = a[i][j]
            max_row = i
            max_col = j
print(max_row, max_col)