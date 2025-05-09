#include <iostream>
#include <ctime>

using namespace std;

void popularVetorR(int vetor[], int n) {
    if (n > 0) {
        vetor[n - 1] = rand() % 20;
        popularVetorR(vetor, n - 1);
    }
}

void exibirVetorR(int vetor[], int n) {
    if (n > 0) {
        //código executado antes do empilhamento
        exibirVetorR(vetor, n - 1);
        //código executado depois do empilhamento
        cout << vetor[n - 1] << "\t";
    }
}


int main() {
    int vetor[10];
    srand(time(NULL));
    popularVetorR(vetor, 10);
    exibirVetorR(vetor, 10);
    cout << "\n";

    return 1;
}
