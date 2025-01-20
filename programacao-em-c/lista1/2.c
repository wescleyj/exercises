#include <stdio.h>

int main(void)
{
    int A;

    printf("Escreva um número inteiro: ");
    scanf("%d", &A);

    printf("O antecessor de %d é %d e o sucessor é %d.\n", A, (A - 1), (A + 1));

    return 0;
}
