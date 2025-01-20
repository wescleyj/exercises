#include <stdio.h>
#define KL 18
int main(void)
{
    float tempo, velocidade, litros, distancia;

    printf("Digite o tempo em horas e a velocidade em quilometros/hora: ");
    scanf("%f %f", &tempo, &velocidade);

    distancia = tempo * velocidade;
    litros = distancia / KL;

    printf("A distancia percorrida e: %f\n A quantidade de combustivel gasto durante a viagem e: %f\n", distancia, litros);

    return 0;
}