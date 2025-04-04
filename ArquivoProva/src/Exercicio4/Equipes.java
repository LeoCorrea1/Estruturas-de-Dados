package Exercicio4;//Em sua linguagem de preferência, crie um programa (usando funções/métodos) que:
//preencha N nomes de equipes de futebol, obrigatóriamente em maiúsculo. Esses nomes devem ser armazenados em um dicionário que se possa controlar duplicados.
//exiba os nomes das equipes cadastradas
//exiba a quantidade de equipes cadastradas

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Equipes {
    String nome;
    int numTime;

    public Equipes(String nome, int numTime) {
        this.nome = nome;
        this.numTime = numTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipes equipes = (Equipes) o;
        return Objects.equals(nome, equipes.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "Exercicio4.Equipes{" +
                "nome='" + nome + '\'' +
                ", numTime=" + numTime +
                '}';
    }

    public static void main(String[] args) {
        String nome;
        int opcao;

        Map<String, Integer> dicionario = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite o nome do equipe e digite a posiçao da equipe na tabela:");

            Equipes e = new Equipes(sc.next(), sc.nextInt());
            e.nome = e.nome.toUpperCase();

            if (!dicionario.containsKey(e.nome)) {
                dicionario.put(e.nome, e.numTime);
            } else {
                System.out.println("Nome de equipe ja cadastrado");
            }
            System.out.println("1 - continua , 2 - finaliza");
            opcao = sc.nextInt();

        } while (opcao != 2);

        System.out.println("A lista Contem : ");

        for (var i : dicionario.entrySet()) {
            System.out.println("Nome do time em Maiusculo : " + i.getKey() + " ,  posiçao na tabela :  " + i.getValue());
        }
    }
}
