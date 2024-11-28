package com.edstem.ecld.pratice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LuckySeven { // Hard Challenge
    public static boolean luckySeven(int[] r) {
        if (r.length < 3) {
            return false;
        }

        for(int i = 0;i < r.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            int target = 7 - r[i];
            for(int j = i+1; j < r.length; j++) {
                int complement = target - r[j];
                if(seen.contains(complement)) {
                    return true;
                }
                seen.add(r[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.print("Enter the element values: ");
        for(int i =0;i<size;i++){
            array[i] = sc.nextInt();
        }
        System.out.println(luckySeven(array)); // As requested by edabit Problem
        if(luckySeven(array)) {
            System.out.print("The following elements can form 7");
        } else {
            System.out.println("It is not possible to form 7 with the provided elements");
        }
    }
}
