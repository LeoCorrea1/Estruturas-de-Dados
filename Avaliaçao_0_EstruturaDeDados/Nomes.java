package EstruturaDeDados;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter; //tive que pesquisar para realizar o desafio extrra da atividade
import java.io.PrintWriter; //tive que pesquisar para realizar o desafio extrra da atividade

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

        for (int i = 0; i < qtd; i++) {
            String nomeCompleto;
            String[] vetorNome;
            String email;

            do {
                System.out.println("NOME COMPLETO: ");
                nomeCompleto = teclado.nextLine().trim();
                vetorNome = nomeCompleto.split(" ");

                if (vetorNome.length < 2) {
                    System.out.println("NOME INCOMPLETO, INSIRA NOVAMENTE");
                }
            } while (vetorNome.length < 2);

            email = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br").toLowerCase();

            int j = 1;
            String emailComNumero = email;
            while (nomesEmails.containsKey(emailComNumero)) {
                emailComNumero = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + (j+1) + "@ufn.edu.br").toLowerCase();
                j++;
            }
            email = emailComNumero;

            ArmazenarNomeEmail armazenar = new ArmazenarNomeEmail(nomeCompleto, email);
            nomesEmails.put(email, armazenar);
        }

        try (FileWriter arquivo = new FileWriter("nomes_emails.txt", true);
             PrintWriter escritor = new PrintWriter(arquivo)) {

            for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) {
                escritor.println(mostrarDicionario.nome + "," + mostrarDicionario.email);
            }
            System.out.println("\nDados salvos no arquivo 'nomes_emails.txt'.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo.");
        }

        System.out.println("\nInformações armazenadas:");

        for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) {
            mostrarDicionario.imprimir();
        }

        System.out.println("\ndeseja apagar os  do arquivo? (s/n)");
        String resposta = teclado.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            try (FileWriter arquivo = new FileWriter("nomes_emails.txt", false);
                 PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.print(""); // Limpa o conteúdo do arquivo ( TIVE AJUDA DO COPILOT DO INTELIJ )
                System.out.println("Arquivo limpo com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ao limpar o arquivo.");
            }
        }
    //esse filewriter e printWriter foi uma pesquisa que fiz para realizar o desafio extra da atividade

        teclado.close();
    }
}
