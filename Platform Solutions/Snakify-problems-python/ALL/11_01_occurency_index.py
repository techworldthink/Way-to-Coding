# developers solution
counter = {}
for word in input().split():
    counter[word] = counter.get(word, 0) + 1
    print(counter[word] - 1, end=' ')

# my solution without dicts
words = input().split()
for i in range(len(words)):
    print(words[:i].count(words[i]), end=' ')