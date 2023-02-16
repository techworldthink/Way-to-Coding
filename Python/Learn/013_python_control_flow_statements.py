# if
x,y = 1,2
if x>y:
    print(x)
elif y>x:
    print(y)
else:
    print(x,y)

# short hand if
if x>y : print(x)

# short hand if else
# Ternary Operators
print(x) if x > y else print(y)

# if + and
if x>y and y<x:
    print("Not possible!") 

# if + or
if x>y or y<x:
    print("possible!") 

# if + not
if not y<x:
    print("Not possible!") 

# pass
for i in range(10):
    if i%2==0:
        pass
    else:
        print(i,end=" ")    # 1 3 5 7 9

# break
# conditionally breaking the for loop 
for i in range(10):
    if i%2==1:
        break
    else:
        print(i,end=" ")    # 0

# continue
# to avoid the execution of statements after the continue statement and execute the loop again
for i in range(10):
    if i%2==1:
        continue
    else:
        print(i,end=" ")    # 0 2 4 6 8

