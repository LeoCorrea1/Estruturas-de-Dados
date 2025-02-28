package Aula2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Aula2 {
    public static void main(String[] args) {
        //codigo que popula uma lista com n numeros aleatorios inteiros
        ArrayList<Integer> lista = new ArrayList<>();
        
        Random gerador = new Random();
        int tamanho = gerador.nextInt(10,20);
        int numero;
        
        // Inserir números aleatórios na lista
        for(int i = 0; i < tamanho; i++) {
            numero = gerador.nextInt(1000);  // Gera um número aleatório de 0 a 999
            lista.add(numero);
        }
        
        // Exibir por índices
        System.out.println("EXIBINDO POR INDICES");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        // Exibir por objetos
        System.out.println("EXIBINDO POR OBJETOS");
        for(Integer i : lista) {
            System.out.println(i);
        }
        
        // Exibir Usando Iterator
        System.out.println("USANDO ITERATOR");
        Iterator<Integer> iterator = lista.iterator();
        while(iterator.hasNext()) {
            numero = iterator.next();
            System.out.println(numero);
        }
    }
}