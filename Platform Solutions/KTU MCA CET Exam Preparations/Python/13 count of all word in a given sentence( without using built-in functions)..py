"""
13. Write a python program to find the count of all
 word in a given sentence
( without using built-in functions).
"""

def main():
    sentence = "hai hallo again hai"
    s_list   = sentence.split()
    s_set    = set(s_list)
    for each in s_set:
        count=0
        for i in s_list:
            if(each==i):
                count = count + 1
        print(each , " count is : ",count)
        
main()
