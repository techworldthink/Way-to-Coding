s=input()
a=s.find('h')
b=s.rfind('h')
c=s[a+1:b]
print(s[:a+1]+c.replace('h','H')+s[b:])