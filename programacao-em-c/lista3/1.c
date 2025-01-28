#include <stdio.h>

void inverter(char *p);

int main(void)
{
    char str[100], *p;

    p = str;

    scanf("%[^\n]", str);

    printf("\n%s\n", p);

    inverter(p);

    printf("%s\n", p);

    return 0;
}

void inverter(char *p)
{
    int tamanho, i = 0;
    char *ptr, aux;

    ptr = p;

    while (*p != '\0')
    {
        p++;
        tamanho++;
    }

    while (ptr < p)
    {
        aux = *ptr;
        *ptr = *(p - 1);
        *(p - 1) = aux;
        ptr++;
        p--;
    }
}