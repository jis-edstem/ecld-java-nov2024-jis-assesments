package com.edstem.ecld.pratice;

import java.util.Objects;
import java.util.Scanner;

public class BasicOperation {  // Medium Challenge
    public static String operation(String a, String b, String op) {
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        if(Objects.equals(op, "add")) {
            return String.valueOf(num1 + num2);
        } else if (Objects.equals(op, "subtract")) {
            return String.valueOf(num2 - num1);
        } else if (Objects.equals(op, "divide")) {
            return String.valueOf(num1/num2);
        } else if (Objects.equals(op, "multiply")) {
            return String.valueOf(num1*num2);
        } else
            return "Invalid Operation";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        String num1 = sc.nextLine();
        System.out.println("Enter the second number:");
        String num2 = sc.nextLine();
        System.out.println("Specify the operation to be performed:");
        String operation = sc.nextLine();
        String result = operation(num1, num2, operation);
        System.out.println(result);
    }
}
