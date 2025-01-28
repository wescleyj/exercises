#include <stdio.h>

int main(void)
{
    float salario, quilowatts, valor;

    printf("Digite o seu salario e a quantidade de quilowatts gasta: ");
    scanf("%f %f", &salario, &quilowatts);

    valor = quilowatts * (salario / 700);

    printf("O valor da conta da residencia e: %f\n", valor);

    return 0;
}