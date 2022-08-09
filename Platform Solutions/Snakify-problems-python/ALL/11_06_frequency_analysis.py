# this is my solution, taken from community
counter = {}
for i in range(int(input())):
    line = input().split()
    for word in line:
        counter[word] = counter.get(word, 0) + 1

for i in sorted(counter.items(), key=lambda x:(-x[1],x[0])): 
    print(i[0])

# developers solution
# from collections import Counter

# words = []
# for _ in range(int(input())):
#     words.extend(input().split())

# counter = Counter(words)
# pairs = [(-pair[1], pair[0]) for pair in counter.most_common()]
# words = [pair[1] for pair in sorted(pairs)]
# print('\n'.join(words))