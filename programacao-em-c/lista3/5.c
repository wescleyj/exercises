#include <stdio.h>

int divisao(int dividendo, int divisor);

int main(void)
{
    int divisor, dividendo;

    printf("Digite o dividendo: ");
    scanf("%d", &dividendo);
    printf("Digite o divisor: ");
    scanf("%d", &divisor);

    printf("O resultado inteiro da divisao e: %d\n", divisao(dividendo, divisor));
}

int divisao(int dividendo, int divisor) {
    if (dividendo < divisor) {
        return 0;
    }
    else if (dividendo == divisor) {
        return 1;
    }
    else
    {
        dividendo -= divisor;
        return 1 + divisao(dividendo, divisor);
    }
}