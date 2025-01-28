#include <stdio.h>

int main()
{
    FILE *file;
    char filename[] = "arquivo.txt";
    char ch, target;
    int count = 0;

    file = fopen(filename, "r");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    printf("Digite o caractere a ser contado: ");
    scanf(" %c", &target);

    while ((ch = fgetc(file)) != EOF)
    {
        if (ch == target)
        {
            count++;
        }
    }

    fclose(file);

    printf("O caractere '%c' aparece %d vezes no arquivo.\n", target, count);

    return 0;
}
