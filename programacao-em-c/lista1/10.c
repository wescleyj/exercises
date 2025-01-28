#include <stdio.h>
int fibonacci(int n);
int main(void)
{
    int n;

    printf("Qual termo da sequencia de fibonacci? ");
    scanf("%d", &n);

    printf("O %d-esimo de fibonacci e: %d\n\n", n, fibonacci(n));

    return 0;
}

int fibonacci(int n)
{
    if (n == 0)
    {
        return 0;
    }
    else if (n == 1)
    {
        return 1;
    }
    else
    {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}