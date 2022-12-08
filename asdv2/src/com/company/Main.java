package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        dupa6();
    }

    public static int dupa(int n){
        if(n == 1 || n == 2) return 1;
        else return 3*(dupa(n-1) * dupa(n-2));
    }

    public static void dupa1(){
        Random rand = new Random();
        int pointsInFigure = 0;
        for(int i = 0; i < 100; i++){
            double x = rand.nextInt(0,1001)/1000.0;
            double y = rand.nextInt(0,1001)/1000.0;

            if(y <= x*x){
                pointsInFigure++;
            }
        }
        double area = pointsInFigure/100.0;
        System.out.println(area);
    }

    public static int dupa2(int n){
        //bo w zadaniu jest że indeksy mają być od 1
        int[] duupa = new int[n+1];
        duupa[0]=2137;
        duupa[1] = 1;
        duupa[2] = 1;

        for(int i = 3; i < n+1; i++){
            if(i > 2 && i%3==0){
                duupa[i] = 2*duupa[i-1];
            }else if(i > 2 && i%3==1){
                duupa[i] = (int) Math.pow(duupa[i-2],2);
            }else if(i > 2 && i%3==2){
                duupa[i] = (int) Math.pow(2,duupa[i-3]);
            }
        }
        //Pomocnicza pętla do sprawdzenia kolejnych wyrazow ciągu
        for(int i = 0; i < n+1; i++){
            System.out.println(duupa[i]);
        }

        return duupa[n];
    }

    public static void dupa3(){
        Scanner in  = new Scanner(System.in);

        //w groszach
        int nominaly[] = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int dostepnosci[] = {7,  0,   1,  1,  4,  1, 4, 7, 30};
        int uzyte_monety[] = new int[9];
        int zl, gr, reszta_w_gr;

        System.out.println("Podaj zł");
        zl = in.nextInt();

        System.out.println("Podaj gr");
        gr = in.nextInt();

        reszta_w_gr = zl*100 + gr;

        for(int i = 0; i < nominaly.length; i++){

            int ile_razy_sie_zmiesci_sie = reszta_w_gr/nominaly[i];
            if(ile_razy_sie_zmiesci_sie > dostepnosci[i]) ile_razy_sie_zmiesci_sie = dostepnosci[i];
            uzyte_monety[i] = ile_razy_sie_zmiesci_sie;

            reszta_w_gr -= nominaly[i]*ile_razy_sie_zmiesci_sie;
        }
        if(reszta_w_gr != 0){
            System.out.println("Cymbale nie da rady wydać reszty, zostało: " + reszta_w_gr/100.0);
        }else{
            System.out.println("Twoja reszta kutasie złamasie");
            for(int i = 0; i < nominaly.length; i++){
                System.out.println(nominaly[i]/100.0 + ": " + uzyte_monety[i] + " razy");
            }
        }
    }
    public static double dupa4(double samice, double samce, int tydzien){
        System.out.println("tydzien: " + tydzien);
        System.out.println("samice: " + samice + " samce: " + samce);
        System.out.println();
        if(samce>=samice){
            System.out.println("tydzień: " + tydzien);
            System.out.println("samic: " + samice);
            System.out.println("samców: " + samce);
            System.out.println("razem: " + (samce+samice));
            return samce;
        }else{
            double ilosc_samic_po_tyg = samice - samice*0.05;
            double ilosc_samcow_po_tyg = samce - samce*0.02;

            double ile_nowych = (ilosc_samic_po_tyg+ilosc_samcow_po_tyg)*0.1;
            double nowe_samice = ile_nowych*0.55;
            double nowe_samce = ile_nowych-nowe_samice;

            return dupa4(nowe_samice + ilosc_samic_po_tyg, nowe_samce + ilosc_samcow_po_tyg, tydzien+1);
        }
    }
    public static int dupa5(int n){
        if(n == 1) return 2;
        if(n == 2) return 4;
        return (dupa5(n-1)*dupa5(n-2))/2;
    }

    public static void dupa6(){
        int populacja = 100000;
        double chorzy[] = new double[populacja];
        chorzy[0] = 10;
        for(int i = 1; i < chorzy.length; i++){
            chorzy[i]=chorzy[i-1]+chorzy[i-1]*2;
            if(i>6){
                chorzy[i]-=chorzy[i-6];
            }

            if(chorzy[i] > populacja/2){
                System.out.println((i+1) + " dnia liczba chorych przekroczyła połowe społeczństwa i wynosi: " + chorzy[i]);
                break;
            }
        }
//        for(int i = 0; i < 100; i++){
//            System.out.println(chorzy[i]);
//        }
    }
}
