package strukturaA;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DynTabPos dupa = new DynTabPos(2);

        dupa.add("a");
        dupa.add("z");
        dupa.add("c");
        dupa.add("q");
        dupa.add("w");
        dupa.add("a");
        dupa.add("d");

        dupa.print();
        System.out.println();
        dupa.remove(3);
        dupa.print();

        // Tworzymy listę
//        LLSorted theSortedList = new LLSorted();
//
//        Random rand = new Random();
//        for (int j = 0; j < 10; j++)  // wypełniamy ją elementami losowymi
//        {
//            int number = rand.nextInt(100);
//            theSortedList.insert(number);
//        }
//        theSortedList.insert(12);
//
//        //Wypisujemy liste
//        theSortedList.print();
//        System.out.println();
//        theSortedList.delete(12);
//        theSortedList.print();

    }
}
