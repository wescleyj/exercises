#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_USERS 100

typedef struct
{
    char nome[50];
    char cpf[15];
    char curso[50];
} Usuario;

void salvarUsuarios(Usuario usuarios[], int totalUsuarios);
int carregarUsuarios(Usuario usuarios[]);
void listarNomesUsuarios(Usuario usuarios[], int totalUsuarios);
void contarAlunosEngenharia(Usuario usuarios[], int totalUsuarios);
void menu();
void clear();
void pause();

int main()
{
    menu();
    return 0;
}

void salvarUsuarios(Usuario usuarios[], int totalUsuarios)
{
    FILE *file = fopen("usuarios.dat", "wb");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo para escrita!\n");
        pause();
        return;
    }

    fwrite(&totalUsuarios, sizeof(int), 1, file);
    fwrite(usuarios, sizeof(Usuario), totalUsuarios, file);
    fclose(file);

    printf("Dados salvos com sucesso!\n");
    pause();
}

int carregarUsuarios(Usuario usuarios[])
{
    FILE *file = fopen("usuarios.dat", "rb");
    if (file == NULL)
    {
        return 0;
    }

    int totalUsuarios;
    fread(&totalUsuarios, sizeof(int), 1, file);
    fread(usuarios, sizeof(Usuario), totalUsuarios, file);
    fclose(file);

    return totalUsuarios;
}

void listarNomesUsuarios(Usuario usuarios[], int totalUsuarios)
{
    if (totalUsuarios == 0)
    {
        printf("Nenhum usuário cadastrado.\n");
        pause();
        return;
    }

    printf("\nLista de nomes dos usuários:\n");
    for (int i = 0; i < totalUsuarios; i++)
    {
        printf("- %s\n", usuarios[i].nome);
    }

    pause();
}

void contarAlunosEngenharia(Usuario usuarios[], int totalUsuarios)
{
    int count = 0;

    for (int i = 0; i < totalUsuarios; i++)
    {
        if (strcmp(usuarios[i].curso, "Engenharia de Computação") == 0)
        {
            count++;
        }
    }

    printf("Total de alunos de Engenharia de Computação: %d\n", count);
    pause();
}

void menu()
{
    Usuario usuarios[MAX_USERS];
    int totalUsuarios = carregarUsuarios(usuarios);
    int opcao;

    do
    {
        clear();
        printf("\n--- MENU ---\n");
        printf("1. Adicionar usuário\n");
        printf("2. Listar nomes dos usuários\n");
        printf("3. Contar alunos de Engenharia de Computação\n");
        printf("4. Salvar e sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);
        getchar();

        switch (opcao)
        {
        case 1:
            if (totalUsuarios >= MAX_USERS)
            {
                printf("Limite de usuários atingido!\n");
                pause();
                break;
            }

            printf("Nome: ");
            scanf(" %[^\n]", usuarios[totalUsuarios].nome);

            printf("CPF: ");
            scanf(" %[^\n]", usuarios[totalUsuarios].cpf);

            printf("Curso: ");
            scanf(" %[^\n]", usuarios[totalUsuarios].curso);

            totalUsuarios++;
            printf("Usuário cadastrado com sucesso!\n");

            pause();
            break;

        case 2:
            listarNomesUsuarios(usuarios, totalUsuarios);
            break;

        case 3:
            contarAlunosEngenharia(usuarios, totalUsuarios);
            break;

        case 4:
            salvarUsuarios(usuarios, totalUsuarios);
            printf("Saindo...\n");
            break;

        default:
            printf("Opção inválida! Tente novamente.\n");
            pause();
        }
    } while (opcao != 4);
}

void clear()
{
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

void pause()
{
    printf("Pressione ENTER para continuar...");
    getchar();
}
