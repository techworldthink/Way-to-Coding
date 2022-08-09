# nice developers solution
n = int(input())
d = {}
for i in range(n):
    first, second = input().split()
    d[first] = second
    d[second] = first
print(d[input()])

# my solution
# n = int(input())
# synonyms = {}
# for i in range(n):
#    pair = input().split()
#    synonyms[pair[0]] = pair[1]
# word = input()
# for key in synonyms:
#    if key == word:
#        print(synonyms[key])
#    if synonyms[key] == word:
#        print(key)