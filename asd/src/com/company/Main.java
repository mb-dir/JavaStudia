package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //ZADANIE Z FIGURĄ - nextInt(0,1001)/1000 - dostaniemy liczbe z zakresu <0,1>
    static Scanner in = new Scanner(System.in);

    //Data for knapstack problem
    final static int[] V = {6,2,3,2,3,1};//obj przedmiotów
    final static int[] profits = {6,4,5,7,10,2};//wartosci przedmiotów
    static int MAX_V = 10;

    public static void main(String[] args) throws IOException {
        poleFigury();
    }
    //Fibonaci rekurencja
    public static int fib(int n){
        if(n == 1 || n ==2) return 1;
        return fib(n-1) + fib(n-2);
    }

    //Fibonaci dynamicznie
    public static int fibDynamically(int n){
        if(n == 1 || n ==2) return 1;
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=1;
        for(int i = 2; i < n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    //Plecak rekurencja
    public static int P(int i, int v){
        if (i == 0 && v < V[i]) return 0;
        if (i == 0 && v >= V[i]) return profits[i];
        if (i != 0 && V[i]>v) return P(i-1, v);
        return Math.max(P(i-1, v), profits[i] + P(i-1, v-V[i]));
    }

    //Plecak dynamicznie
    public static void PDynalically(){
        int profits[] = {6,4,5,7,10,2};//wartosci przedmiotów
        int V[] = {6,2,3,2,3,1};//obj przedmiotów
        int MAX_V = 10;

        int arr[][] = new int[profits.length + 1][MAX_V+1];

        for(int i = 0; i < profits.length+1; i++){
            arr[i][0] = 0;
        }
        for(int i = 0; i < MAX_V+1; i++){
            arr[0][i] = 0;
        }

        for(int i = 1; i <= profits.length; i++){
            for(int j = 1; j <= MAX_V; j++){
                if(j-V[i-1]<0){
                    arr[i][j] = arr[i-1][j];
                }else{
                    arr[i][j]=Math.max(arr[i-1][j], arr[i-1][j-V[i-1]]+profits[i-1]);
                }
            }
        }

        for(int i = 0; i < V.length+1; i++){
            for(int j = 0; j < MAX_V+1; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Newton rekurencja
    public static int newton(int n, int k){
       if(k>=n) {System.out.println("n musi być >= k"); return 0;}

        if(k == 0 || n==k) return 1;
        return  newton(n-1, k-1) + newton(n-1,k);
    }

    //Newton dynamicznie
    public static int newtonDynamically(int K, int N){
        int arr[][] = new int[K+1][N+1];
        for(int n = 0; n<=N; n++){
            arr[0][n]=1;
        }

        for(int k = 0; k<=K; k++){
            for(int n = 0; n<=N; n++){
                if(k==n) arr[k][n]=1;
            }
        }

        for(int k = 1; k<=K; k++){
            for(int n = 2; n<=N; n++){
                if(k<n) arr[k][n]=arr[k-1][n-1] + arr[k][n-1];
            }
        }

        for(int j = 0; j <= K; j++){
            for(int i = 0; i <= N; i++){
                System.out.print(arr[j][i] + "\t");
            }
            System.out.println("");
        }

        return arr[K][N];
    }

    public static void resztaZachlannie(){
        int[] nominaly_w_gr = {500,200,100,50,20,10,5,2,1};
        int[] ile_nominalow = {  0,  0,  5,10, 4, 0,0,0,2};//max = 10.82

        System.out.println("zl: ");
        int zl = in.nextInt();

        System.out.println("gr: ");
        int gr = in.nextInt();

        int kwota_w_groszach = zl*100 + gr;

        for(int i = 0; i < nominaly_w_gr.length; i++){
            int ile_razy = kwota_w_groszach/nominaly_w_gr[i];

            if(ile_razy > ile_nominalow[i]) ile_razy = ile_nominalow[i];
            if(nominaly_w_gr[i]>=100) System.out.println(nominaly_w_gr[i]/100 + "zl razy: " + ile_razy);
            else System.out.println(nominaly_w_gr[i] + "gr razy: " + ile_razy);

            kwota_w_groszach -= nominaly_w_gr[i]*ile_razy;
        }
        if(kwota_w_groszach !=0){
            System.out.println("Do wydania została kwota: " + (double)kwota_w_groszach/100 + " brak odpowiednich nominałów");
        }
    }

    //Pole figury - Monte Carlo
    public static void poleFigury(){
        Random rand = new Random();
        int pktWFigurze = 0;

        for(int i = 0; i < 100000; i++){
            double x = rand.nextInt(0,1001)/1000.0;
            double y = rand.nextInt(0,1001)/1000.0;

            if(y<=Math.sin(x)){
                pktWFigurze++;
            }
        }

        System.out.println(pktWFigurze/100000.0);
    }
}
