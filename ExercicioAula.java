package Aula2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ExercicioAula {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Digite o número de nomes a ser cadastrado: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); 
        
        // Codigo que popula uma lista com números aleatórios inteiros
        ArrayList<String> lista = new ArrayList<>();
        String nome;

        // Inserir números aleatórios na lista
        for (int i = 0; i < tamanho; i++) {
        	System.out.println("Digite Um nomes : ");
        	nome = scanner.nextLine();
            if (!lista.contains(nome)) {
                lista.add(nome);  
            }
        }
        
        //ordenar
        lista.sort(null);
        
        // Exibir usando Iterator
		
		  System.out.println("USANDO ITERATOR"); Iterator<String> iterator =
		  lista.iterator();
		  
		  while (iterator.hasNext()) { nome = iterator.next();
		  System.out.println(nome); } System.out.println("TOTAL DE " +lista.size() +
		  "numeros\n\n");


			System.out.println("EXIBINDO OS NOMES");
			System.out.println("TOTAL DE " +lista.size() + "  Nomes\n\n");
	        for (String i : lista) {
	            System.out.println(i);
	            
	        }
	        
	        System.out.println("\n\nDigite o nome que deseja excluir: ");
	        String nomeExcluir = scanner.nextLine();
	        if (lista.remove(nomeExcluir)) {
	            System.out.println("\n\nNome localizado e excluído: " + nomeExcluir);
	        } else {
	            System.out.println("\n\nNome não localizado.");
	        }


			System.out.println("\n\nEXIBINDO OS NOMES APOS EXCLUSAO");
			System.out.println("TOTAL DE " +lista.size() + "  Nomes\n\n");
	        for (String n : lista) {
	            System.out.println(n);
	            
	        }
			
    }
}
		
		


//add() , suze(), contains(), sort() . 
