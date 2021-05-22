n = int(input())
a = [i for i in range(1,n+1)]
s = set(a)
while True:
    guess = input()
    if guess == 'HELP':
        break
    answer = input()
    if answer == 'NO':
        s -= set(guess.split())
    elif answer == 'YES':
        s &= set(guess.split())
print(' '.join([str(i) for i in list(s)]))