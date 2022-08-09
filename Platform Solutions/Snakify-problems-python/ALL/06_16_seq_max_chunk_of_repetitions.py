chunk = 1
max_chunk = 1
a = int(input())
b = a
while b != 0:
    b, a = int(input()), b
    if b == a:
        chunk += 1
    else:
        if chunk > max_chunk:
            max_chunk = chunk
        chunk = 1
print(max_chunk)