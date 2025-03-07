package EDD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Code1 {
    public static void main(String[] args) {
        Random gerador = new Random();
        int quantidade = 10;


        List<Integer> lista1 = new ArrayList<>();
        while (lista1.size() < quantidade) {
            int numero = gerador.nextInt(100); 
            if (!lista1.contains(numero)) {
                lista1.add(numero);
            }
        }

        System.out.println("Números Gerados para a Lista 1:");
        for (int numero : lista1) {
            System.out.println(numero);
        }

        List<Integer> lista2 = new ArrayList<>();
        while (lista2.size() < quantidade) {
            int numero = gerador.nextInt(100); 
            if (!lista2.contains(numero)) {
                lista2.add(numero);
            }
        }

        System.out.println("\nNúmeros Gerados para a Lista 2:");
        for (int numero : lista2) {
            System.out.println(numero);
        }

        List<Integer> listaComum = new ArrayList<>();
        for (int numero : lista1) {
            if (lista2.contains(numero)) {
                listaComum.add(numero);
            }
        }

        System.out.println("\nNúmeros em comum entre as duas listas:");
        for (int numero : listaComum) {
            System.out.println(numero);
        }
    }
}
