#include <stdio.h>

int main(void)
{
    int A;

    printf("Escreva a placa de um veículo de 9 dígitos: ");
    scanf("%d", &A);

    A /= 10; // Remove o último dígito
    A %= 10; // Obtém o dígito da dezena

    printf("O algarismo da dezena é: %d\n", A);

    return 0;
}
