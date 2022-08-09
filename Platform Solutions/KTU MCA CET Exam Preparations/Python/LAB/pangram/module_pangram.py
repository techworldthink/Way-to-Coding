def check_pangram(value):
    value =value.lower()
    alpha = "abcdefghijklmnoqprstuvwxyz"
    for each in alpha:
        if each not in value:
            return 0
    return 1
