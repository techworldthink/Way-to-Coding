N, K = [int(k) for k in input().split()]
strikes = [[int(k) for k in input().split()] for i in range(K)]
strike_dates = set()
for i in range(K):
    for j in range(strikes[i][0], N+1, strikes[i][1]):
        if j % 7 != 0 and j % 7 != 6:
            strike_dates.add(j)
print(len(strike_dates))