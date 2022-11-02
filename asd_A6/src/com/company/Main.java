package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    int min = 0;
        int max = 1000;
        int a = getRandomNumber(min, max);
        boolean isGuessedInFirstAttempt = false;

        System.out.println(a);

        int firstAttempt = max/2;

        System.out.println("Czy to liczba " + firstAttempt + "?");

        if(a == firstAttempt){
            System.out.println("TAK");
            isGuessedInFirstAttempt=false;
        }
        if(firstAttempt > a){
            System.out.println("ZA DUŻA");
            max=firstAttempt;
        }else if(firstAttempt < a){
            System.out.println("ZA MALA");
            min = firstAttempt;
        }

        if(!isGuessedInFirstAttempt){
            for(int i = 0; i < 2; i--) {
                if (i != 0) {
                    System.out.println("Czy to liczba " + (int)((min+max)/2) + "?");

                    if (a == (int)((min+max)/2)) {
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
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
