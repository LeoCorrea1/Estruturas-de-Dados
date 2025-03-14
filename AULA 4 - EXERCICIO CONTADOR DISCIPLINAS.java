package ExercicioLista;


import java.util.ArrayList;
import java.util.List;


public class DisciplinasCorrigido {
	
	    public static void main(String[] args) {

	        ArrayList<String> EstruturaDeDados = new ArrayList<>();
	        EstruturaDeDados.add("Ceretta");
	        EstruturaDeDados.add("Leonardo");
	        EstruturaDeDados.add("Cleber");
	        EstruturaDeDados.add("Luiza");
	        EstruturaDeDados.sort(null);

	        ArrayList<String> BancoDeDados = new ArrayList<>();
	        BancoDeDados.add("Leonardo");
	        BancoDeDados.add("Luiza");
	        BancoDeDados.add("Miguel");
	        BancoDeDados.sort(null);

	        ArrayList<String> ia = new ArrayList<>();
	        BancoDeDados.add("Joao");

	        ArrayList<ArrayList> CienciaComputacao= new ArrayList<>();
	        CienciaComputacao.add(EstruturaDeDados);
	        CienciaComputacao.add(BancoDeDados);
	        CienciaComputacao.add(ia);

	        System.out.println("Lista Ciencia da computaçao");
	        for(Object disciplina : CienciaComputacao){
	            System.out.println(disciplina);

	        }

	        System.out.println("listando os alunos das disciplinas");
	        ArrayList<ArrayList> nomesAvaliados = new ArrayList<>();
	        String NomeTMP;
	        int i;

	        for(ArrayList disciplina : CienciaComputacao) {
	            for (Object aluno : disciplina) {
	                NomeTMP = aluno.toString();

	                if (!nomesAvaliados.contains(NomeTMP)) {
	                    i = 0;
	                    for (ArrayList d : CienciaComputacao) {
	                        for (Object a : d) {
	                            if(NomeTMP.equals(a.toString())){
	                            	i++;
	                            }

	                        }

	                    }
	                    System.out.println( NomeTMP + ": " + i);

	                }
	            }
	        }
	    }
	}




