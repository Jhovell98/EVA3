/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author invitado
 */
import java.util.Comparator;
import java.util.LinkedList;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> Lista = new LinkedList<Integer>();

        for (int i = 0; i < 15; i++) {
            Lista.add(i, (int) (Math.random() * 20));
        }
        System.out.println("Lista normal ");
        System.out.println(Lista);
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int resu;
                //Cero es igual
                //Positivo es mayor
                //Negativo es menor
                Integer val1, val2;
                val1 = (Integer) o1;
                val2 = (Integer) o2;
                resu = val1 - val2;
                return resu;
            }
        };
        Lista.sort(c);
        System.out.println("Lista de menor a mayor");
        System.out.println(Lista);
        LinkedList<String> listaStr = new LinkedList<String>();
        listaStr.add("HOLA");
        listaStr.add(" ");
        listaStr.add("MUNDO");
        listaStr.add(" ");
        listaStr.add("CRUEL");
        listaStr.add("!!");

        Comparator cmpStr = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String) o1;
                String cade2 = (String) o2;
                char c1 = cade1.charAt(0);
                char c2 = cade2.charAt(0);
                return c1 - c2;
            }

        };
        System.out.println(listaStr);
        listaStr.sort(cmpStr);
        System.out.println(listaStr);
    }

}
