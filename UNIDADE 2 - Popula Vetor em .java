import java.util.ArrayList;
import java.util.Random;

public class ListaRecursiva {
    static Random gerador = new Random();
    static int numero;

    public static void popularR(ArrayList<Integer> lista, int tamanho) {
        if (tamanho > 0) {
            numero = gerador.nextInt(20);
            if (!lista.contains(numero)){
                lista.add( numero );
            }
            popularR(lista, tamanho - 1);
        }
    }

    public static void exibir(ArrayList<Integer> lista) {
        for (Integer numero : lista) {
            System.out.print(numero + "\t");
        }    
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        popularR(lista, 10);
        exibir(lista);
    }
}
