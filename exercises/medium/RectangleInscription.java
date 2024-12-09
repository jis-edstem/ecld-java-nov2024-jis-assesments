package com.edstem.ecld.pratice;

import java.util.Scanner;

public class RectangleInscription { // Medium Challenge
    public static boolean rectangleInCircle(int w, int h, int radius) {
        int rectangularArea = w * h;
        if (rectangularArea <= 2 * radius * radius) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width of the rectangle: ");
        int width = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the height of the rectangle: ");
        int height = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the radius of the circle: ");
        int radius = Integer.parseInt(sc.nextLine());
        if(rectangleInCircle(width, radius, radius)) {
            System.out.println("The rectangle of width " + width + " and height " + height + " is possible to be inscribed");
        } else {
            System.out.println("The rectangle of width " + width + " and height " + height + " is not possible to be inscribed");
        }
    }
}