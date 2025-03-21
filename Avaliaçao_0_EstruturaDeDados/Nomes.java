import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ArmazenarNomeEmail {
    String nome;
    String email;

    public ArmazenarNomeEmail(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void imprimir() {
        System.out.println("Nome Completo: " + this.nome + " , Email: " + this.email);
    }
}

public class Nomes {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        Map<String, ArmazenarNomeEmail> nomesEmails = new HashMap<>();

        System.out.println("QUANTOS NOMES DESEJA INSERIR?");
        int qtd = teclado.nextInt();
        teclado.nextLine();

        String nomeCompleto;
        String vetorNome[];
        for (int i = 0; i < qtd; i++) {
            do {
                System.out.println("NOME COMPLETO: ");
                nomeCompleto = teclado.nextLine();
                vetorNome = nomeCompleto.split(" ");

                if (vetorNome.length < 2) {
                    System.out.println("NOME INCOMPLETO, INSIRA NOVAMENTE");
                }

                if (nomesEmails.containsKey(nomeCompleto)) {
                    System.out.println("NOME JÁ INSERIDO, INSIRA OUTRO NOME");
                }
            } while (vetorNome.length < 2 || nomesEmails.containsKey(nomeCompleto));


            String email = vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br";
            email = email.toLowerCase();

            ArmazenarNomeEmail armazenar = new ArmazenarNomeEmail(nomeCompleto, email);
            nomesEmails.put(email, armazenar);
            
        }

        System.out.println("\nInformações armazenadas no dicionário:");
        for (ArmazenarNomeEmail entry : nomesEmails.values()) {
            entry.imprimir();
        }
    }
}
