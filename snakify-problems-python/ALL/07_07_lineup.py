heights = [int(i) for i in input().split()]
peters_height = int(input())
pos = len(heights) + 1
for i in range(len(heights)):
    if peters_height > heights[i]:
        pos = i + 1
        break
print(pos)


# developers solution
# a = [int(i) for i in input().split()]
# x = int(input())
# pos = 0
# while pos < len(a) and a[pos] >= x:
#    pos += 1
# print(pos + 1)