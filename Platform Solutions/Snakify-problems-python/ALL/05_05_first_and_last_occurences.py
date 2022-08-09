s = input()
с = s.count('f')
if с == 1:
    print(s.find('f'))
if с > 1:
    print(s.find('f'),s.rfind('f'))