s = input()
i = s[s.find('h')+1:(s.rfind('h'))]
print(s[:s.find('h')+1] + i.replace('h', 'H') + s[s.rfind('h'):])