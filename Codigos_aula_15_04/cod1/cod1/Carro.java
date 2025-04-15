package LIsta6_POO.Codigos_aula_15_04.cod1.cod1;

public class Carro {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibirMsg(){
        System.out.println("Estou na classe carro\nO nome do carro é : " + this.nome);
    }

    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.setNome("Carro1");
        carro.nome = "Carro2";
        carro.exibirMsg();

        Onibus onibus = new Onibus();
        onibus.setNome("Onibus");
        onibus.setModelo("OF-33455");
        onibus.exibirMsg();

        System.out.println("o nome do carro " + onibus.getNome());
        System.out.println("o modelo do onibus " + onibus.getModelo());
    }
}
