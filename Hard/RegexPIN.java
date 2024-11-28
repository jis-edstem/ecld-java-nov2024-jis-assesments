package com.edstem.ecld.pratice;

import java.util.Scanner;

public class RegexPIN { // Hard Challenge
    public static boolean validate(String pin) {
        if(pin.length() != 4 && pin.length() != 6) {
            return false;
        }

        for(char c : pin.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PIN Combination: ");
        String pin = sc.nextLine();
        System.out.println(validate(pin));
    }
}
