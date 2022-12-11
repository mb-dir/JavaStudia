package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        dupa9();
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
        double chorzy[] = new double[2136];
        double ozdrowieni[] = new double[2136];
        double nowi_chorzy[] = new double[2136];
        chorzy[0] = 10;
        nowi_chorzy[0] = 10;
        for(int i = 1; i < chorzy.length; i++){
            if(i > 6) {
                ozdrowieni[i] = chorzy[i - 7];
            }
            nowi_chorzy[i] = populacja-chorzy[i-1];
            if(!(nowi_chorzy[i]>= populacja)){
                nowi_chorzy[i] = (chorzy[i-1] - ozdrowieni[i])*2;
            }
            chorzy[i] = nowi_chorzy[i] + chorzy[i-1] - ozdrowieni[i];
        }

        for(int i = 0; i < 25; i++){
            if(chorzy[i] <= 0){
                break;
            }
            System.out.println("Dzień:" + (i+1));
            System.out.println("Chorzy: " + chorzy[i] + " Nowi chorzy w danym dniu: " + nowi_chorzy[i] + " Ozdrowieni danego dnia: " + ozdrowieni[i]);
        }
    }

    public static void dupa7(){
        Random rand = new Random();
        int[] nominaly = {500,200,100,50,20,10,5,2,1};//nominaly w groszach
        int limit_wydanych_monet = 37;
        int ile_losowan=5;
        int min_liczba_wydanych_monet = limit_wydanych_monet;

        int[] wydane_monety_w_danej_iteracji = new int[limit_wydanych_monet];
        int[] min_wydane_monety = new int[limit_wydanych_monet];


        for(int i = 0; i < ile_losowan; i++){
            int liczba_wydanych_monet = 0;
            int reszta = 527;//5zł 27gr
            while(reszta > 0 && liczba_wydanych_monet < limit_wydanych_monet){
                int moneta = nominaly[rand.nextInt(nominaly.length)];

                if(reszta>=moneta){
                    wydane_monety_w_danej_iteracji[liczba_wydanych_monet]=moneta;
                    reszta-=moneta;
                    liczba_wydanych_monet++;
                }
            }
            if(liczba_wydanych_monet < min_liczba_wydanych_monet){
                min_liczba_wydanych_monet = liczba_wydanych_monet;
                for(int j = 0; j < liczba_wydanych_monet; j++){
                    min_wydane_monety[j]=wydane_monety_w_danej_iteracji[j];
                }
            }
        }

        if(min_liczba_wydanych_monet < limit_wydanych_monet){
            System.out.println("Rozwiązanie");
            for (int i = 0; i < min_liczba_wydanych_monet; i++) {
                System.out.print(min_wydane_monety[i]/100.0 + " ");
            }
        }else{
            System.out.println("Nie ma rozwiązania");
        }
    }

    public static void dupa8(){
        Random rand = new Random();
        final int[][] costs = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int number_of_flavours = costs.length;
        int best_sequence[] = new int[number_of_flavours+1];
        int best_value = 11111111;
        final int attemps = 10000;

        for (int i = 0; i < attemps; i++) {
            int already_selected_flavours = 0;
            int sequence_for_current_attemp[] = new int[number_of_flavours+1];
            int which_was_selected[] = new int[number_of_flavours];

            while(already_selected_flavours < number_of_flavours){
                int random_flavour = rand.nextInt(number_of_flavours);
                if(which_was_selected[random_flavour] == 1) continue;
                which_was_selected[random_flavour] = 1;
                sequence_for_current_attemp[already_selected_flavours]=random_flavour;
                already_selected_flavours++;
            }
            sequence_for_current_attemp[6]=sequence_for_current_attemp[0];

            int curr_value = 0;

            for(int d = 0; d < sequence_for_current_attemp.length-1; d++){
                curr_value+=costs[sequence_for_current_attemp[d]][sequence_for_current_attemp[d+1]];
            }

            if (curr_value < best_value){
                best_sequence = sequence_for_current_attemp;
                best_value=curr_value;
            }
        }
        System.out.println("The best sequence(value: " + best_value +"):");

        for (int i = 0; i < best_sequence.length; i++) {
            System.out.print(best_sequence[i]+1 + " ");
        }
    }

    public static void dupa9(){
        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int[] smaki_ktore_byly = new int[koszty.length];
        int min = 1111111;
        int start_min = 0;
        int wiersz=-1;
        int koszt = 0;
        int start = 0;

        //znajdz smak od którego zaczynamy
        for(int i = 0; i < koszty.length; i++){
            for(int j = 0; j < koszty[0].length; j++){
                if(koszty[i][j] !=0 && koszty[i][j] < min){
                    min = koszty[i][j];
                    wiersz = i;
                    start = i;
                    start_min = min;
                }
            }
        }
        koszt+=min;
        smaki_ktore_byly[wiersz] = 1;

        System.out.print("Kolejne smaki: " + (wiersz+1) + " ");

        //kolejne smaki
        int index_min=-1;
        for (int i = 0; i < koszty.length-1; i++) {
            int min_koszt_zmiany = 11111;
            for(int j = 0; j < koszty[0].length; j++){
                if(koszty[wiersz][j] != 0 && koszty[wiersz][j] < min_koszt_zmiany && smaki_ktore_byly[j] != 1){
                    min_koszt_zmiany = koszty[wiersz][j];
                    index_min = j;
                }
            }
            koszt+= koszty[wiersz][index_min];
            wiersz = index_min;
            smaki_ktore_byly[wiersz] = 1;
            System.out.print(wiersz+1 + " ");
        }
        System.out.print(start+1);
        koszt+=koszty[wiersz][start];
        System.out.println(" Koszt wynosi: " + koszt);
    }
}
