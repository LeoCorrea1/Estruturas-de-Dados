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
        String email;
        
        for (int i = 0; i < qtd; i++) {
            do {
                System.out.println("NOME COMPLETO: ");
                nomeCompleto = teclado.nextLine();
                vetorNome = nomeCompleto.split(" ");
                email = vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br";
                email = email.toLowerCase();

                if (vetorNome.length < 2) {
                    System.out.println("NOME INCOMPLETO, INSIRA NOVAMENTE");
                }

                int j = 1; 
                String emailComNumero = email; 
                while (nomesEmails.containsKey(emailComNumero)) {
                    emailComNumero = vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + (j+1) + "@ufn.edu.br";
                    emailComNumero = emailComNumero.toLowerCase();
                    j++;
                }

                email = emailComNumero; 

            } while (vetorNome.length < 2 || nomesEmails.containsKey(email));

            ArmazenarNomeEmail armazenar = new ArmazenarNomeEmail(nomeCompleto, email);
            nomesEmails.put(email, armazenar);  

        }

        System.out.println("\nInformações armazenadas no dicionário:");
        for (ArmazenarNomeEmail entry : nomesEmails.values()) {
            entry.imprimir();
        }

        teclado.close(); 
    }
}
