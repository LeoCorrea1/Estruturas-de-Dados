//codigo de exemplo :


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno{
    int matricula;
    String nome;

    public Aluno(int matricula , String nome){
       this.matricula = matricula;
       this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno [matricula = " + matricula + ", nome = " + nome + "]";
    }
    
    
}
    public class ListaObjeto {
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            List<Aluno> alunos = new ArrayList<>();
            int matricula;
            String nome;
            Aluno tmp;

            for(int i = 0; i < 3 ; i++){
                System.out.print("MATRICULA :");
                matricula = teclado.nextInt();
                teclado.nextLine();

                System.out.print("NOME :");
                nome = teclado.nextLine();
                //tmp = new Aluno(matricula,nome);
                alunos.add(new Aluno(matricula,nome));
            }
            for(Aluno aluno : alunos){
                System.out.println(aluno);


            }
        }

}

//CODIGO EXEMPLO GERAÇAO DE EMAIL : 

import java.util.Scanner;

public class Nomes {

    public static void main(String[] args) {
        String nomeCompleto;
        Scanner teclado = new Scanner(System.in);

        String vetorNome[];

        do{
        System.out.println("NOME COMPLETO : ");
        nomeCompleto = teclado.nextLine().toUpperCase();
        vetorNome = nomeCompleto.split(" ");
        }while(vetorNome.length < 2);

        vetorNome = nomeCompleto.split(" ");
        for( int i = 0 ; i < vetorNome.length; i ++){
            System.out.println(vetorNome[i]);
        }

        //para mostrar apenas o nome ou o sobrenome
        //System.out.println(vetorNome[vetorNome.length - 1]);
    
        String email = vetorNome[0] + "." + vetorNome [ vetorNome.length -1 ] + "@ufn.edu.br";
        email = email.toLowerCase();
        System.out.println(email);
    }
}
    

