#include <stdio.h>

int tamanho(char *p);
void inverter(char *p);

int main(void)
{
    char str[100], *p;

    p = str;

    scanf("%[^\n]", str);

    inverter(p);

    printf("%s\n", p);

    return 0;
}

int tamanho(char *p)
{
    int tamanho = 0;

    while (*p != '\0')
    {
        p++;
        tamanho++;
    }

    p -= tamanho;

    return tamanho;
}

void inverter(char *p)
{
    int tam = tamanho(p), i = 0, j = 0, contador1 = 0, contador2 = 0, count = 0;
    char *ptr, *ptr2, aux1[tam], aux2[tam], nova[tam + 1];

    ptr = p;

    while (*ptr != ' ')
    {
        aux1[i] = *ptr;
        ptr++;
        i++;
        contador1++;
    }

    ptr = p;
    ptr += tam - 1;
    i = 0;

    while (*ptr != ' ')
    {
        aux2[i] = *ptr;
        ptr--;
        i++;
        contador2++;
    }

    ptr = p + contador1;

    p += (tam - contador2);

    for (int i = 0, j = contador2 - 1; i < contador2; i++, j--)
    {
        nova[i] = aux2[j];
    }

    for (int i = contador2; ptr < p; ptr++, i++)
    {
        nova[i] = *ptr;
    }

    for (int i = tam - contador1, j = 0; i < tam; i++, j++)
    {
        nova[i] = aux1[j];
    }

    nova[tam] = '\0';

    p -= (tam - contador2);

    while (nova[count] != '\0')
    {
        *p = nova[count];
        p++;
        count++;
    }
}