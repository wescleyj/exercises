def palindromo(s):
    s1 = s.replace(' ', '').lower()
    return s1 == s1[::-1]

s = input('Digite uma frase ou palavra: ')

print(palindromo(s))