#include <stdio.h>
#include <math.h>

int fat(int n);

int main(void)
{
    int termo;
    float x, resultado = 0.0;

    scanf("%f %d", &termo, &x);

    for (int i = 1; i <= termo; i += 2)
    {
        resultado += -pow(x, (i + 1)) / fat(i);
        if (i + 2 <= termo)
            resultado += pow(x, (i + 2)) / fat(i + 1);
    }

    printf("%.2f\n", resultado);
    return 0;
}

int fat(int n)
{
    if (n <= 0)
        return 1;
    else
        return n * fat(n - 1);
}