def capitalize(word):
    return chr(ord(word[0]) + ord('A') - ord('a')) + word[1:]
    
s = [str(s) for s in input().split()]
for i in range(len(s)):
    s[i] = capitalize(s[i])
print(' '.join([str(i) for i in s]))

# community solution after def capitalize
# print(' '.join([capitalize(str(s)) for s in input().split()]))