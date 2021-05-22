P = int(input())
X = int(input())
Y = int(input())
Z = X * 100 + Y
R = Z + Z / 100 * P
print(int(R // 100) , int(R % 100))