import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double temp = Integer.parseInt(scanner.nextLine());
            System.out.println(temp + " °C = " + celsiusToFahrenheit(temp) + " °F");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit");
            double temp = Integer.parseInt(scanner.nextLine());
            System.out.println(temp + "°F = " + fahrenheitToCelsius(temp) + "°C");
        } else {
            System.out.println("Not a valid input chosen");
        }
    }
}
