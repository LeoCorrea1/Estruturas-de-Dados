
#include <iostream>

using namespace std;

#include <cstdlib>

typedef struct no {
    int dado;
    struct no* prox;
} celula;

celula* inserir(int dado, celula* lista) {
    //alocar memória
    celula* novo = (celula*)malloc(sizeof(celula));

    //depositar valores que vem do parâmetro
    novo->dado = dado;
    novo->prox = NULL;
    string mensagem = "ja existe ";

    //testar se é o primeiro elemento a ser inserido
    if (!lista) { //if (lista == NULL)
        return novo;
    }
   
    //percorrer a estrutura até o final
    celula* p;
    for (p = lista; p->prox != NULL; p = p->prox) {

    }

    //encadear e retornar
    p->prox = novo;
    return lista;

}

void exibir(celula* lista) {
    for (celula* p = lista; p != NULL; p = p->prox) {
        cout << p->dado << "\t";
    }
    cout << endl;
}

int contarLista(celula* lista) {
    int total = 0;
    for (celula* p = lista; p != NULL; p = p->prox) {
        total++;
    }
    return total;
}

bool estaNaLista(int dado, celula* lista) {
    for (celula* p = lista; p != NULL; p = p->prox) {
        if (dado == p->dado) {
            return true;
        }
    }
    return false; // Mover para fora do for
}


int contarNumero(int dado, celula* lista) {
    int contadora = 0;
    for (celula* p = lista; p != NULL; p = p->prox) {
        if (dado == p->dado) {
            contadora++;
        }
    }
    return contadora;  
}


void verificarOrdenada(celula* lista) {
    for (celula *p = lista; p != NULL; p = p->prox) {
        if (p >= p) {
            cout << "lista nao esta ordenada !";
            return;
        }
        else {
            cout << " lista esta ordenada ";
            return;
        }
    }

}

double calcularMedia(celula* lista) {
    int soma = 0;
    int total = 0;

    for (celula* p = lista; p != NULL; p = p->prox) {
        soma += p->dado;
        total++;
    }

    if (total > 0) {
        return (double)soma / total;
    }

    return 0;
}

celula* novoinserir(int dado, celula* lista) {
   
    for (celula* p = lista; p != NULL; p = p->prox) {
        if (p->dado == dado) {
            cout << "O numero " << dado << " ja existe na lista.\n";
            return lista;  // Retorna a lista sem inserir o valor duplicado
        }
    }

    //alocar memória
    celula* novo = (celula*)malloc(sizeof(celula));

    //depositar valores que vem do parâmetro
    novo->dado = dado;
    novo->prox = NULL;

    //testar se é o primeiro elemento a ser inserido

    if (!lista) { //if (lista == NULL)
        return novo;
    }


    //percorrer a estrutura até o final
    celula* p;
    for (p = lista; p->prox != NULL; p = p->prox) {

    }

    //encadear e retornar
    p->prox = novo;
    return lista;

}

void Ordenar(celula* lista) {
    bool trocou;
    do {
        trocou = false;
        celula* p = lista;
        while (p->prox != NULL) {
            if (p->dado > p->prox->dado) {
                // Trocar os dados de p e p->prox
                int temp = p->dado;
                p->dado = p->prox->dado;
                p->prox->dado = temp;
                trocou = true;
            }
            p = p->prox;
        }
    } while (trocou); // Continuar enquanto houver trocas
}

int main() {
    celula* lista = NULL;

    //alterar o inserir para que controle duplicados

    lista = novoinserir(71, lista);
    lista = novoinserir(10, lista);
    lista = novoinserir(10, lista);
    lista = novoinserir(22, lista);
    lista = novoinserir(35, lista);
    lista = novoinserir(22, lista);
    lista = novoinserir(20, lista);
    lista = novoinserir(35, lista);
    lista = novoinserir(33, lista);

    cout << "\nlista contem " << contarLista(lista) << " elementos" ;
    cout << "\nlista sem repetidos : ";
    exibir(lista);


    int numero;

    cout << "\ndigite um numero para pesquisar: ";
    cin >> numero;

    cout << "\n";
    cout << numero << " esta na lista? " << estaNaLista(numero, lista) << endl;

    //contar quantas vezes o numero aparece

    int numero2;
    cout << "\ndigite um numero para pesquisar: ";
    cin >> numero2;

    contarNumero(numero2, lista);

    cout << "\n" << numero2 << " aparece na lista " << contarNumero(numero2, lista) << " vezes " << endl;
    cout << "\n";

    //verificar se a lista esta ou nao ordenada

    verificarOrdenada(lista);
    cout << "\n";

    //calcular a media dos elementos da lista

    cout << "\nA media dos numeros da lista eh: " << calcularMedia(lista) << "\n" <<  endl;


    // criar um metodo de ordenaçao da lista encadeada

    Ordenar(lista);
    cout << "lista ordenada : ";
    exibir(lista);

    return 1;


}
