#include <stdio.h>
#include <stdlib.h>

void erroAlocacao(char *vetor);

int main(void)
{
    int contador = 0, size = 2, k = 0, semEspaço = 1;
    char *vetor = malloc(size * sizeof(char)), caracter;
    char *vetorAux = malloc(semEspaço * sizeof(char));

    erroAlocacao(vetor);
    erroAlocacao(vetorAux);

    while (1)
    {
        scanf("%c", &caracter);
        getchar();

        if (caracter == '.')
        {
            vetor[contador] = '\0';
            break;
        }
        else
        {
            if ((size - 1) >= contador)
            {
                size += 10;
                vetor = realloc(vetor, size * sizeof(char));
                erroAlocacao(vetor);
            }
            if (caracter != ' ')
            {
                semEspaço++;
            }

            vetor[contador] = caracter;
            contador++;
        }
    }

    vetorAux = realloc(vetorAux, semEspaço * sizeof(char));

    erroAlocacao(vetorAux);

    for (int i = 0; i < contador; i++)
    {
        if (vetor[i] != ' ')
        {
            vetorAux[k] = vetor[i];
            k++;
        }
    }

    vetorAux[k] = '\0';

    printf("%s\n", vetor);
    printf("%s\n", vetorAux);

    free(vetor);
    free(vetorAux);

    return 0;
}

void erroAlocacao(char *vetor)
{
    if (vetor == NULL)
    {
        printf("Erro ao alocar memoria\n");
        exit(1);
    }
}