# nice developers solution
counter = {}
for i in range(int(input())):
    line = input().split()
    for word in line:
        counter[word] = counter.get(word, 0) + 1
        
max_count = max(counter.values())
most_frequent = [k for k, v in counter.items() if v == max_count]
print(min(most_frequent))

# my solution
# max = 0
# for _ in range(n):
#     for word in input().split():
#         if word in d:
#             d[word] += 1
#         else:
#             d[word] = 1
#         if d[word] > max:
#             max = d[word]
# for key, val in sorted(d.items()):
#     if val == max:
#         print(key)
#         break