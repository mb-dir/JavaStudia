package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    int min = 0;
        int max = 1000;
        int a = getRandomNumber(min, max);

        System.out.println(a);

        while(true){
            System.out.println("Czy to liczba " + (int)((min+max)/2) + "?");
            if(a == (int)((min+max)/2)){
                System.out.println("TAK");
                break;
            }
            if((int)((min+max)/2) > a){
                System.out.println("ZA DUŻA");
                max = (int)((min+max)/2);
            }else if((int)((min+max)/2) < a){
                System.out.println("ZA MALA");
                min = (int)((min+max)/2);
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
