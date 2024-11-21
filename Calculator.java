import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calculator {
    public static double add(double a, double b) {
        return a+b;
    }

    public static double subtract(double a, double b) {
        return a-b;
    }

    public static double multiply(double a, double b) {
        return a*b;
    }

    public static double divide(double a, double b) {
        if(a!=0) {
            return a / b;
        } else if (b!=0) {
            return a / b;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = parseInt((scanner.nextLine()));
        System.out.print("Enter second number: ");
        int num2 = parseInt((scanner.nextLine()));
        System.out.println("Choose Operation: ");
        System.out.println("1. Add (+)");
        System.out.println("2. Subtract (-)");
        System.out.println("3. Multiply (*)");
        System.out.println("4. Divide (/)");
        System.out.print("Enter choice: ");
        int choice = parseInt(scanner.nextLine());
        if(choice == 1) {
            System.out.println(num1 + " + " + num2 + " = " + (int)add(num1, num2));
        } else if (choice == 2) {
            System.out.println(num1 + " - " + num2 + " = " + (int)subtract(num1, num2));
        } else if (choice == 3) {
            System.out.println(num1 + " * " + num2 + " = " + (int)multiply(num1, num2));
        } else if (choice == 4) {
            System.out.println(num1 + " / " + num2 + " = " + (int)divide(num1, num2));
        } else {
            System.out.println("Invalid Operation Choice Entered");
        }
    }
}
