package com.edstem.ecld.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldbachConjecture { // Hard Challenge
    public static boolean isPrime(int n1) {
        if(n1 <= 1) {
            return false;
        }
        for(int i = 2;i * i <= n1;i++) {
            if(n1 % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] goldbachConjecture(int n) {
        if(n % 2 != 0 || n <= 2) {
            return new int[0];
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2;i < n;i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        int maxDiff = -1;
        int[] result = new int[0];

        for(int p1 : primes) {
            int p2 = n - p1;
            if (p2 >= p1 && isPrime(p2)) {
                if(p2- p1 > maxDiff) {
                    maxDiff = p2 - p1;
                    result = new int[]{p1, p2};
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int n1 = Integer.parseInt(sc.nextLine());
        int[] results = goldbachConjecture(n1);

        printArray(results);
    }

    public static void printArray(int[] array) {
        if(array.length == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for(int i = 0;i < array.length; i++) {
                System.out.print(array[i]);
                if(i < array.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}
