package Estudo.EstruturaDados09_05;

import java.util.ArrayList;
import java.util.Random;

public class ListaRecursiva {

    static Random random = new Random();

    public static void preencherLista(ArrayList<Aluno> lista, int total, int atual) {
        if (atual < total) {
            int matricula = random.nextInt(100000000);
            String nome = "Aluno" + (atual + 1);
            Aluno a = new Aluno(matricula, nome);
            lista.add(a);
            preencherLista(lista, total, atual + 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Aluno> lista = new ArrayList<>();

        int quantidadeAlunos = 5;
        preencherLista(lista, quantidadeAlunos, 0);

        // Exibindo alunos
        for (Aluno a : lista) {
            System.out.println(a);
        }
    }
}
