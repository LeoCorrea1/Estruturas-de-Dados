package Aula2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Aula2 {
    public static void main(String[] args) {
        // Codigo que popula uma lista com números aleatórios inteiros
        ArrayList<Integer> lista = new ArrayList<>();
        Random gerador = new Random();
        int tamanho = gerador.nextInt(10, 15);  // Tamanho da lista (entre 10 e 19)
        int numero;

        // Inserir números aleatórios na lista
        for (int i = 0; i < tamanho; i++) {
            numero = gerador.nextInt(1000);  // Gera um número aleatório de 0 a 999
            if (!lista.contains(numero)) {
                lista.add(numero);  // Só adiciona se o número não existir na lista
            }
        }
        
        //ordenar
        lista.sort(null);
        
        // Exibir por índices
		
		  System.out.println("EXIBINDO POR ÍNDICES"); for (int i = 0; i < lista.size();
		  i++) { System.out.println(lista.get(i));
		  
		  } System.out.println("TOTAL DE " +lista.size() + "numeros\n\n");
		 

        // Exibir por objetos
        System.out.println("EXIBINDO POR OBJETOS");
        for (Integer i : lista) {
            System.out.println(i);
            
        }
        System.out.println("TOTAL DE " +lista.size() + "numeros\n\n");
        
        // Exibir usando Iterator
		
		  System.out.println("USANDO ITERATOR"); Iterator<Integer> iterator =
		  lista.iterator();
		  
		  while (iterator.hasNext()) { numero = iterator.next();
		  System.out.println(numero); } System.out.println("TOTAL DE " +lista.size() +
		  "numeros\n\n");
		 
    
			if(lista.remove((Integer)145)){
				System.out.println("\n\nnumero localizado e excluido");
			}else {
				System.out.println("\n\nNumero nao localizado");
			}
			
		//percorrer
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i) % 2 != 0) {
					lista.set(i,-1);
				
				}
			}
			System.out.println("EXIBINDO POR OBJETOS ALTERANDO NUMEROS IMPARES PARA -1");
			System.out.println("TOTAL DE " +lista.size() + "numeros\n\n");
	        for (Integer i : lista) {
	            System.out.println(i);
	            
	        }
	       
			
			
    }
}
		
		


//add() , suze(), contains(), sort() . 
