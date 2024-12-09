package com.edstem.ecld.pratice;

import java.util.Scanner;

public class Reverse {
    public static String reversed (String str) { // Medium Challenge
        if(str.isEmpty()) {
            return str;
        }
        return reversed(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to be reversed: ");
        String str = sc.nextLine();
        String reversed = reversed(str);

        System.out.println("The reversed form of (" + str + ") is " + reversed);
    }
}
