import math

num = int(input("Enter a number: "))

if num % 2 == 0 and num != 2:
    print("O numero não é primo")
elif num == 2:
    print("O numero é primo")
else:
    for i in range(3, int(math.sqrt(num)) + 1):
        if num % i == 0:
            print("O numero não é primo")
            break
    else:
        print("O numero é primo")