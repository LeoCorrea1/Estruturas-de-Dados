#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

typedef struct no {
    int dado;
    struct no* prox;
} celula;

//COPIEI UMA BOA PARTE DE UM CODIGO UTILIZADO EM AULA SOBRE LISTA ( nó )

celula* inserir(int dado, celula* lista) {
    celula* novo = (celula*)malloc(sizeof(celula));
    novo->dado = dado;
    novo->prox = NULL;

    if (!lista) {
        return novo;
    }

    celula* p;
    for (p = lista; p->prox != NULL; p = p->prox) {}

    p->prox = novo;
    return lista;
}

void exibir(celula* lista) {
    if (!lista) {
        cout << "Lista vazia.\n";
        return;
    }
    for (celula* p = lista; p != NULL; p = p->prox) {
        cout << p->dado << " ";
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

int contarNumero(int dado, celula* lista) {
    int contadora = 0;
    for (celula* p = lista; p != NULL; p = p->prox) {
        if (dado == p->dado) {
            contadora++;
        }
    }
    return contadora;
}

void Ordenarlista3(celula* lista) {
    bool trocou;
    do {
        trocou = false;
        celula* p = lista;
        while (p->prox != NULL) {
            if (p->dado > p->prox->dado) {
                int temp = p->dado;
                p->dado = p->prox->dado;
                p->prox->dado = temp;
                trocou = true;
            }
            p = p->prox;
        }
    } while (trocou);
}

void exibirComuns(celula* lista1, celula* lista2) {
    for (celula* p1 = lista1; p1 != NULL; p1 = p1->prox) {
        for (celula* p2 = lista2; p2 != NULL; p2 = p2->prox) {
            if (p1->dado == p2->dado) {
                cout << p1->dado << " ";
                break;
            }
        }
    }
}

//COPIADO DO CHAT DO TEAMS
celula* remover(int dado, celula* lista) {
    celula* p, * pR;
    for (p = lista, pR = NULL; p != NULL; pR = p, p = p->prox) {
        if (p->dado == dado) {
            if (pR == NULL) {
                lista = p->prox;
            }
            else {
                pR->prox = p->prox;
            }
            free(p);
            return lista;
        }
    }
    return lista;
}

//COPIADO DO CHAT DO TEAMS
celula* RemoverPares(celula* lista) {
    celula* p = lista;

    while (p != NULL) {
        if (p->dado % 2 == 0) {
            lista = remover(p->dado, lista);
            p = lista;
        }
        else {
            p = p->prox;
        }
    }

    return lista;
}

celula* unirListas(celula* lista1, celula* lista2) {
    if (!lista1) return lista2;
    celula* p = lista1;
    while (p->prox != NULL) {
        p = p->prox;
    }
    p->prox = lista2;
    return lista1;
}

celula* deleteLista(celula* lista) {
    celula* p = lista;
        celula* lixo = p;
        p = p->prox;
        free(lixo);
    
    return NULL;
}

int main() {
    celula* lista1 = NULL;
    celula* lista2 = NULL;
    celula* lista3 = NULL;

    srand(time(0));

    for (int i = 0; i < 20; i++) {
        lista1 = inserir(rand() % 100 + 1, lista1);
    }

    for (int i = 0; i < 20; i++) {
        lista2 = inserir(rand() % 100 + 1, lista2);
    }

    cout << "\nLista1 contem " << contarLista(lista1) << " elementos\n";
    exibir(lista1);

    cout << "\nLista2 contem " << contarLista(lista2) << " elementos\n";
    exibir(lista2);

    cout << "\nElementos comuns entre Lista1 e Lista2:\n";
    exibirComuns(lista1, lista2);

    lista1 = RemoverPares(lista1);
    cout << "\n\nLista1 apos remover pares:\n";
    exibir(lista1);

    lista3 = unirListas(lista1, lista2);
    cout << "\nLista1 e Lista2 unidas (lista3):\n";
    exibir(lista3);

    cout << "\nLista3 ordenada:\n";
    Ordenarlista3(lista3);
    exibir(lista3);

    cout << "\nLista3 ordenada e com os pares removidos:\n";
    RemoverPares(lista3);
    exibir(lista3);


    lista3 = deleteLista(lista3);
    cout << "\nLista3 apagada:\n";
    exibir(lista3);

    return 0;
}
