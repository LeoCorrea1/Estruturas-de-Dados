package EstruturaDeDados;

import java.util.HashMap; // Importa a classe HashMap para criar um mapa.
import java.util.Map; // Importa a interface Map.
import java.util.Scanner; // Importa a classe Scanner para entrada de dados do usuário.
import java.io.FileWriter; // Importa a classe FileWriter para escrever em arquivos.
import java.io.PrintWriter; // Importa a classe PrintWriter para facilitar a escrita em arquivos.

class ArmazenarNomeEmail {
    String nome; // Declara uma variável para armazenar o nome.
    String email; // Declara uma variável para armazenar o email.

    public ArmazenarNomeEmail(String nome, String email) {
        this.nome = nome; // Inicializa o nome com o valor fornecido.
        this.email = email; // Inicializa o email com o valor fornecido.
    }

    public void imprimir() {
        System.out.println("Nome Completo: " + this.nome + " , Email: " + this.email); // Imprime o nome e o email.
    }
}

public class Nomes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do teclado.
        Map<String, ArmazenarNomeEmail> nomesEmails = new HashMap<>(); // Cria um HashMap para armazenar emails como chaves e objetos ArmazenarNomeEmail como valores.

        System.out.println("QUANTOS NOMES DESEJA INSERIR?"); // Solicita ao usuário a quantidade de nomes a serem inseridos.
        int qtd = teclado.nextInt(); // Lê a quantidade de nomes.
        teclado.nextLine(); // Consome a quebra de linha pendente.

        for (int i = 0; i < qtd; i++) { // Loop para inserir a quantidade de nomes especificada.
            String nomeCompleto; // Declara uma variável para armazenar o nome completo.
            String[] vetorNome; // Declara um array de strings para armazenar as partes do nome.
            String email; // Declara uma variável para armazenar o email.

            do {
                System.out.println("NOME COMPLETO: "); // Solicita o nome completo.
                nomeCompleto = teclado.nextLine().trim(); // Lê o nome completo e remove espaços em branco no início e no fim.
                vetorNome = nomeCompleto.split(" "); // Divide o nome completo em partes usando o espaço como delimitador.

                if (vetorNome.length < 2) { // Verifica se o nome tem pelo menos duas partes (nome e sobrenome).
                    System.out.println("NOME INCOMPLETO, INSIRA NOVAMENTE"); // Informa que o nome está incompleto.
                }
            } while (vetorNome.length < 2); // Repete até que um nome completo seja inserido.

            email = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br").toLowerCase(); // Gera o email usando a primeira e a última parte do nome, convertendo para minúsculo.

            int j = 1; // Inicializa um contador para lidar com emails duplicados.
            String emailComNumero = email; // Cria uma cópia do email original.
            while (nomesEmails.containsKey(emailComNumero)) { // Verifica se o email já existe no mapa.
                emailComNumero = (vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + (j + 1) + "@ufn.edu.br").toLowerCase(); // Adiciona um número ao email caso já exista.
                j++; // Incrementa o contador.
            }
            email = emailComNumero; // Atualiza a variável email com o email único.

            ArmazenarNomeEmail armazenar = new ArmazenarNomeEmail(nomeCompleto, email); // Cria um objeto ArmazenarNomeEmail com o nome completo e o email gerado.
            nomesEmails.put(email, armazenar); // Adiciona o email e o objeto ao mapa.
        }

        try (FileWriter arquivo = new FileWriter("nomes_emails.txt", true); // Abre o arquivo "nomes_emails.txt" para escrita, adicionando ao final (append).
             PrintWriter escritor = new PrintWriter(arquivo)) { // Cria um PrintWriter para escrever no arquivo de forma mais fácil.

            for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) { // Itera sobre os valores (objetos ArmazenarNomeEmail) no mapa.
                escritor.println(mostrarDicionario.nome + "," + mostrarDicionario.email); // Escreve o nome e o email no arquivo, separados por vírgula.
            }
            System.out.println("\nDados salvos no arquivo 'nomes_emails.txt'."); // Informa que os dados foram salvos no arquivo.
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo."); // Trata possíveis erros ao salvar o arquivo.
        }

        System.out.println("\nInformações armazenadas:"); // Informa que as informações armazenadas serão exibidas.

        for (ArmazenarNomeEmail mostrarDicionario : nomesEmails.values()) { // Itera novamente sobre os valores no mapa.
            mostrarDicionario.imprimir(); // Chama o método imprimir de cada objeto para exibir o nome e o email.
        }

        System.out.println("\ndeseja apagar os  do arquivo? (s/n)"); // Pergunta ao usuário se deseja apagar o conteúdo do arquivo.
        String resposta = teclado.nextLine(); // Lê a resposta do usuário.
        if (resposta.equalsIgnoreCase("s")) { // Verifica se a resposta é "s" (ignorando a caixa).
            try (FileWriter arquivo = new FileWriter("nomes_emails.txt", false); // Abre o arquivo para escrita, sobrescrevendo o conteúdo existente.
                 PrintWriter escritor = new PrintWriter(arquivo)) { // Cria um PrintWriter para escrever no arquivo.
                escritor.print(""); // Escreve uma string vazia no arquivo, efetivamente limpando seu conteúdo.
                System.out.println("Arquivo limpo com sucesso."); // Informa que o arquivo foi limpo.
            } catch (Exception e) {
                System.out.println("Erro ao limpar o arquivo."); // Trata possíveis erros ao limpar o arquivo.
            }
        }
    //esse filewriter e printWriter foi uma pesquisa que fiz para realizar o desafio extra da atividade

        teclado.close(); // Fecha o objeto Scanner para liberar recursos.
    }
}
