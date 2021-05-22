s = input()
с = s.count('f')
if с == 0:
    print(-2)
if с == 1:
    print(-1)
if с > 1:
    print(s.find('f', s.find('f') + 1))