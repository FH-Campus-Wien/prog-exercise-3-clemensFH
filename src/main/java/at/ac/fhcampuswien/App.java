package at.ac.fhcampuswien;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        oneMonthCalendar(29, 4);

        Random rd = new Random();
        //guessingGame(rd.nextInt(5001));

        System.out.println("Before Swap");
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println(swapArrays(arr1, arr2));
        System.out.println("After Swap");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        String s = "Haaland is the Goat!!";
        System.out.println(camelCase(s));
    }

    public static void oneMonthCalendar(int days, int first){
        // Ersten Leerstellen
        for(int i=1; i<first; i++){
            System.out.print("   ");
        }

        for(int i=1; i<=days; i++){
            System.out.printf("%2d ", i);
            if((i+first-1) % 7 == 0 && i!=days){ // Zeilenumbruch (i + Leertage - 1) % 7
                System.out.println();
            }
        }
        System.out.println();
    }

    public static long[] lcg(long x){
        long[] randoms = new long[10];
        final short c = 12345;
        final int a = 1103515245, m = (int) Math.pow(2,31)+1;

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

            if(counter == 10 && guess != numberToGuess){ // Letzter versuch falsch
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if(guess > numberToGuess){ // zu groß
                System.out.println("The number AI picked is lower than your guess.");
                counter++;
            }else if(guess < numberToGuess){ // zu klein
                System.out.println("The number AI picked is higher than your guess.");
                counter++;
            }else{ // SIEG
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
            // Dreieckstausch
            temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }

    public static String camelCase(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int currentAsci;
        final int diff = 'a' - 'A'; //32

        //Erster Buchstabe fix groß
        if(chars[0] >= 'a' && chars[0] <= 'z'){
            sb.append((char)(chars[0]-diff));
        } else if(chars[0] >= 'A' && chars[0] <= 'Z'){
            sb.append(chars[0]);
        }

        for(int i=1; i<chars.length; i++){
            currentAsci = (int)chars[i];
            if((chars[i] >= 'A' && chars[i] <= 'Z') // Nur um Buchstaben kümmern (A-Za-z)
            || (chars[i] >= 'a' && chars[i] <= 'z')){
                if(chars[i-1] == ' '){ // CamelCase (Leerzeichen zuvor)
                    if(chars[i] >= 'a'){ // falls Kleinbuchstabe, dann Gro0
                        currentAsci -= diff; // if in if weil sonst else if später nicht greift
                    }
                }else if(chars[i] <= 'Z'){ // sonst klein
                    currentAsci += diff;
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

        // Ausnahmefälle
        if(check == 10){
            check = 0;
        } else if(check == 11){
            check = 5;
        }
        return check;
    }
}