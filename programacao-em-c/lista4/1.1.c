#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *removerEspacos(const char *str);

int main()
{
    char *entrada;
    char buffer[100];

    printf("Digite uma sequência de caracteres: ");
    fgets(buffer, sizeof(buffer), stdin);
    buffer[strcspn(buffer, "\n")] = '\0';
    
    entrada = (char *)malloc((strlen(buffer) + 1) * sizeof(char));
    strcpy(entrada, buffer);

    char *resultado = removerEspacos(entrada);

    printf("Texto sem espaços: %s\n", resultado);

    free(entrada);
    free(resultado);

    return 0;
}

char *removerEspacos(const char *str)
{
    int tamanho = strlen(str);
    char *resultado = (char *)malloc((tamanho + 1) * sizeof(char));
    int j = 0;

    for (int i = 0; i < tamanho; i++)
    {
        if (str[i] != ' ')
        {
            resultado[j++] = str[i];
        }
    }
    resultado[j] = '\0';

    return resultado;
}
