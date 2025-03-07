package EDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Code1 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        Random gerador = new Random();

        int quantidade = 11;
        
        for (int j = 0; j < quantidade; j++) {
            lista.add(gerador.nextInt(191) + 50); 
        }

        lista.sort(null);

        System.out.println("Números da glicose:");
        for (int numeroGlic : lista) {
            System.out.println(numeroGlic);
        }

        float soma = 0;
        for (int numeroGlic : lista) {
            soma += numeroGlic;
        }
        float media = soma / quantidade;
        System.out.printf("\nA média da Glicose está em : %.2f%n", media); // Formata com 2 casas decimais

        int mediana;
        if (quantidade % 2 != 0) {
            mediana = lista.get(quantidade / 2);
        } else {
            mediana = (lista.get(quantidade / 2 - 1) + lista.get(quantidade / 2)) / 2;
        }
        System.out.println("\nMediana dos números: " + mediana);

        int moda = 0;
        int maiorQuant = 0;

        for (int numeroGlic : lista) {
            int contador = 0;
            for (int num : lista) {
                if (numeroGlic == num) {
                    contador++;
                }
            }
            if (contador > maiorQuant) {
                maiorQuant = contador;
                moda = numeroGlic;
            }
        }

        if (maiorQuant > 1) {
            System.out.println("\nA moda é: " + moda);
        } else {
            System.out.println("\nNão há números que aparecem duas ou mais vezes.");
        }
    }
}
