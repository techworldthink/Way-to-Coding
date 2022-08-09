n = int(input()) # количество учеников
lang_nums = [0] * n # количество языков для каждого ученика
langs = []  # наименования языков, для каждого из учеников
for i in range(n):
    lang_nums[i] = int(input())
    l = set()
    for j in range(lang_nums[i]):
        l.add(input())
    langs.append(l)
uni = set.union(*langs)
inter = set.intersection(*langs)
print(len(inter), '\n'.join(sorted(inter)), len(uni), '\n'.join(sorted(uni)), sep='\n')

# developers solution
# students = [{input() for j in range(int(input()))} for i in range(int(input()))]
# known_by_everyone, known_by_someone = set.intersection(*students), set.union(*students)
# print(len(known_by_everyone), *sorted(known_by_everyone), sep='\n')
# print(len(known_by_someone), *sorted(known_by_someone), sep='\n')
