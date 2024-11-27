package com.edstem.ecld.pratice;

import java.util.Scanner;

public class GcdLcm { // Medium Challenge
    public static int gcd(int a, int b) {
        while (b !=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a*b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number to be taken LCM of: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the second number to be taken LCM of: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int result = lcm(num1, num2);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is " + result);
    }
}
