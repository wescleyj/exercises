#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ARQUIVO "alunos.bin"

typedef struct
{
    int matricula;
    char nome[50];
    float nota;
} Aluno;

int lerDados(Aluno **aluno);

int main(void) {
    Aluno *aluno = NULL;

    int tam = lerDados(&aluno);

    menu(&aluno, tam);

    return 0;
}

int lerDados(Aluno **aluno) {
    FILE *arq = fopen(ARQUIVO, "rb");
    int i = 0;

    Aluno temp;

    if (arq == NULL) {
        printf("Erro ao abrir o arquivo %s\n", ARQUIVO);
        return 1;
    }

    while (fread(&temp, sizeof(Aluno), 1, arq) == 1)
    {
        realloc(*aluno, (i + 1) * sizeof(Aluno));
        if (*aluno == NULL) {
            printf("Erro ao alocar memoria\n");
            return 0;
        }

        (*aluno)[i] = temp;
        i++;
    }

    fclose(arq);

    return i;
}

void cadastarAluno(Aluno **aluno, int *tam) {
    FILE *arq = fopen(ARQUIVO, "ab");

    if (arq == NULL) {
        printf("Erro ao abrir o arquivo %s\n", ARQUIVO);
        return;
    }

    Aluno novo;

    printf("Nome: ");
    fgets(novo.nome, 50, stdin);
    printf("Matricula: ");
    scanf("%d", &novo.matricula);
    printf("Nota: ");
    scanf("%f", &novo.nota);
    getchar();

    fwrite(&novo, sizeof(Aluno), 1, arq);
    fclose(arq);

    *aluno = realloc(*aluno, (*tam + 1) * sizeof(Aluno));
    if (*aluno == NULL) {
        printf("Erro ao alocar memoria\n");
        return;
    }

    (*aluno)[*tam] = novo;
    (*tam)++;

    printf("Aluno adicionado com sucesso!\n");
}