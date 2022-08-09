s = input()
result = ''
for i in range(1,len(s),3):
    result += s[i:i+2]
print(result)

#solution from developers
#s = input()
#t = ''
#for i in range(len(s)):
#    if i % 3 != 0:
#        t = t + s[i]
#print(t)