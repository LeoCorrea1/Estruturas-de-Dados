package LIsta6_POO.Codigos_aula_15_04.cod1.cod3;

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public void exibeDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("leonardo", 19);
        System.out.println("PESSOA");
        p1.exibeDados();
        pessoaJuridica pj = new pessoaJuridica("leonardo" , 19 , "213213212112" , "patrao111","23/11/2005");
        System.out.println("\nPESSOA JURIDICA");
        pj.exibeDados();
        System.out.println("cnpj : " +pj.CNPJ);
        System.out.println("socio : " + pj.socio);
        System.out.println("dtAbertura : " + pj.dtAbertura);
    }
}
