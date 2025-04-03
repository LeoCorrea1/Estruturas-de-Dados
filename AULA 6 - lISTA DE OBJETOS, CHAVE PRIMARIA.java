import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List.
import java.util.Objects; // Importa a classe Objects para utilidades como equals e hashCode.
import java.util.Scanner; // Importa a classe Scanner para entrada de dados do usuário.

public class Aluno {

    public String nome; // Declara uma variável para armazenar o nome do aluno.
    public int matricula; // Declara uma variável para armazenar a matrícula do aluno.
    public String email; // Declara uma variável para armazenar o email do aluno.

    public Aluno(int matricula, String nome) {
        this.nome = nome; // Inicializa o nome do aluno com o valor fornecido.
        this.matricula = matricula; // Inicializa a matrícula do aluno com o valor fornecido.
        this.email = this.gerarEmail(); // Gera e atribui o email do aluno.
    }

    public String gerarEmail() {
        String[] vetorNomes = this.nome.toLowerCase().split(" "); // Converte o nome para minúsculo e divide em partes pelo espaço.
        return vetorNomes[0] + "." + vetorNomes[vetorNomes.length - 1] + "@ufn.edu.br"; // Retorna o email gerado (primeiro nome.último sobrenome@ufn.edu.br).
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false; // Verifica se o objeto é nulo ou de classe diferente.
        Aluno aluno = (Aluno) o; // Faz um cast do objeto para a classe Aluno.
        return Objects.equals(this.email, aluno.email); // Compara se os emails dos dois objetos são iguais.
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email); // Gera um código hash baseado no email do aluno.
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Email: " + email; // Retorna uma representação em string do objeto Aluno.
    }

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>(); // Cria uma lista para armazenar objetos da classe Aluno.
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário.

        Aluno tmp; // Declara uma variável temporária para armazenar um objeto Aluno.
        String nome; // Declara uma variável para armazenar o nome do aluno digitado.
        int matricula = 1; // Inicializa a matrícula com o valor 1.
        String opcao; // Declara uma variável para armazenar a opção do usuário (continuar ou não).

        while (true) { // Loop infinito para cadastrar alunos até que o usuário decida parar.

            System.out.println("Digite o nome do aluno: "); // Solicita o nome do aluno.
            nome = scanner.nextLine().toUpperCase(); // Lê o nome do aluno e converte para maiúsculo.
            tmp = new Aluno(matricula, nome); // Cria um novo objeto Aluno com a matrícula e o nome fornecidos.

            if (alunos.contains(tmp)) { // Verifica se a lista de alunos já contém um aluno com o mesmo email.
                System.out.println("Aluno com este email ja cadastrado!"); // Informa que o aluno já está cadastrado.
                System.gc(); // Sugere ao garbage collector que execute a coleta de lixo (não garante a execução imediata).
            } else { // Se o aluno não estiver cadastrado.
                alunos.add(tmp); // Adiciona o novo aluno à lista.
                System.out.println("Aluno cadastrado com sucesso! Matricula: " + matricula + " Email: " + tmp.email); // Informa que o aluno foi cadastrado com sucesso.
                matricula++; // Incrementa o contador de matrícula para o próximo aluno.
            }

            System.out.println("CONTINUA ? (s/n)"); // Pergunta ao usuário se deseja continuar cadastrando alunos.
            opcao = scanner.nextLine(); // Lê a resposta do usuário.

            if (!opcao.equals("s")) // Verifica se a opção digitada não é "s".
                break; // Sai do loop while se a opção não for "s".
        }

        alunos.sort((aluno1, aluno2) -> aluno1.nome.compareTo(aluno2.nome)); // Ordena a lista de alunos alfabeticamente pelo nome.

        System.out.println("Relação de alunos:"); // Informa que a relação de alunos será exibida.
        for (Aluno aluno : alunos) { // Loop para iterar sobre a lista de alunos.
            System.out.println(aluno); // Imprime as informações de cada aluno (toString() será chamado implicitamente).
        }
    }
}
