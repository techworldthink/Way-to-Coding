# nice developers solution
num_votes = {}
for _ in range(int(input())):
    candidate, votes = input().split()
    num_votes[candidate] = num_votes.get(candidate, 0) + int(votes)

for candidate, votes in sorted(num_votes.items()):
    print(candidate, votes)

# my solution
# n = int(input())
# d = {}
# for i in range(n):
#    key, val = input().split()
#    if key in d:
#        d[key] += int(val)
#    else:
#        d[key] = int(val)
# for key, val in sorted(d.items()):
#    print(key, val)