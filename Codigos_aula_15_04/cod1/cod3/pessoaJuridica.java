package LIsta6_POO.Codigos_aula_15_04.cod1.cod3;

public class pessoaJuridica extends Pessoa{

    protected String CNPJ;
    protected String socio;
    protected String dtAbertura;

    public pessoaJuridica(String nome , int idade, String CNPJ , String socio , String dtAbertura){
        super(nome,idade);
        this.CNPJ = CNPJ;
        this.socio = socio;
        this.dtAbertura = dtAbertura;
    }

}
