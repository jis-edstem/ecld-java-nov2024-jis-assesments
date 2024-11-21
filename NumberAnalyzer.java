import java.util.Scanner;

public class NumberAnalyzer {
    public static void analyzeNumber(int num) {
        System.out.println("Number " + num + " is: ");
        if(num < 0) {
            System.out.println("- Negative");
        } else if (num > 0) {
            System.out.println("- Positive");
        } else {
            System.out.println("- Zero");
        }
        if(num % 2 == 0) {
            System.out.println("- Even");
        } else {
            System.out.println("- Odd");
        }
        if(num % 5 == 0){
            System.out.println("- Multiple of 5");
        } else {
            System.out.println("- Not a multiple of 5");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = Integer.parseInt(scanner.nextLine());
        analyzeNumber(num1);
        System.out.println("Enter number 2: ");
        int num2 = Integer.parseInt(scanner.nextLine());
        analyzeNumber(num2);
    }
}
