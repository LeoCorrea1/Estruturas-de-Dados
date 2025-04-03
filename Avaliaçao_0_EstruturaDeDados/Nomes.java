package EstruturaDeDados;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;   // Usado para abrir/criar arquivos e escrever dados
import java.io.PrintWriter; // Usado para facilitar a escrita formatada no arquivo

// Classe para armazenar os dados de nome e email
class ArmazenarNomeEmail {
    String nome;
    String email;

    // Construtor que recebe nome e email e armazena nas variáveis da classe
    public ArmazenarNomeEmail(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Método para exibir os dados formatados no terminal
    public void imprimir() {
        System.out.println("Nome Completo: " + this.nome + " , Email: " + this.email);
    }
}

public class Nomes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Entrada do usuário pelo teclado

        // Mapa que armazena o email como chave e o objeto com nome/email como valor
        Map<String, ArmazenarNomeEmail> nomesEmails = new HashMap<>();

        System.out.println("QUANTOS NOMES DESEJA INSERIR?");
        int qtd = teclado.nextInt(); // Lê a quantidade de nomes a serem inseridos
        teclado.nextLine(); // Limpa o buffer do scanner (evita pular a próxima entrada)

        // Loop para inserir os nomes e gerar os emails
        for (int i = 0; i < qtd; i++) {
            String nomeCompleto;
            String[] vetorNome;
            String email;

            // Validação do nome completo: exige pelo menos 2 palavras
            do {
                System.out.println("NOME COMPLETO: ");
                nomeCompleto = teclado.nextLine().trim(); // Remove espaços extras antes/depois
                vetorNome = nomeCompleto.split(" "); // Separa o nome em palavras

                if (vetorNome.length < 2) {
                    System.out.println("NOME INCOMPLETO, INSIRA NOVAMENTE");
                }
            } while (vetorNome.length < 2); // Continua até nome ser considerado "completo"

            // Gera email no formato nome.sobrenome@ufn.edu.br
            email = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br").toLowerCase();

            int j = 1; // Contador para resolver duplicação de email
            String emailComNumero = email;

            // Verifica se o email gerado já existe; se existir, adiciona número no final
            while (nomesEmails.containsKey(emailComNumero)) {
                // Gera um novo email com número incrementado (evita duplicatas)
                emailComNumero = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + (j + 1) + "@ufn.edu.br").toLowerCase();
                j++;
            }
            email = emailComNumero; // Define email final (único)

            // Cria um objeto com nome e email
            ArmazenarNomeEmail armazenar = new ArmazenarNomeEmail(nomeCompleto, email);

            // Adiciona o objeto no mapa usando o email como chave
            nomesEmails.put(email, armazenar);
        }

        // Bloco try-with-resources: cria/escreve no arquivo (append: true = adiciona sem apagar)
        try (FileWriter arquivo = new FileWriter("nomes_emails.txt", true);
             PrintWriter escritor = new PrintWriter(arquivo)) {

            // Percorre todos os valores do mapa (objetos) e grava no arquivo
            for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) {
                escritor.println(mostrarDicionario.nome + "," + mostrarDicionario.email); // Escreve no formato CSV
            }

            System.out.println("\nDados salvos no arquivo 'nomes_emails.txt'."); // Confirmação ao usuário

        } catch (Exception e) {
            // Captura qualquer erro ao tentar salvar o arquivo
            System.out.println("Erro ao salvar o arquivo.");
        }

        System.out.println("\nInformações armazenadas:");

        // Imprime na tela todos os dados armazenados
        for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) {
            mostrarDicionario.imprimir(); // Chama método da classe para imprimir nome e email
        }

        // Pergunta ao usuário se deseja apagar o conteúdo do arquivo
        System.out.println("\ndeseja apagar os  do arquivo? (s/n)");
        String resposta = teclado.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            // Bloco que sobrescreve o conteúdo do arquivo com string vazia (limpeza)
            try (FileWriter arquivo = new FileWriter("nomes_emails.txt", false);
                 PrintWriter escritor = new PrintWriter(arquivo)) {

                escritor.print(""); // Escreve nada → limpa o arquivo
                System.out.println("Arquivo limpo com sucesso.");

            } catch (Exception e) {
                // Caso ocorra erro na tentativa de limpar
                System.out.println("Erro ao limpar o arquivo.");
            }
        }

        // Fecha o scanner para liberar recurso
        teclado.close();
    }
}
