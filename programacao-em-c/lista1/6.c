#include <stdio.h>

int main(void)
{
    float C, F;

    printf("Digite uma temperatura em graus Celsius: ");
    scanf("%f", &C);

    F = (C * 9.0 / 5.0) + 32.0;

    printf("%.2f graus Celsius correspondem a %.2f graus Fahrenheit.\n", C, F);

    return 0;
}
