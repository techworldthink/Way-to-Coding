num = 1
data = [1,2,4]
name = 'tech world think'

# while
while num < 10:
    print(num)
    num += 1

# for + range()
for num in range(10):
    print(num)

# for - list iteration
for each in data:
    print(each)

# for + string iteration
for letter in name:
    print(letter)

# for else
# Only if there is no break will the else statement work. 
for num in range(3):
    print(num)
else:
    print("Finished!")