package LIsta6_POO.Codigos_aula_15_04.cod1.cod2;

public class Animal {
    protected String nome;
    protected int idade;
    protected String som;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public static void main(String[] args) {

        Animal a = new Animal();
        System.out.println("ANIMAL");
        a.setNome("catorrita");
        a.setIdade(10);
        a.setSom("Som de catorritas");
        System.out.println("nome : "+a.getNome());
        System.out.println("idade : " +a.getIdade());
        System.out.println("som : " +a.getSom());

        Cachorro c = new Cachorro();
        c.setNome("cachorrinho");
        c.setIdade(2);
        c.setSom("Som de latidos");
        c.setRaca("pastor alemao");
        System.out.println("\nCACHORRO");
        System.out.println("nome : "+c.getNome());
        System.out.println("idade : " +c.getIdade());
        System.out.println("som : " +c.getSom());
        System.out.println("raça : " +c.getRaca());

    }
}
