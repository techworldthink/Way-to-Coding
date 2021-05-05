s=input()
a=s.find('h')
b=s.rfind('h')
print(s[:a]+s[b+1:])