print(*sorted(set(input().split()) & set(input().split()), key=int))

# my bad solution
# a = list(set(input().split()) & set(input().split()))
# a = list(map(int, a))
# a.sort()
# a = list(map(str, a))
# print(' '.join(a))