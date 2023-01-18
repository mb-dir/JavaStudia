package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    final static int[] v = {6,2,3,2,3,1};//obj
    static final int[] w = {6,4,5,7,10,2};//wartosci przedmiotów
    static int MAX_V = 10;
    static int [] tablica = {1,5,4,3,1,6,8,41,4,6,8,4,1,5};

    public static void main(String[] args) {
        System.out.println("Przed posorotwaniem");
        for (int el: tablica) {
            System.out.print(el + " ");
        }
        System.out.println();
        mergeSort(0, tablica.length-1);
        System.out.println("Po posorotwaniu");
        for (int el: tablica) {
            System.out.print(el + " ");
        }
    }

    public static void merge(int l, int m, int r){
        int [] tempArray = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k = 0;

        //lecimy po dwóch podproblemach na raz
        while((i <= m) || (j<=r)){
            //gdy pierwszy podproblem jest już wyczerpany
            if(i == m+1){
                tempArray[k] = tablica[j];
                k++;
                j++;
            }else if(j == r+1){//jeżeli prawy podproblem osiągnął swój kres
                tempArray[k] = tablica[i];
                k++;
                i++;
            }else{//scalanie dwóch podproblemów(żaden z podproblemów sie nie wyczerpał jeszcze)
                if(tablica[i] <= tablica[j]){//jeżeli element z lewego podproblemu jest mniejszy
                    tempArray[k] = tablica[i];
                    i++;
                    k++;
                }else{
                    tempArray[k] = tablica[j];
                    j++;
                    k++;
                }
            }
        }

        //aktualizacja orginalnej tablicy
        int d = l;
        for(int q = 0; q < tempArray.length; q++){
            tablica[d] = tempArray[q];
            d++;
        }

    }

    public static void mergeSort(int l, int r){
        int m = (l+r)/2;
        if(l < r){//dopóki jest więcej niż jeden element
            mergeSort(l, m);//wywołanie dla lewego podproblemu
            mergeSort(m+1, r);//wywołanie dla prawego podproblemu
            merge(l, m, r);
        }

    }

    //plecak rekurencja
    public static int dupa10(int i, int V){
        if(i == 0 && v[i] > V) return 0;
        if(i == 0 && v[i]<=V) return w[i];
        if(i !=0 && v[i]>V) return dupa10(i-1, V);
        return Math.max(dupa10(i-1, V), w[i] + dupa10(i-1, V-v[i]));
    }

    //plecak dynamiczne
    public static void dupa11(){
        int[] v = {6,2,3,2,3,1};//obj
        int[] w = {6,4,5,7,10,2};//wartosci przedmiotów
        int MAX_V = 10;

        int[][] rozw = new int[w.length][MAX_V+1];
        for(int i = 0; i < w.length; i++){
            for(int j = 0; j < MAX_V+1; j++){
                if(i==0 && v[i] > j) rozw[i][j] = 0;
                if(i==0 && v[i] <= j) rozw[i][j] = w[i];
                if(i!=0 && v[i] > j) rozw[i][j] = rozw[i-1][j];
                if(i!=0 && v[i] <= j) rozw[i][j] = Math.max(rozw[i-1][j], w[i] + rozw[i-1][j-v[i]]);
            }
        }

        for(int i = 0; i < w.length; i++){
            for(int j = 0; j < MAX_V+1; j++){
                System.out.print(rozw[i][j] + " ");
            }
            System.out.println();
        }
    }

    //lody montecarlo
    public static void dupa8(){
        Random rand = new Random();
        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int proby = 100;
        int najlepsza_wartosc = 213321;
        int[] najlepsza_sekwencja = new int[koszty.length+1];

        for(int i = 0; i < proby; i++){
            int sekwencja_dla_proby[] = new int[koszty.length+1];
            int smaki_co_byly[] = new int[koszty.length];
            int ile_smakow = 0;
            while(ile_smakow < koszty.length){
                int losowy_smak = rand.nextInt(koszty.length);
                if(smaki_co_byly[losowy_smak]==0){
                    smaki_co_byly[losowy_smak] = 1;
                    sekwencja_dla_proby[ile_smakow] = losowy_smak;
                    ile_smakow++;
                }
            }

            //przestrojenie
            sekwencja_dla_proby[koszty.length] = sekwencja_dla_proby[0];

            //zliczanie wartości dla sekwencji
            int wartosc_dla_sekwencji = 0;
            for(int d = 0; d < sekwencja_dla_proby.length-1; d++){
                wartosc_dla_sekwencji+=koszty[sekwencja_dla_proby[d]][sekwencja_dla_proby[d+1]];
            }
            if(wartosc_dla_sekwencji < najlepsza_wartosc){
                najlepsza_wartosc=wartosc_dla_sekwencji;
                najlepsza_sekwencja=sekwencja_dla_proby;
            }
        }

        System.out.println("Najmniejsza wartość: " + najlepsza_wartosc);
        System.out.println("Dla sekwencji: ");
        for(int i = 0; i < najlepsza_sekwencja.length; i++){
            System.out.print((najlepsza_sekwencja[i]+1) + " ");
        }
    }

    //lody zachłannie
    public static void dupa12(){
        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };

        int pierwszy_smak_wiersz = 0;
        int min_pierwszy_smak = 123123;
        int czas = 0;
        int[]czy_smak_byl = new int[koszty.length];

        for(int i = 0; i < koszty.length; i++){
            for(int j = 0; j<koszty[0].length; j++){
                if(koszty[i][j] > 0 && koszty[i][j] < min_pierwszy_smak){
                    pierwszy_smak_wiersz = i;
                    min_pierwszy_smak = koszty[i][j];
                }
            }
        }
        czy_smak_byl[pierwszy_smak_wiersz] = 1;
        System.out.println((pierwszy_smak_wiersz+1));

        //kolejne smaki
        int wiersz = pierwszy_smak_wiersz;
        int index_min = -1;
        for(int i = 0; i < koszty.length-1; i++){
            int min = 2321313;
            for(int j = 0; j<koszty[0].length; j++){
                if(koszty[wiersz][j] > 0 && koszty[wiersz][j] < min && czy_smak_byl[j] == 0){
                   min = koszty[wiersz][j];
                   index_min = j;
                }
            }
            czas+=min;
            wiersz=index_min;
            System.out.println("min: + " + min + " czas: " + czas);
            czy_smak_byl[wiersz] = 1;

        }
        //przestrojenie
        System.out.println(pierwszy_smak_wiersz+1);
        czas+=koszty[wiersz][pierwszy_smak_wiersz];
        System.out.println("min: + " + koszty[wiersz][pierwszy_smak_wiersz] + " czas: " + czas);
    }

    //plecak zachlannie(najbardziej wartosciowe)
    public static void dupa13(){
        final int[] v = {1,2,3,2,3,1};  // objetosci przedmiotow
        final int[] w = {6,4,5,7,10,2};
        int MAX_V = 10;

        int[] czy_byl = new int[v.length];
        int sumaV = 0;
        int sumaW = 0;

        while(true){
            int max_wartosc = 0;
            int max_poz=-1;
            for(int i = 0; i < v.length; i++){
                if(czy_byl[i]==0 && w[i]>max_wartosc && sumaV+v[i]<=MAX_V){
                    max_wartosc=w[i];
                    max_poz=i;
                }
            }
            if(max_poz!=-1){
                czy_byl[max_poz]=1;
                sumaW+=max_wartosc;
                sumaV+=v[max_poz];
            }else{
                break;
            }
        }
        System.out.println(sumaW);
        System.out.println("Rozwiązanie(przedmioty po wartosciach): ");//1 bierzemy, 0 nie
        for (int i = 0; i < czy_byl.length; i++) {
            System.out.println("Przedmiot " + i + " - " + czy_byl[i]);
        }
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

    public static void dupa9(){
        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int czas=0;
        int tempczas=0;
        int start;
        boolean[] bylo= new boolean[koszty.length];
        for(int i =0;i<bylo.length;i++){
            bylo[i]=false;
        }
        int wiersz=0;
        int min = Integer.MAX_VALUE;

        //Sprawdzamy pierwszy smak
        for (int i=0;i<koszty.length;i++) {
            for (int j=0;j<koszty.length;j++) {
                if ( koszty[i][j]>0 && koszty[i][j]<min) {
                    wiersz=i;
                    min=koszty[i][j];
                }
            }
        }
        start=wiersz;
        System.out.println("Smaki:");
        System.out.println(wiersz+1);
        bylo[wiersz]=true;
        int minIndex =-1;

        //Sprawdzamy na jakie smaki kolejno przerobić
        for(int i=0;i< koszty.length-1;i++){
            min=Integer.MAX_VALUE;
            for(int j=0;j< koszty[0].length;j++){
                if(koszty[wiersz][j]<min &&koszty[wiersz][j]>0 && bylo[j]==false){
                    min=koszty[wiersz][j];
                    minIndex=j;
                    tempczas=koszty[wiersz][j];
                }
            }
            wiersz=minIndex;
            bylo[minIndex]=true;
            czas+=tempczas;
            System.out.println(wiersz+1);
        }

        //Przestrajamy na następny dzień
        czas+=koszty[wiersz][start];
        System.out.println(start+1);
        System.out.println("CZAS: "+czas);
    }
}
