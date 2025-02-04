#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    char nome[50];
    int matricula;
    float nota;
} ALUNO;

void adicionarAluno(ALUNO **aluno, int *tam);
void menu(ALUNO **aluno, int *tam);
int lerDados(FILE *arquivo, ALUNO **aluno);

int main(void)
{
    ALUNO *aluno = NULL;
    FILE *arquivo = fopen("alunos.bin", "rb");

    int tam = 0, i = 0;

    if (arquivo != NULL){
        tam = lerDados(arquivo, &aluno);
    }

    if (tam > 0)
    {
        printf("\n=== Alunos Cadastrados ===\n");
        for (i = 0; i < tam; i++)
        {
            printf("Nome: %s", aluno[i].nome);
            printf("Matricula: %d\n", aluno[i].matricula);
            printf("Nota: %.2f\n\n", aluno[i].nota);
        }
    }
    else
    {
        printf("Nenhum aluno encontrado.\n");
    }

    menu(&aluno, &tam);

    free(aluno);

    return 0;
}

void menu(ALUNO **aluno, int *tam)
{
    int opcao;

    do
    {
        printf("\n=== Menu ===\n");
        printf("1. Adicionar Aluno\n");
        printf("2. Sair\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);
        getchar();

        switch (opcao)
        {
        case 1:
            adicionarAluno(aluno, tam);
            break;
        case 2:
            printf("Saindo...\n");
            break;
        default:
            printf("Opcao invalida! Tente novamente.\n");
        }
    } while (opcao != 2);
}

int lerDados(FILE *arquivo, ALUNO **aluno)
{
    int i = 0;
    ALUNO temp;

    while (fread(&temp, sizeof(ALUNO), 1, arquivo) == 1)
    {
        *aluno = realloc(*aluno, (i + 1) * sizeof(ALUNO));
        if (*aluno == NULL)
        {
            printf("Erro ao alocar memoria\n");
            return 0;
        }
        (*aluno)[i] = temp;
        i++;
    }

    fclose(arquivo);
    return i;
}

void adicionarAluno(ALUNO **aluno, int *tam)
{
    FILE *arquivo = fopen("alunos.bin", "ab");

    if (arquivo == NULL)
    {
        printf("Erro ao abrir o arquivo\n");
        return;
    }

    ALUNO novo;

    printf("Nome: ");
    fgets(novo.nome, 50, stdin);
    printf("Matricula: ");
    scanf("%d", &novo.matricula);
    printf("Nota: ");
    scanf("%f", &novo.nota);
    getchar();

    fwrite(&novo, sizeof(ALUNO), 1, arquivo);
    fclose(arquivo);

    // Realocação correta do ponteiro
    *aluno = realloc(*aluno, (*tam + 1) * sizeof(ALUNO));
    if (*aluno == NULL)
    {
        printf("Erro ao alocar memoria\n");
        return;
    }

    (*aluno)[*tam] = novo;
    (*tam)++;

    printf("Aluno adicionado com sucesso!\n");
}
