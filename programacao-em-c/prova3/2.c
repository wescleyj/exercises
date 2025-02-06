#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    char nome[41];
    char Instituicao[41];
} AUTOR;

typedef struct
{
    int Identificador;
    char Titulo[41];
    AUTOR autor;
    int Ano;
    char Editora[41];
} LIVRO;

static LIVRO *livros = NULL;
static int qtdLivros = 0;

void inserirLivro();
void exibirLivros();
void exibirLivrosPorEditora(const char *edit);
void removerLivro(int id);

int main(void)
{
    LIVRO novo;

    int opcao, id;
    char nome[41];

    do
    {
        system("clear");
        printf("=========================\n");
        printf("1 - Inserir Livro\n");
        printf("2 - Exibir Livro\n");
        printf("3 - Exibir por editora\n");
        printf("4 - Remover Livro\n");
        printf("5 - Sair\n");
        scanf("%d", &opcao);

        switch (opcao)
        {
        case 1:
            printf("Digite o identificador: ");
            scanf("%d", &novo.Identificador);

            printf("Digite o titulo: ");
            scanf(" %40[^\n]", novo.Titulo);

            printf("Digite o nome do autor: ");
            scanf(" %40[^\n]", novo.autor.nome);

            printf("Digite a instituicao do autor: ");
            scanf(" %40[^\n]", novo.autor.Instituicao);

            printf("Digite o ano: ");
            scanf("%d", &novo.Ano);

            printf("Digite a editora: ");
            scanf(" %40[^\n]", novo.Editora);
            inserirLivro(&novo);

            printf("Livro incluido som sucesso\n");
            getchar();
            break;
        case 2:
            exibirLivros();
            break;
        case 3:
            printf("Qual a editora?\n");
            scanf(" %40[^\n]", nome);
            exibirLivrosPorEditora(nome);
            break;
        case 4:
            printf("Qual o id do livro?\n");
            scanf("%d", id);
            removerLivro(id);
            break;
        case 5:

            break;
        default:
            break;
        }
    } while (opcao != 5);

    removerLivro(1);

    return 0;
}

void inserirLivro(const LIVRO *novo)
{
    LIVRO *temp = realloc(livros, (qtdLivros + 1) * sizeof(LIVRO));
    if (temp == NULL)
        return;
    livros = temp;
    livros[qtdLivros++] = *novo;
}

void exibirLivros()
{
    for (int i = 0; i < qtdLivros; i++)
    {
        printf("ID: %d | Titulo: %s | Ano: %d | Editora: %s\n",
               livros[i].Identificador, livros[i].Titulo, livros[i].Ano, livros[i].Editora);
    }
    getchar();
    getchar();
}

void exibirLivrosPorEditora(const char *edit)
{
    for (int i = 0; i < qtdLivros; i++)
    {
        if (strcmp(livros[i].Editora, edit) == 0)
        {
            printf("ID: %d | Titulo: %s\n",
                   livros[i].Identificador, livros[i].Titulo);
        }
    }
    getchar();
    getchar();
}

void removerLivro(int id)
{
    for (int i = 0; i < qtdLivros; i++)
    {
        if (livros[i].Identificador == id)
        {
            for (int j = i; j < qtdLivros - 1; j++)
            {
                livros[j] = livros[j + 1];
            }
            qtdLivros--;
            break;
        }
    }
}
