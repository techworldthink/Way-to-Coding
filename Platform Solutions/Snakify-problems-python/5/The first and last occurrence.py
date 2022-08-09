s=input()
if s.count('f')==1:
    print(s.find('f'))
elif s.count('f')>1:
    print(str(s.find('f'))+str(" ")+str(s.rfind('f')))
else:
    print()