package com.edstem.ecld.pratice;

import java.util.Scanner;

public class VowelChecker {
    public static boolean isVowel(char ch) {
        ch=Character.toUpperCase(ch);
        return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    public static int countVowels(String word) {
        int count = 0;
        for(int i =0;i < word.length();i++) {
            if(isVowel(word.charAt(i)))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word:");
        String word = sc.nextLine();
        int count = countVowels(word);
        System.out.println("There are " + count + " vowels in " + word);
    }
}
