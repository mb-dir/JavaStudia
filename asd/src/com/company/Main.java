package com.company;

public class Main {
    final static int[] V = {6,2,3,2,3,1};
    final static int[] W = {6,4,5,7,10,2};
    static int MAX_V = 10;

    public static void main(String[] args) {
        System.out.println(newtonDynamically(4,2));
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

    //Newton rekurencja
    public static int newton(int n, int k){
       if(k>=n) {System.out.println("n musi być >= k"); return 0;}

        if(k == 0 || n==k) return 1;
        return  newton(n-1, k-1) + newton(n-1,k);
    }

    //Newton dynamicznie
    public static int newtonDynamically(int n, int k){
        int[][] arr = new int[k+1][n+1];

        for(int i = 0; i < n; i++){
            arr[i][0] = 1;
            for(int j = 0; j < k; j++){
                if(i == j) arr[i][j] = 1;
                if(j < i) arr[i][j] =arr[i-1][j-1]+arr[i-1][j];
            }
        }

        return arr[n-1][k-1];
    }
}
