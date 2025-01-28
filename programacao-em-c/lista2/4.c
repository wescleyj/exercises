#include <stdio.h>
#include <math.h>

int main(void)
{
    int N, i = 1, maior_divisor = 1, primo, expoente;

    scanf("%d", &N);

    for (i = 2; i <= N; i++)
    {
        if (N % i == 0)
        {
            primo = i;
            expoente = 0;

            while (N % i == 0)
            {
                N /= i;
                expoente++;
            }
        }
    }

    int potencia = pow(primo, expoente);
    if (potencia > maior_divisor)
        maior_divisor = potencia;

    printf("%d\n", maior_divisor);
    return 0;
}