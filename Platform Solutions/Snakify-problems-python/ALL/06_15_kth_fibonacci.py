n = int(input())
fi1 = 0
fi2 = 1
if n < 1:
    print(0)
elif n == 1:
    print(1)
else:
    i = 2
    while i <= n:
        fi2, fi1 = fi1 + fi2, fi2
        i += 1
    print(fi2)
    
# developers solution
# n = int(input())
# if n == 0:
#    print(0)
# else:
#    a, b = 0, 1
#    for i in range(2, n + 1):
#        a, b = b, a + b
#    print(b)