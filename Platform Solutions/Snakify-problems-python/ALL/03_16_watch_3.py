alfa = float(input())
S = alfa / 360 * 12 * 60 * 60
H = S // 3600
M = S % 3600 // 60
print(int(H), int(M), int(S%60))

# solution from developers
# angle = float(input())
# print(int(angle // 30), int(angle % 30 * 2), int(angle % 0.5 * 120))