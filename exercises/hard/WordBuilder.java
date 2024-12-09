package com.edstem.ecld.pratice;

import java.util.Scanner;

public class WordBuilder {
    public static boolean canBuild(String[] arr) {
        for(int i =0; i<arr.length -1; i++) {
            String first = arr[i];
            String second = arr[i + 1];

            if(second.length() != first.length() + 1){
                return false;
            }

            if(!(second.startsWith(first) || second.endsWith(first))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of Strings: ");
        int size = sc.nextInt();
        System.out.print("Enter the " + size + " strings to be checked: ");
        String[] array = new String[size];
        for(int i =0;i<size;i++){
            array[i] = sc.nextLine();
        }
        System.out.println(canBuild(array));
    }
}
