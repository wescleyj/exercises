#include <stdio.h>

int main(void)
{
    double a1, r, n, an;

    printf("Digite a razão da P.A.: ");
    scanf("%lf", &r);

    printf("Digite o primeiro termo: ");
    scanf("%lf", &a1);

    printf("Qual termo da P.A. deseja? ");
    scanf("%lf", &n);

    an = a1 + (n - 1) * r;

    printf("O %.0lfº termo da P.A. é: %.5lf\n", n, an);

    return 0;
}
