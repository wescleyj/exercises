#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{
    int matriz[3][3], somatorio = 0, contador = 0;

    srand(time(NULL));

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            matriz[i][j] = rand() % 100;

            somatorio += matriz[i][j];

            if (matriz[i][j] > 50)
                contador++;
        }
    }

    printf("Matriz:\n");
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }

    printf("Soma dos elementos: %d\n", somatorio);
    printf("Quantidade de elementos maiores que 50: %d\n", contador);

    return 0;
}
