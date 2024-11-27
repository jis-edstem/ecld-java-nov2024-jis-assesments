package com.edstem.ecld.pratice;

import java.util.Scanner;

public class PrimeInRange { // Medium Challenge

    public static boolean isPrime(int n1) {

        if(n1 <= 1) {
            return false;
        }
        for(int i = 2;i <= Math.sqrt(n1);i++) {
            if(n1 % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean PrimeNumberInRange(int n1, int n2) {
        boolean foundPrime = false;

        System.out.print("Prime numbers in the range [" + n1 + ", " + n2 + "]: ");
        for (int i = n1; i <= n2; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
                foundPrime = true;
            }
        }
        return foundPrime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the start of the range of numbers to be checked: ");
        int start = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the end of the range of numbers to be checked: ");
        int end = Integer.parseInt(sc.nextLine());
        if (PrimeNumberInRange(start,end)) {
            System.out.println();
            System.out.println("There are Prime Numbers in specified Range.");
        } else {
            System.out.println("There are no Prime Numbers in specified Range:");
        }

    }
}
