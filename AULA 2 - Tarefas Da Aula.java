//Tarefas AULA 2 :
//Para colocar o nome em maiúsculo antes de armazená-lo em uma lista, você pode usar o método toUpperCase() da classe String. Aqui está um exemplo simples:
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();

        System.out.println("Digite um nome:");
        String nome = scanner.nextLine();

        // Converte o nome para maiúsculo antes de adicionar à lista
        nomes.add(nome.toUpperCase());

        System.out.println("Lista de nomes: " + nomes);
        
        scanner.close();
    }
}

//Descobrir a diferença em java de vector,arraylist e linkedlist, construir exemplos

Vector:
//Cresce dinamicamente e é sincronizado (thread-safe), mas mais lento.
//Exemplo:
Vector<String> vector = new Vector<>();
vector.add("A");

ArrayList:
//Cresce dinamicamente, mas não é sincronizado, oferecendo melhor desempenho que Vector.
//Exemplo:
ArrayList<String> arrayList = new ArrayList<>();
arrayList.add("A");

LinkedList:
//Baseado em uma lista duplamente encadeada, tem inserção e remoção mais rápidas, mas busca mais lenta.
//Exemplo:
LinkedList<String> linkedList = new LinkedList<>();
linkedList.add("A");


Resumindo:

Vector: Sincronizado e mais lento.
ArrayList: Não sincronizado, melhor desempenho para leitura.
LinkedList: Mais eficiente para inserção/remoção, menos para acesso aleatório.
