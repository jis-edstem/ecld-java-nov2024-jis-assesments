package com.edstem.ecld.pratice;

import java.util.Arrays;
import java.util.Scanner;

public class GamerClass { // Easy Challenge
    public static int[] calculateScores(String str) {
        int[] array = new int[3];
        for(char ch: str.toCharArray()) {
            if(ch == 'A') {
                array[0]++;
            }
            if (ch == 'B') {
                array[1]++;
            }
            if (ch == 'C') {
                array[2]++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the score sheet to be checked");
        String str = sc.nextLine();
        int[] score = calculateScores(str);
        System.out.println(Arrays.toString(score));

    }
}
