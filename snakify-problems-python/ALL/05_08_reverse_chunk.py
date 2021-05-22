s = input()
i = s[s.find('h'):(s.rfind('h'))]
print(s[:s.find('h') + 1] + i[::-1] + s[s.rfind('h')+1:])