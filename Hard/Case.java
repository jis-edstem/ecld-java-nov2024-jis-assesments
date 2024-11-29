package com.edstem.ecld.pratice;

import java.util.Scanner;

public class Case { // Hard Challenge
    public static String toCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for(int i = 0;i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == ' ' || currentChar == '_') {
                capitalizeNext = true;
            } else {
                if(capitalizeNext) {
                    result.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            }
        }
        return result.toString();
    }

    public static String toSnakeCase(String str) {
        StringBuilder result = new StringBuilder();

        for(int i =0;i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if(Character.isUpperCase(currentChar)) {
                if(i > 0) {
                    result.append('_');
                }
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Conversion Menu");
        System.out.println("1. SnakeCase - CamelCase");
        System.out.println("2. CamelCase - SnakeCase");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1) {
            System.out.print("Enter the word to be converted to Camel Case: ");
            String string1 = sc.nextLine();
            System.out.println(string1 + " converted to camel case is: " + toCamelCase(string1));
        } else if (choice == 2) {
            System.out.print("Enter the word to be converted to Snake Case: ");
            String string2 = sc.nextLine();
            System.out.print(string2 + " converted to snake case is: " + toSnakeCase(string2));
        } else {
            System.out.println("Wrong choice entered.");
        }
    }
}
