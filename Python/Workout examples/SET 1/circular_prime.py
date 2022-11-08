def get_circular_numbers(num):
    rotated = []

    m = str(num)

    for _ in m:
        rotated.append(int(m))
        m = m[1:] + m[0]

    return rotated    

def is_prime(num):
    if num > 1:
        for i in range(2, int(num/2)+1):
            if (num % i) == 0:
                return False
    else:
        return False
    return True

def is_circular_prime(num):
    circular_numbers = get_circular_numbers(num)
    for each in circular_numbers:
        if(not is_prime(each)):
            return False
    print(circular_numbers)
    return True

def main():
    count = 0;
    for i in range(5000):
        if(is_circular_prime(i)):
            count = count + 1

    print(count)

main()
