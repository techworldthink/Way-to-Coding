def longest(get_name):
    length=0
    get_name = get_name.split()
    for i in get_name:
        if len(i) > length:
            length=len(i)    
    return  length

str = input("Enter the string: ")
word = longest(str)
print(word)


"""
def longest(get_name):
    index=0
    len_index=0
    length=0
    get_name = get_name.split()
    for i in get_name:
        if len(i) > length:
            length=len(i)
            len_index=index
        index +=1
    return get_name[len_index]

str = input("Enter the string: ")
word = longest(str)
print(word)

"""
