package A;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        TablicaDynamicznaPosortowana ldp = new TablicaDynamicznaPosortowana(2);
//
//        ldp.add("a");
//        ldp.add("z");
//        ldp.add("g");
//        ldp.add("c");
//
//        ldp.print();
//
//        System.out.println("Index z: " + ldp.find("z"));
//
//        ldp.remove(0);
//        ldp.print();

        Lista lista = new Lista();
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.insert(3);
        lista.insert(1);

        lista.delete(3);
        lista.delete(3);
        lista.delete(1);
        lista.print();

        System.out.println(lista.find(87));
    }
}
