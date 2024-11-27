package com.edstem.ecld.pratice;

import java.util.Scanner;

public class StringDuplication {
    public static String doubleChar(String s) { // Easy Challenge
        int l = s.length();
        String newString = "";
        for (int i = 0; i < l; i++) {
            newString += s.substring(i, i+1) + s.substring(i, i+1);
        }
        return newString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to be checked:");
        String str1 = sc.nextLine();
        System.out.println("The input string is: " + str1);
        System.out.println("The output string is: " + doubleChar(str1));
    }
}
