package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int [] tablica = {1,5,4,3,1,6,8,41,4,6,8,4,1,5};

    public static void main(String[] args) {
        System.out.println("Przed posortowaniem");
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }

        mergeSort(0, tablica.length-1);
        System.out.println();
        System.out.println("Po posortowaniu");
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }

//        CustomArrayListStack myStack=new CustomArrayListStack();
//        CustomLLStack myStack1 = new CustomLLStack();
//        CustomALQueue myQueue = new CustomALQueue();
//        CustomLLQueue myQueue1 = new CustomLLQueue();
//
//        myQueue1.insert(new String("d"));
//        myQueue1.insert(new String("u"));
//        myQueue1.insert(new String("p"));
//        myQueue1.insert(new String("a"));
//        myQueue1.insert(new String("1"));
//
//        System.out.println("Rozmiar listy: " + myQueue1.size());
//
//        System.out.println("elementem pierwszym elementem kolejki jest: " + myQueue1.peek());
//
//        while (!myQueue1.isEmpty()){
//            System.out.print(myQueue1.remove() + " ");
//        }
//
//
//        ListaDwustronna ld = new ListaDwustronna();
//
//        ld.insertFirst(new String("Kupsk2"));
//        ld.insertFirst(new String("Kupsko1"));
//        ld.insertLast(new String("Kupsko3"));
//
//        ld.print();

//        CustomTreeSet set1 = new CustomTreeSet();
//        set1.insert(new String("Dupa"));
//        set1.insert(new String("Dupa"));
//        set1.insert(new String("Dupa1"));
//
//        System.out.println();
//        System.out.println("Zbiór A");
//        set1.print();
//
//        CustomTreeSet set2 = new CustomTreeSet();
//        set2.insert(new String("Dupa"));
//        set2.insert(new String("Dupa22131"));
//        set2.insert(new String("Dup3123a1"));
//
//        System.out.println();
//        System.out.println("Zbiór B");
//        set2.print();
//
//        System.out.println();
//        System.out.println("Suma");
//
//        set1.union(set2).print();
//
//
//        System.out.println();
//        System.out.println("Iloczyn");
//        CustomTreeSet t1 = set1.insertion(set2);
//        t1.print();
//
//        System.out.println();
//        System.out.println("A-B");
//        set1.difference(set2).print();
//
//        System.out.println();
//        System.out.println("B-A");
//        set2.difference(set1).print();

    }

    public static void merge(int l, int m, int r){
        int [] tempArray = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k = 0;

        while((i<=m) || (j <= r)){
            if(i == m+1){
                tempArray[k]=tablica[j];
                j++;
                k++;
            }else if(j==r+1){
                tempArray[k]=tablica[i];
                i++;
                k++;
            }else{
                if(tablica[i] < tablica[j]){
                    tempArray[k] = tablica[i];
                    i++;
                }else{
                    tempArray[k] = tablica[j];
                    j++;
                }
                k++;
            }
        }

        int d = l;
        for (int n = 0; n < tempArray.length; n++) {
            tablica[d] = tempArray[n];
            d++;
        }
    }

    public static void mergeSort(int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(l,m);
            mergeSort(m+1, r);
            merge(l,m,r);
        }
    }

}
