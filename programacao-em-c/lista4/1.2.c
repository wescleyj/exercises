#include <stdio.h>
#include <stdlib.h>

typedef struct No
{
    int valor;
    struct No *prox;
} No;

typedef struct
{
    No *inicio;
    No *fimPar;
} LISTA;

void INIC(LISTA *l);
void INSERIR(LISTA *l, int valor);
void RETIRAR(LISTA *l, int valor);
void LISTAR(LISTA *l);

int main()
{
    LISTA minhaLista;
    INIC(&minhaLista);

    while (1)
    {
        int valor;
        printf("Digite um valor (0 para sair): ");
        scanf("%d", &valor);
        if (valor == 0)
            break;
        INSERIR(&minhaLista, valor);
    }

    printf("Lista após inserções: ");
    LISTAR(&minhaLista);

    while (1)
    {
        int valor;
        printf("Digite um valor para retirar (0 para sair): ");
        scanf("%d", &valor);
        if (valor == 0)
            break;
        RETIRAR(&minhaLista, valor);
    }

    printf("Lista após retirar os valores: ");
    LISTAR(&minhaLista);

    return 0;
}

void INIC(LISTA *lista)
{
    lista->inicio = NULL;
    lista->fimPar = NULL;
}

void INSERIR(LISTA *lista, int valor)
{
    if (valor <= 0)
        return;

    No *novo = (No *)malloc(sizeof(No));
    novo->valor = valor;
    novo->prox = NULL;

    if (lista->inicio == NULL)
    {
        lista->inicio = novo;
        if (valor % 2 == 0)
            lista->fimPar = novo;
        return;
    }

    if (valor % 2 != 0)
    {
        novo->prox = lista->inicio;
        lista->inicio = novo;
    }
    else
    {
        if (lista->fimPar == NULL)
        {
            No *atual = lista->inicio;
            while (atual->prox != NULL)
                atual = atual->prox;
            atual->prox = novo;
            lista->fimPar = novo;
        }
        else
        {
            lista->fimPar->prox = novo;
            lista->fimPar = novo;
        }
    }
}

void RETIRAR(LISTA *lista, int valor)
{
    No *atual = lista->inicio;
    No *anterior = NULL;

    while (atual != NULL)
    {
        if (atual->valor == valor)
        {
            if (anterior == NULL)
            {
                lista->inicio = atual->prox;
            }
            else
            {
                anterior->prox = atual->prox;
            }
            if (lista->fimPar == atual)
            {
                lista->fimPar = anterior;
            }
            free(atual);
            return;
        }
        anterior = atual;
        atual = atual->prox;
    }
}

void LISTAR(LISTA *lista)
{
    No *atual = lista->inicio;
    while (atual != NULL)
    {
        printf("%d ", atual->valor);
        atual = atual->prox;
    }
    printf("\n");
}