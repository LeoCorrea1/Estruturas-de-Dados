import java.util.HashMap;
import java.util.Map;

public class DoisDicionariosComHashMap {

    public static void main(String[] args) {
        // Criação do primeiro HashMap para armazenar nomes e idades
        Map<String, Integer> dicionario1 = new HashMap<>();
        
        // Criação do segundo HashMap para armazenar nomes e idades
        Map<String, Integer> dicionario2 = new HashMap<>();

        // Adicionando nomes e idades ao primeiro dicionário (dicionario1)
        dicionario1.put("João", 25);
        dicionario1.put("Maria", 30);
        dicionario1.put("Pedro", 22);

        // Adicionando nomes e idades ao segundo dicionário (dicionario2)
        dicionario2.put("Ana", 28);
        dicionario2.put("Lucas", 35);
        dicionario2.put("Fernanda", 26);

        // Imprimindo o conteúdo do primeiro dicionário (dicionario1)
        System.out.println("Conteúdo do Dicionário 1:");
        for (Map.Entry<String, Integer> entry : dicionario1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " anos");
        }

        // Imprimindo o conteúdo do segundo dicionário (dicionario2)
        System.out.println("\nConteúdo do Dicionário 2:");
        for (Map.Entry<String, Integer> entry : dicionario2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " anos");
        }

        // Buscando e imprimindo a idade de uma pessoa em ambos os dicionários
        System.out.println("\nIdade de João (Dicionário 1): " + dicionario1.get("João"));
        System.out.println("Idade de Ana (Dicionário 2): " + dicionario2.get("Ana"));
        
        // Verificando se uma pessoa está no primeiro ou no segundo dicionário
        if (dicionario1.containsKey("Maria")) {
            System.out.println("\nMaria está no Dicionário 1.");
        }

        if (dicionario2.containsKey("Lucas")) {
            System.out.println("Lucas está no Dicionário 2.");
        }
    }
}
