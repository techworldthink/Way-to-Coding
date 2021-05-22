a = [int(s) for s in input().split()]
counter = 0
for i in range(len(a)):
    for j in range(i + 1, len(a)):
        if a[i] == a[j]:
            counter += 1
print(counter)

# another worst solutions
# a = [int(i) for i in input().split()]
# num_equal_pairs = 0
# for i in range(len(a)):
#    for j in range(len(a)):
#        if i != j and a[i] == a[j]:
#            num_equal_pairs += 1
# print(num_equal_pairs // 2)


# a = [int(i) for i in input().split()]
# num_equal_pairs = 0
# for i in range(len(a)):
#    for j in range(len(a)):
#        if a[i] == a[j]:
#            num_equal_pairs += 1
# print((num_equal_pairs - len(a)) // 2)