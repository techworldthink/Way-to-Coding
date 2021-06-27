"""
13. Write a python program to find the count of a
particular word in a given sentence
( without using built-in functions).
"""

def main():
    search = input("Input a word : ")
    sentence = "hai hallo again hai"
    s_list   = sentence.split()
    count=0
    for i in s_list:
        if(search==i):
            count = count + 1
    print(search , " count is : ",count)
        
main()
