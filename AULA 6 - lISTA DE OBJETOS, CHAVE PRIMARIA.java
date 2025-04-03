import java.util.ArrayList; // Lista dinâmica
import java.util.List;
import java.util.Objects;    // Usado para equals() e hashCode()
import java.util.Scanner;   // Entrada de dados do usuário

public class Aluno {

    public String nome;
    public int matricula;
    public String email;

    // Construtor que define nome, matrícula e gera o email
    public Aluno(int matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = this.gerarEmail(); // Chama método que monta o email
    }

    // Gera o email no formato: primeiro.último@ufn.edu.br
    public String gerarEmail() {
        String[] vetorNomes = this.nome.toLowerCase().split(" ");
        return vetorNomes[0] + "." + vetorNomes[vetorNomes.length - 1] + "@ufn.edu.br";
    }

    // Compara dois alunos pelo email (único)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(this.email, aluno.email);
    }

    // Gera hash baseado no email
    @Override
    public int hashCode() {
        return Objects.hash(this.email);
    }

    // Representação textual do aluno
    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Email: " + email;
    }

    // Método principal
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>(); // Lista de alunos
        Scanner scanner = new Scanner(System.in);

        Aluno tmp;
        String nome;
        int matricula = 1;
        String opcao;

        // Loop de cadastro
        while (true) {
            System.out.println("Digite o nome do aluno: ");
            nome = scanner.nextLine().toUpperCase(); // Nome em maiúsculas
            tmp = new Aluno(matricula, nome);

            // Verifica se email já existe
            if (alunos.contains(tmp)) {
                System.out.println("Aluno com este email ja cadastrado!");
                System.gc(); // Força coleta de lixo (não é necessário aqui)
            } else {
                alunos.add(tmp); // Adiciona aluno
                System.out.println("Aluno cadastrado com sucesso! Matricula: " + matricula + " Email: " + tmp.email);
                matricula++; // Incrementa matrícula
            }

            System.out.println("CONTINUA ? (s/n)");
            opcao = scanner.nextLine();

            if (!opcao.equals("s"))
                break; // Sai do loop
        }

        // Ordena lista pelo nome
        alunos.sort((aluno1, aluno2) -> aluno1.nome.compareTo(aluno2.nome));

        // Imprime todos os alunos cadastrados
        System.out.println("Relação de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
