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
        return new Random().nextInt(100) + 1;
    }

    public static boolean swapArrays(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }
        int temp;

        for(int i=0; i<a.length; i++){
            temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }

    public static String camelCase(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int currentAsci, toAdd = 0;

        if(chars[0] >= 'a' && chars[0] <= 'z'){
            sb.append((char)(chars[0]-32));
        } else if(chars[0] >= 'A' && chars[0] <= 'Z'){
            sb.append(chars[0]);
        }

        for(int i=1; i<chars.length; i++){
            currentAsci = (int)chars[i];
            if((currentAsci >= 65 && currentAsci <= 90) // A-Z
            || (currentAsci >= 97 && currentAsci <= 122)){ // a-z
                if(chars[i-1] == ' '){ // Buchstabe groß
                    if(chars[i] >= 'a'){
                        currentAsci -= 32;
                    }
                }else if(currentAsci <= 90){ // sonst klein
                    currentAsci += 32;
                }
                sb.append((char)currentAsci);
            }
        }

        return sb.toString();
    }

    public static int checkDigit(int[] code){
        int sum = 0;
        for(int i=0; i<code.length; i++){
            sum += code[i]*(i+2);
        }
        int rest = sum % 11;
        int check = 11 - rest;

        if(check == 10){
            check = 0;
        } else if(check == 11){
            check = 5;
        }
        return check;
    }
}