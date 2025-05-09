#include <iostream>

using namespace std;
#include "metodos.h"

void mostraPrimosSequenciaR(int numero ) {
    if( numero > 0 ){
        //codigo empilhamento 
       
        //ponto de recursao
     mostraPrimosSequenciaR(numero-1);

        //codigo de desenpilhamento

    if (ehPrimo(numero)){
            cout << numero << " eh primo \n";
        }else {
        cout << numero <<" nao eh primo\n";
        }
    }
}

int contarR(int numero){
    if(numero > 0){

        contarR(numero -1);

        return 1 + contarR(numero -1);
    }

}
int main(){
    int numero;
    cout << "digite um numero : " ;
    cin >> numero;


mostraPrimosSequenciaR(numero);

cout << "numeros contados : \n" ; 

cout << contarR(numero);
    return 1;
}
