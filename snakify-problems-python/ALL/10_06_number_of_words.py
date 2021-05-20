n = int(input())
a = [[j for j in input().split()] for i in range(n)]
print(len(set(sum(a, []))))

# developers solution
# words = set()
# for _ in range(int(input())):
#    words.update(input().split())
# print(len(words))