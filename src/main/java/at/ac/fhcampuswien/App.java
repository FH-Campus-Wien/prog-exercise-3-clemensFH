package at.ac.fhcampuswien;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }

    public static void oneMonthCalendar(int days, int first){
        int newLine = 7-first+1;
        for(int i=1; i<first; i++){
            System.out.print("   ");
        }

        for(int i=1; i<=days; i++){
            System.out.printf("%2d ", i);
            if(i==newLine && i!=days){
                System.out.println();
                newLine+=7;
            }

        }
        System.out.println();
    }

    public static long[] lcg(long x){
        long[] randoms = new long[10];
        final short c = 12345;
        final long a = 1103515245, m = (int) Math.pow(2,31)+1;

        randoms[0] = (a*x + c) % m;

        for(int i=1; i<randoms.length; i++){
            randoms[i] = (a*randoms[i-1] + c) % m;
        }
        return randoms;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);
        int counter = 1, guess;

        while(counter <= 10){
            System.out.print("Guess number " + counter + ": ");
            guess = scanner.nextInt();

            if(counter == 10 && guess != numberToGuess){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if(guess > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
                counter++;
            }else if(guess < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
                counter++;
            }else{
                System.out.println("You won wisenheimer!");
                return;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred(){
        return new Random().nextInt(101);
    }
}