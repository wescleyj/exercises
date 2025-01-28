#include <stdio.h>

int main(void)
{
    int A, B, soma;

    printf("Escreva dois valores inteiros: ");
    scanf("%d %d", &A, &B);

    soma = A + B;

    printf("A soma de %d e %d é: %d\n", A, B, soma);

    return 0;
}
