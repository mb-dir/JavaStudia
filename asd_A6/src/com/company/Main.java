package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    int min = 0;
        int max = 1000;
        int a = getRandomNumber(min, max);

        System.out.println(a);
        recursion(min, (min+max)/2, max, a);
    }

    public static int recursion(int left, int p, int right, int a) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        if(p == a){
            System.out.println(p + " znaleziono");
            return 0;
        }
        if(p < a){
            System.out.println(p + " za mala");
            return recursion(p, (int)(p+right+1)/2, right, a);
        }else{
            System.out.println(p + " za duza");
            return recursion(left, (int)(p+left)/2, p, a);
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
