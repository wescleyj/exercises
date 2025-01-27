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

Usuario usuarios[MAX_USERS];

int totalUsuarios = 0;

void adicionarUsuario();
void listarUsuarios();
void buscarUsuario();
void excluirUsuario();
void menu();
void clear();
void pause();

int main()
{
    menu();
    return 0;
}

void adicionarUsuario()
{
    clear();

    if (totalUsuarios >= MAX_USERS)
    {
        printf("Limite de usuários atingido!\n");
        return;
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
}

void listarUsuarios()
{
    clear();

    if (totalUsuarios == 0)
    {
        printf("Nenhum usuário cadastrado.\n");

        pause();
        return;
    }
    printf("\nLista de usuários cadastrados:\n");
    for (int i = 0; i < totalUsuarios; i++)
    {
        printf("Nome: %s | CPF: %s | Curso: %s\n", usuarios[i].nome, usuarios[i].cpf, usuarios[i].curso);
    }

    pause();
}

void buscarUsuario()
{
    clear();

    char cpfBusca[15];
    printf("Digite o CPF para buscar: ");
    scanf(" %[^\n]", cpfBusca);

    for (int i = 0; i < totalUsuarios; i++)
    {
        if (strcmp(usuarios[i].cpf, cpfBusca) == 0)
        {
            printf("Usuário encontrado: Nome: %s | Curso: %s\n", usuarios[i].nome, usuarios[i].curso);

            pause();
            return;
        }
    }
    printf("Usuário com CPF %s não encontrado.\n", cpfBusca);

    pause();
}

void excluirUsuario()
{
    clear();

    char cpfBusca[15];
    printf("Digite o CPF do usuário a ser excluído: ");
    scanf(" %[^\n]", cpfBusca);

    for (int i = 0; i < totalUsuarios; i++)
    {
        if (strcmp(usuarios[i].cpf, cpfBusca) == 0)
        {
            for (int j = i; j < totalUsuarios - 1; j++)
            {
                usuarios[j] = usuarios[j + 1];
            }
            totalUsuarios--;
            printf("Usuário removido com sucesso!\n");

            pause();
            return;
        }
    }
    
    printf("Usuário com CPF %s não encontrado.\n", cpfBusca);

    pause();
}

void menu()
{
    int opcao;
    do
    {
        clear();

        printf("\n--- MENU ---\n");
        printf("1. Adicionar usuário\n");
        printf("2. Listar usuários\n");
        printf("3. Buscar usuário por CPF\n");
        printf("4. Excluir usuário por CPF\n");
        printf("5. Sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);

        switch (opcao)
        {
        case 1:
            adicionarUsuario();
            break;
        case 2:
            listarUsuarios();
            break;
        case 3:
            buscarUsuario();
            break;
        case 4:
            excluirUsuario();
            break;
        case 5:
            printf("Saindo...\n");
            break;
        default:
            printf("Opção inválida! Tente novamente.\n");
            pause();
            break;
        }
    } while (opcao != 5);
}

void clear() {
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

void pause() {
    printf("\nPressione enter para continuar...");
    getchar();
    getchar();
}