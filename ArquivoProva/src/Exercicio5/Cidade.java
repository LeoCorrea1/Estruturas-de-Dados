package Exercicio5;//Em sua linguagem de preferência, crie um programa (usando funções/métodos) que:
//preencha N nomes de equipes de futebol, obrigatóriamente em maiúsculo. Esses nomes devem ser armazenados em um dicionário que se possa controlar duplicados.
//exiba os nomes das equipes cadastradas
//exiba a quantidade de equipes cadastradas

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Cidade {
    String nome;
    String sigla;

    public Cidade(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(nome, cidade.nome) && Objects.equals(sigla, cidade.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sigla);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String nome;
        int opcao;

        Map<String,String> dicionario = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite o nome da cidade e sua Sigla de estado:");

            Cidade c = new Cidade(sc.next(), sc.next());
            c.nome = c.nome.toUpperCase().trim().split(" ")[0];
            c.sigla = c.sigla.toUpperCase();

            if (!dicionario.containsKey(c.nome)) {
                dicionario.put(c.nome,c.sigla);
            } else {
                System.out.println("Cidade ja cadastrada");
            }
            System.out.println("1 - continua , 2 - finaliza");
            opcao = sc.nextInt();

        } while (opcao != 2);

        System.out.println("A lista Contem : ");

        for (var i : dicionario.entrySet()) {
            System.out.println("Nome da cidade em Maiusculo  : " + i.getKey() + " ,  Sigla do estado :  " + i.getValue());
        }

        System.out.println(" \nDIGITE UMA CIDADE PARA REMOVER :");
            dicionario.remove(sc.next().toUpperCase());

        System.out.println("\nA nova lista Contem : ");

        for (var i : dicionario.entrySet()) {
            System.out.println("Nome da cidade em Maiusculo  : " + i.getKey() + " ,  Sigla do estado :  " + i.getValue());
        }

        System.out.println(" \nDIGITE UMA CIDADE PARA PROCURAR A SIGLA:");
        System.out.println("SIGLA DO ESTADO : " + dicionario.get(sc.next().toUpperCase()));


    }
}
