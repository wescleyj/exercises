#include <stdio.h>

int main(void)
{
    int A, B;
    float media;

    printf("Escreva dois valores inteiros: ");
    scanf("%d %d", &A, &B);

    media = (A + B) / 2.0;

    printf("A média de %d e %d é: %.2f\n", A, B, media);

    return 0;
}
