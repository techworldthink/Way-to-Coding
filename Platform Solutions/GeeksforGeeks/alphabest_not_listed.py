import string

x=input()
not_found=set(string.ascii_lowercase) - set("".join(x.split()))
print (not_found)

