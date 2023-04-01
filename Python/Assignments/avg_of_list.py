input_list = input("Enter a list of elements separated by spaces: ")
lst = list(map(float, input_list.split()))
#Convert input string to list of floats
avg = sum(lst) / len(lst)
print (lst)
print (avg)
