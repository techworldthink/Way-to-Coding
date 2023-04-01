lst = []						#blank list definition

def evensumfn():					#function definition for taking even numbers sum
    even_sum=0						#sum variable is initialized as zero
    for i in range(0,len(lst)):
    
        if lst[i] % 2 == 0:				#to check if an element is divisible by two(even)
            even_sum += lst[i]				#sum variable is incremented if the list element value if even
    return even_sum
        
n = int(input("Enter number of elements : "))
print("Enter the elements : ")
  
for i in range(0, n):					#loop to input elements in the list
    ele = int(input())
    
    lst.append(ele)					#to form a list with the given numbers
print(lst)
print("Sum of even numbers is : " + str(evensumfn()))	#function call to calculate and print the sum of even numbers
