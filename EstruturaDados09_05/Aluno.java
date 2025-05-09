package Estudo.EstruturaDados09_05;

class Aluno {
    int matricula;
    String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome='" + nome + "'}";
    }
}
