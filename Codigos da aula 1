1 -
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int vetor[10], *vetorP[10], *vetorI[10], i, tamP = 0, tamI = 0;

    for(i = 0; i < 10; i++) {
        vetor[i] = rand() % 100;
        printf("%d ", vetor[i]);
    }
    printf("\n");

    for(i = 0; i < 10; i++) {
        if(vetor[i] % 2 == 0) {
            vetorP[tamP++] = vetor[i];
        } else {
            vetorI[tamI++] = vetor[i];
        }
    }

    printf("\nVetor par: ");
    for(i = 0; i < tamP; i++) {
        printf("%d ", vetorP[i]);
    }

    printf("\nVetor impar: ");
    for(i = 0; i < tamI; i++) {
        printf("%d ", vetorI[i]);
    }
    printf("\n\n");

    return 0;
}

2 -
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int vetor[10], *vetorP[10], *vetorI[10], i, tamP = 0, tamI = 0;

    for(i = 0; i < 10; i++) {
        vetor[i] = rand() % 100;
        printf("%d ", vetor[i]);
    }
    printf("\n");

    for(i = 0; i < 10; i++) {
        if(vetor[i] % 2 == 0) {
            vetorP[tamP++] = vetor[i];
        } else {
            vetorI[tamI++] = vetor[i];
        }
    }

    printf("\nVetor par: ");
    for(i = 0; i < tamP; i++) {
        printf("%d ", vetorP[i]);
    }

    printf("\nVetor impar: ");
    for(i = 0; i < tamI; i++) {
        printf("%d ", vetorI[i]);
    }
    printf("\n\n");

    return 0;
}


3-
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    FILE *file = fopen("dados.txt", "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    int num, i, j;
    int lidos[100];
    int c = 0;

    while (fscanf(file, "%d", &num) != EOF) {
        int rep = 0;
        for (i = 0; i < c; i++) {
            if (lidos[i] == num) {
                rep = 1;
                break;
            }
        }
        if (!rep) {
            lidos[c++] = num;
        }
    }

    fclose(file);

    for (i = 0; i < c; i++) {
        printf("%d\n", lidos[i]);
    }

    return 0;
}
