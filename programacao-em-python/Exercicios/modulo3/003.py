def fibonnaci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonnaci(n - 1) + fibonnaci(n - 2)
    

n = int(input("Digite um número: "))

print("O {}º número da sequência de Fibonacci é: {}".format(n, fibonnaci(n)))