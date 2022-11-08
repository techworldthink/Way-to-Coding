def find(list_items,number):
    sum =0
    for i in range(len(list_items)):
        if list_items[i] != number:
            if i==0:
                if list_items[i+1] !=number:
                    sum = sum + list_items[i]
            else:
                if i < len(list_items)-1:
                    if list_items[i-1] != number and list_items[i+1] != number:
                         sum = sum +  list_items[i]
                if i == len(list_items)-1:
                    if list_items[i-1] != number:
                        sum = sum +  list_items[i]
    return sum

list_items_count = int(input("Total number of list items : "))
list_items = []
for i in range(list_items_count):
    list_items.append(int(input("Enter number : ")))
avoid = int(input("avoided number : "))
print(list_items)
sum_is = find(list_items,avoid)
print(sum_is)
)
