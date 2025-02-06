#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n;
    printf("Digite o numero de alunos: ");
    scanf("%d", &n);
    getchar();

    char(*nomes)[41] = malloc(n * sizeof(*nomes));
    float *notas = malloc(n * sizeof(float));

    for (int i = 0; i < n; i++)
    {
        printf("Digite o nome do aluno %d: ", i + 1);
        fgets(nomes[i], 41, stdin);
        nomes[i][strcspn(nomes[i], "\n")] = '\0';

        printf("Digite a nota do aluno %d: ", i + 1);
        scanf("%f", &notas[i]);
        getchar();
    }

    FILE *file = fopen("notas.txt", "w");
    for (int i = 0; i < n; i++)
    {
        fprintf(file, "%-40s %.2f\n", nomes[i], notas[i]);
    }

    printf("Dados cadastrados com sucesso!");
    getchar();
    system("clear");

    fclose(file);
    free(nomes);
    free(notas);

    file = fopen("notas.txt", "r");

    if (!file)
    {
        return 1;
    }

    int num_alunos = 0;
    float soma_notas = 0, nota;
    char nome[41];

    while (fscanf(file, "%40c %f\n", nome, &nota) != EOF)
    {
        num_alunos++;
        soma_notas += nota;
    }
    fclose(file);

    float media = soma_notas / num_alunos;

    file = fopen("notas.txt", "r");
    FILE *output = fopen("totais.txt", "w");
    if (!output)
        return 1;

    while (fscanf(file, "%40c %f\n", nome, &nota) != EOF)
    {
        nome[40] = '\0';
        fprintf(output, "%s %.2f\n", nome, nota - media);

        printf("%s %.2f\n", nome, nota - media);
    }
    fprintf(output, "Media %.2f\n", media);

    printf("Media");
    for (int i = 0; i < 36; i++)
    {
        printf(" ");
    }
    printf("%.2f\n", media);

    fclose(file);
    fclose(output);

    return 0;
}