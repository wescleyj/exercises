#include <stdio.h>

int main(void)
{
    int n, soma = 0;

    printf("Digite um numero: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {
        if (i % 2 != 0)
        {
            soma += i;
        }
    }

    printf("A soma dos numeros impares entre 1 e %d: %d\n", n, soma);

    return 0;
}