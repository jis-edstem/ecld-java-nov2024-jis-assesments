package com.edstem.ecld.pratice;

import java.util.Scanner;

public class Volume { // Medium Challenge
    public static int totalVolume(int[][] part) {
        int totalVolume = 0;
        for(int[] box: part) {
            int volume = box[0] * box[1] * box[2];
            totalVolume += volume;
        }
        return totalVolume;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the first box: ");
        int l1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the breadth of the first box: ");
        int b1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the height of the first box: ");
        int h1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the length of the second box: ");
        int l2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the breadth of the second box: ");
        int b2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the height of the second box: ");
        int h2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the length of the third box: ");
        int l3 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the length of the third box: ");
        int b3 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the length of the third box: ");
        int h3 = Integer.parseInt(sc.nextLine());

        int[][] boxes = {
                {l1, b1, h1},
                {l2, b2, h2},
                {l3, b3, h3}
        };

        int total = totalVolume(boxes);
        System.out.print("The total volume of the 3 boxes provided is: " + total);
    }
}
