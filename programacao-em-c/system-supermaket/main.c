#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

// Estrutura do produto
typedef struct
{
    char nome[100];
    float preco;
    int quantidade;
} PRODUTO;

// Protótipos das funções
PRODUTO *ler(FILE *arq, PRODUTO *produto, int *quantidade);
void menu(PRODUTO *produto, int *quantidade, FILE *arq1, FILE *arq2, FILE *arq3);
PRODUTO *cadastrarProduto(PRODUTO *produto, int *quantidade);
void venderProduto(PRODUTO *produto, int *quantidade);
void listarProdutos(PRODUTO *produto, int *quantidade);
void alterarEstoque(PRODUTO *produto, int *quantidade);
PRODUTO *removerProduto(PRODUTO *produto, int *quantidade);
void gerarRelatorio(PRODUTO *produto, FILE *arq3, int *quantidade);
void copiar(FILE *arq1, FILE *arq2);
PRODUTO *restaurarBackup(FILE *arq1, FILE *arq2, PRODUTO *produto, int *quantidade);
void saindo(PRODUTO *produto, FILE *arq1, FILE *arq2, FILE *arq3);
void clear();
void ordenarProdutos(PRODUTO *produto, int quantidade);

// Função principal
int main(void)
{
    FILE *arq1, *arq2, *arq3;
    PRODUTO *produto = NULL;
    int quantidade = 0;

    arq1 = fopen("Estoque.txt", "r+");
    arq2 = fopen("backup.txt", "w+");
    arq3 = fopen("Relatorio.txt", "w+");

    if (arq1 == NULL || arq3 == NULL)
    {
        printf("Erro ao abrir os arquivos\n");
        exit(1);
    }

    produto = malloc(sizeof(PRODUTO));
    if (produto == NULL)
    {
        printf("Erro ao alocar memória\n");
        exit(1);
    }

    produto = ler(arq1, produto, &quantidade);
    copiar(arq1, arq2);

    menu(produto, &quantidade, arq1, arq2, arq3);
    saindo(produto, arq1, arq2, arq3);

    return 0;
}

// Funções
PRODUTO *ler(FILE *arq, PRODUTO *produto, int *quantidade)
{
    clear();
    while (fscanf(arq, "%s %f %d", produto[*quantidade].nome, &produto[*quantidade].preco, &produto[*quantidade].quantidade) != EOF)
    {
        (*quantidade)++;
        produto = realloc(produto, (*quantidade + 1) * sizeof(PRODUTO));
        if (produto == NULL)
        {
            printf("Erro ao realocar memória\n");
            exit(1);
        }
    }
    return produto;
}

void menu(PRODUTO *produto, int *quantidade, FILE *arq1, FILE *arq2, FILE *arq3)
{
    int opc;

    clear();

    do
    {
        printf("1 - Cadastrar produto\n");
        printf("2 - Vender produto\n");
        printf("3 - Listar produtos\n");
        printf("4 - Alterar estoque\n");
        printf("5 - Remover produto\n");
        printf("6 - Gerar relatório\n");
        printf("7 - Restaurar backup\n");
        printf("8 - Sair\n");
        printf("Digite a opcao desejada: ");
        scanf("%d", &opc);

        switch (opc)
        {
        case 1:
            produto = cadastrarProduto(produto, quantidade);
            break;
        case 2:
            venderProduto(produto, quantidade);
            break;
        case 3:
            listarProdutos(produto, quantidade);
            break;
        case 4:
            alterarEstoque(produto, quantidade);
            break;
        case 5:
            produto = removerProduto(produto, quantidade);
            break;
        case 6:
            gerarRelatorio(produto, arq3, quantidade);
            break;
        case 7:
            produto = restaurarBackup(arq1, arq2, produto, quantidade);
            break;
        case 8:
            printf("Saindo...\n");
            break;
        default:
            printf("Opcao invalida\n");
            break;
        }

        ordenarProdutos(produto, *quantidade);
        rewind(arq1);
        for (int i = 0; i < *quantidade; i++)
        {
            fprintf(arq1, "%s %.2f %d\n", produto[i].nome, produto[i].preco, produto[i].quantidade);
        }

    } while (opc != 8);
}

PRODUTO *cadastrarProduto(PRODUTO *produto, int *quantidade)
{
    clear();
    (*quantidade)++;
    produto = realloc(produto, (*quantidade) * sizeof(PRODUTO));
    if (produto == NULL)
    {
        printf("Erro ao alocar memória\n");
        exit(1);
    }

    printf("Digite o nome do produto: ");
    scanf("%s", produto[*quantidade - 1].nome);
    printf("Digite o preco do produto: ");
    scanf("%f", &produto[*quantidade - 1].preco);
    printf("Digite a quantidade do produto: ");
    scanf("%d", &produto[*quantidade - 1].quantidade);

    printf("Produto cadastrado com sucesso!\n");
    system("pause");
    return produto;
}

void venderProduto(PRODUTO *produto, int *quantidade)
{
    clear();
    char nome[100];
    int venda;
    printf("Digite o nome do produto que deseja vender: ");
    scanf("%s", nome);

    for (int i = 0; i < *quantidade; i++)
    {
        if (strcmp(nome, produto[i].nome) == 0)
        {
            printf("Digite a quantidade que deseja vender: ");
            scanf("%d", &venda);

            if (venda > produto[i].quantidade)
            {
                printf("Quantidade insuficiente em estoque.\n");
            }
            else
            {
                produto[i].quantidade -= venda;
                printf("Venda realizada com sucesso!\n");
            }
            system("pause");
            return;
        }
    }
    printf("Produto nao encontrado.\n");
    system("pause");
}

