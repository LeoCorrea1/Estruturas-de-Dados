import java.util.ArrayList;

public class ListaLista {


    public static void main(String[] args) {

        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        ArrayList<Integer> lista3= new ArrayList<>();
        ArrayList<ArrayList> listaPrincipal = new ArrayList<>();

        System.out.println("Lista 1: ");
        lista1.add(126);
        lista1.add(14);
        lista1.add(526);
        lista1.add(1);
        listaPrincipal.add(lista1);

        System.out.println("Lista 2: ");
        lista2.add(189);
        lista2.add(226);
        lista2.add(29);
        listaPrincipal.add(lista2);

        System.out.println("Lista 3: ");
        lista3.add(199);
        lista3.add(19);
        listaPrincipal.add(lista2);

        for(ArrayList<Integer> lista : listaPrincipal){
            System.out.println(lista);
        }
        System.out.println("exibindo somente a primeira posiçao");
        System.out.println(listaPrincipal.get(0));

        System.out.println("exibindo item a item da lista principal da primeira lista");
        for(Object i : listaPrincipal.get(0)){
            System.out.println(i);
        }








    }
}
