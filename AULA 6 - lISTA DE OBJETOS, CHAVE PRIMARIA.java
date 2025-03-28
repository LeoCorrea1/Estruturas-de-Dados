import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Aluno {

    public String nome;
    public int matricula;
    public String email;

    public Aluno(int matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = this.gerarEmail();
    }

    public String gerarEmail() {
        String[] vetorNomes = this.nome.toLowerCase().split(" ");
        return vetorNomes[0] + "." + vetorNomes[vetorNomes.length - 1] + "@ufn.edu.br";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(this.email, aluno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email);
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Email: " + email;
    }

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Aluno tmp;
        String nome;
        int matricula = 1;
        String opcao;

        while (true) {

            System.out.println("Digite o nome do aluno: ");
            nome = scanner.nextLine().toUpperCase();
            tmp = new Aluno(matricula, nome);

            if (alunos.contains(tmp)) {
                System.out.println("Aluno com este email ja cadastrado!");
                System.gc();
            } else {
                alunos.add(tmp);
                System.out.println("Aluno cadastrado com sucesso! Matricula: " + matricula + " Email: " + tmp.email);
                matricula++;
            }

            System.out.println("CONTINUA ? (s/n)");
            opcao = scanner.nextLine();

            if (!opcao.equals("s"))
                break;
        }

        alunos.sort((aluno1, aluno2) -> aluno1.nome.compareTo(aluno2.nome));

        System.out.println("Relação de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
