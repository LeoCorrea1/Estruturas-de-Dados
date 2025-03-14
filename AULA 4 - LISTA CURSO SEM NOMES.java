package ExercicioLista;

import java.util.ArrayList;

public class ListaCursoSemNome {
	
    public static void main(String[] args) {
        
    	ArrayList<ArrayList<String>> CienciaComputacao = new ArrayList<>();
    	
        // 0 - ESTRUTURA DE DADOS
        CienciaComputacao.add(new ArrayList<String>());
        
        // 1 - BANCO DE DADOS
        CienciaComputacao.add(new ArrayList<String>());
        
        // 2 - IA
        CienciaComputacao.add(new ArrayList<String>());
        
        CienciaComputacao.get(0).add("Luiza");
        CienciaComputacao.get(0).add("Andrisa");
        CienciaComputacao.get(0).add("Ceretta");
        CienciaComputacao.get(0).sort(null); 
        
        CienciaComputacao.get(1).add("Luiza");
        CienciaComputacao.get(1).add("Miguel");
        CienciaComputacao.get(1).add("Ceretta");
        CienciaComputacao.get(1).sort(null); 
        
        CienciaComputacao.get(2).add("Luiza");
        CienciaComputacao.get(2).add("Joao");
        CienciaComputacao.get(2).add("Leonardo");
        CienciaComputacao.get(2).sort(null); 
        
        System.out.println("Alunos de Estrutura de Dados: " + CienciaComputacao.get(0));
        System.out.println("Alunos de Banco de dados: " + CienciaComputacao.get(1));
        System.out.println("Alunos de IA: " + CienciaComputacao.get(2));
        
        System.out.println("\nlistando os alunos das disciplinas");
        ArrayList<String> nomesAvaliados = new ArrayList<>();
        String NomeTMP;
        int i;

        for (ArrayList disciplina : CienciaComputacao) {
            for (Object aluno : disciplina) {
                NomeTMP = aluno.toString();

                if (!nomesAvaliados.contains(NomeTMP)) {
                    i = 0;
                    for (ArrayList d : CienciaComputacao) {
                        for (Object a : d) {
                            if (NomeTMP.equals(a.toString())) {
                                i++;
                            }
                        }
                    }
                    System.out.println(NomeTMP + ": " + i +" Disciplina(s)");
                    nomesAvaliados.add(NomeTMP);
                }
            }
        
        }
    }
}