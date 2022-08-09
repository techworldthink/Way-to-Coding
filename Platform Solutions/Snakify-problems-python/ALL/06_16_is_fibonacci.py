A = int(input())
fi1 = 0
fi2 = 1
if A == 1:
    print(1)
else:
    i = 1
    while A > fi2:
        fi2, fi1 = fi1 + fi2, fi2
        i += 1
    if A == fi2:
        print(i)
    else:
        print(-1)