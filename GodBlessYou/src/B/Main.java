package B;

public class Main {
    public static void main(String[] args) {
//        ArrayListStack stack1 = new ArrayListStack();
//        stack1.push("Dupa1");
//        stack1.push("Dupa2");
//        stack1.push("Dupa3");
//        stack1.push("Dupa4");
//
//        System.out.println("Podglad najnowszej czarownicy na stosie");
//        System.out.println(stack1.peek());
//        System.out.println("Caly stos");
//        while(!stack1.isEmpty()){
//            System.out.println(stack1.pop());
//        }

//        LinkedListQueue queue1 = new LinkedListQueue();
//        queue1.insert("Jan");
//        queue1.insert("Ian");
//        queue1.insert("Van");
//
//        System.out.println("Pierwszy w kolejce jest: " + queue1.peek());
//
//        System.out.println("Rozmiar kolejki: " + queue1.size());
//        System.out.println("Cala kolejka");
//        while(!queue1.isEmpty()){
//            System.out.println(queue1.remove());
//        }

//        ListaDwustronna lista1 = new ListaDwustronna();
//
//        lista1.insertFirst("U");
//        lista1.insertFirst("D");
//        lista1.insertLast("P");
//        lista1.insertLast("A");
//        System.out.println("Pierwszy i ostatni element to: " + lista1.getFirst() + " " + lista1.getLast());
//        System.out.println("Cala lista");
//        while(!lista1.isEmpty()){
//            System.out.println(lista1.removeFirst());
//        }

        CustomTreeSet TS1 = new CustomTreeSet();
        TS1.insert("D");
        TS1.insert("D");
        TS1.insert("A");
        TS1.insert("B");
        TS1.insert("C");

        CustomTreeSet TS2 = new CustomTreeSet();
        TS2.insert("D");
        TS2.insert("Z");
        TS2.insert("A");
        TS2.insert("H");
        TS2.insert("C");

        System.out.println("Zbior A: ");
        TS1.print();

        System.out.println("Zbior B: ");
        TS2.print();

        System.out.println("Suma");
        TS1.union(TS2).print();

        System.out.println("Iloczyn");
        TS1.insertion(TS2).print();

        System.out.println("A-B");
        TS1.difference(TS2).print();

        System.out.println("B-A");
        TS2.difference(TS1).print();
    }
}