void listarProdutos(PRODUTO *produto, int *quantidade)
{
    clear();
    if (*quantidade == 0)
    {
        printf("Nenhum produto cadastrado.\n");
    }
    else
    {
        for (int i = 0; i < *quantidade; i++)
        {
            printf("Nome: %s | Preco: %.2f | Quantidade: %d\n", produto[i].nome, produto[i].preco, produto[i].quantidade);
        }
    }
    system("pause");
}

void alterarEstoque(PRODUTO *produto, int *quantidade)
{
    clear();
    char nome[100];
    int novaQuantidade;

    printf("Digite o nome do produto que deseja alterar o estoque: ");
    scanf("%s", nome);

    for (int i = 0; i < *quantidade; i++)
    {
        if (strcmp(nome, produto[i].nome) == 0)
        {
            printf("Digite a nova quantidade: ");
            scanf("%d", &novaQuantidade);
            if (novaQuantidade < 0)
            {
                printf("Quantidade invalida.\n");
            }
            else
            {
                produto[i].quantidade = novaQuantidade;
                printf("Estoque alterado com sucesso!\n");
            }
            system("pause");
            return;
        }
    }
    printf("Produto nao encontrado.\n");
    system("pause");
}

PRODUTO *removerProduto(PRODUTO *produto, int *quantidade)
{
    clear();
    char nome[100];

    printf("Digite o nome do produto que deseja remover: ");
    scanf("%s", nome);

    for (int i = 0; i < *quantidade; i++)
    {
        if (strcmp(nome, produto[i].nome) == 0)
        {
            if (produto[i].quantidade > 0)
            {
                printf("Nao e possivel remover um produto com estoque.\n");
                system("pause");
                return produto;
            }

            for (int j = i; j < *quantidade - 1; j++)
            {
                produto[j] = produto[j + 1];
            }
            (*quantidade)--;
            produto = realloc(produto, (*quantidade) * sizeof(PRODUTO));
            printf("Produto removido com sucesso!\n");
            system("pause");
            return produto;
        }
    }
    printf("Produto nao encontrado.\n");
    system("pause");
    return produto;
}

void gerarRelatorio(PRODUTO *produto, FILE *arq3, int *quantidade)
{
    clear();
    rewind(arq3);
    FILE *backup = fopen("backup.txt", "r");
    if (backup == NULL)
    {
        printf("Erro ao abrir o arquivo de backup.\n");
        system("pause");
        return;
    }

    fprintf(arq3, "Relatório de Diferenças:\n");
    char nomeBackup[100];
    float precoBackup;
    int quantidadeBackup;

    int encontrado;
    while (fscanf(backup, "%99s %f %d", nomeBackup, &precoBackup, &quantidadeBackup) != EOF)
    {
        encontrado = 0;
        for (int i = 0; i < *quantidade; i++)
        {
            if (strcmp(produto[i].nome, nomeBackup) == 0)
            {
                encontrado = 1;
                int diferenca = produto[i].quantidade - quantidadeBackup;
                fprintf(arq3, "Produto: %s | Estoque inicial: %d | Estoque atual: %d | Diferença: %d\n",
                        nomeBackup, quantidadeBackup, produto[i].quantidade, diferenca);
                break;
            }
        }
        if (!encontrado)
        {
            fprintf(arq3, "Produto removido: %s | Estoque inicial: %d\n", nomeBackup, quantidadeBackup);
        }
    }

    fclose(backup);
    printf("Relatório gerado com sucesso!\n");
    system("pause");
}

void copiar(FILE *arq1, FILE *arq2)
{
    rewind(arq1);
    rewind(arq2);
    char c;
    while ((c = fgetc(arq1)) != EOF)
    {
        fputc(c, arq2);
    }
}

PRODUTO *restaurarBackup(FILE *arq1, FILE *arq2, PRODUTO *produto, int *quantidade)
{
    clear();
    rewind(arq1);
    rewind(arq2);

    printf("Restaurando o backup...\n");
    char c;
    while ((c = fgetc(arq2)) != EOF)
    {
        fputc(c, arq1);
    }

    *quantidade = 0;
    produto = ler(arq1, produto, quantidade);
    printf("Backup restaurado com sucesso!\n");
    system("pause");
    return produto;
}

void ordenarProdutos(PRODUTO *produto, int quantidade)
{
    PRODUTO temp;
    for (int i = 0; i < quantidade - 1; i++)
    {
        for (int j = i + 1; j < quantidade; j++)
        {
            if (strcmp(produto[i].nome, produto[j].nome) > 0)
            {
                temp = produto[i];
                produto[i] = produto[j];
                produto[j] = temp;
            }
        }
    }
}

void saindo(PRODUTO *produto, FILE *arq1, FILE *arq2, FILE *arq3)
{
    clear();
    free(produto);
    fclose(arq1);
    fclose(arq2);
    fclose(arq3);
}

void clear()
{
    system("cls");
}