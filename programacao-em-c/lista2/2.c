#include <stdio.h>

int epalindromo(int num);

int main(void)
{
    for (int i = 0; i <= 10000; i++)
    {
        if (epalindromo(i))
            printf("%d\n", i);
    }
}

int epalindromo(int num)
{
    int reverso = 0, original = num;

    while (num > 0)
    {
        reverso = reverso * 10 + num % 10;
        num /= 10;
    }

    return reverso == original;
}