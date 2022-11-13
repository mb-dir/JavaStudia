package com.company;

public class Main {
    final static int[] V = {6,2,3,2,3,1};
    final static int[] W = {6,4,5,7,10,2};
    static int MAX_V = 10;

    public static void main(String[] args) {

        PDynalically();
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
        if (i == 0 && v >= V[i]) return W[i];
        if (i != 0 && V[i]>v) return P(i-1, v);
        return Math.max(P(i-1, v), W[i] + P(i-1, v-V[i]));
    }

    //Plecak dynamicznie
    public static void PDynalically(){
        int wartosci[] = {1,2,5,6};
        int objetosci[] = {2,3,4,5};
        int objPlecaka = 8;

        int arr[][] = new int[wartosci.length + 1][objPlecaka+1];

        for(int i = 0; i < wartosci.length+1; i++){
            arr[i][0] = 0;
        }
        for(int i = 0; i < objPlecaka+1; i++){
            arr[0][i] = 0;
        }

        for(int i = 1; i < wartosci.length; i++){
            for(int j = 1; j < objPlecaka; j++){
                if(j-objetosci[i]<0){
                    arr[i][j] = arr[i-1][j];
                }else{
                    arr[i][j]=Math.max(arr[i-1][j], arr[i-1][j-objetosci[i]]+wartosci[i]);
                }
            }
        }

        for(int i = 0; i < wartosci.length+1; i++){
            for(int j = 0; j < objPlecaka+1; j++){
                System.out.print(arr[i][j] + "  ");
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
}
