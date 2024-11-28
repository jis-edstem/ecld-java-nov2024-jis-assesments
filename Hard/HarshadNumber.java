package com.edstem.ecld.pratice;

import java.util.Scanner;

public class HarshadNumber { // Hard Challenge
    public static int sumOfDigits(int n) {
        if(n == 0) {
            return 0;
        }

        return n %10 + sumOfDigits(n/10);
    }

    public static boolean isHarshad(int n){
        int sum = sumOfDigits(n);
        return n % sum == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int number = sc.nextInt();
        System.out.println(isHarshad(number)); // as told by edabit
        if(isHarshad(number)) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " isn't a Harshad Number.");
        }
    }
}
