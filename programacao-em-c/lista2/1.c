#include <stdio.h>

int main(void)
{
    double N, S = 0;

    printf("Escolha um valor\n");
    scanf("%lf", &N);

    for (int i = 1; i < N; i++)
    {
        S = (N - i) * (N - i + 1) / i;
    }

    printf("O valor de S e: %.2f\n", S);
    return 0;
}