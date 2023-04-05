lst = []						#list definition

num = int(input('How many numbers: '))			#to accept the number of elements in the list

for n in range(num):					#loop to accept the elements of the list
    numbers = int(input('Enter number '))
    lst.append(numbers)					#command to form the list with the inputted numbers
    
print("Maximum element in the list is :", max(lst), 	#command to print the largest element in the list
"\nMinimum element in the list is :", min(lst))		#command to print the smallest element in the list
