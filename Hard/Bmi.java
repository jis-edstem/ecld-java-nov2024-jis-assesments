package com.edstem.ecld.pratice;

import java.util.Scanner;

public class Bmi { // Hard Challenge
    public static String BMI(String weight, String height) {
        String weightUnit = weight.replaceAll("[0-9]", "").trim().toLowerCase();
        String heightUnit = height.replaceAll("[0-9]", "").trim().toLowerCase();

        double weightValue = Double.parseDouble(weight.replaceAll("[^0-9.]", ""));
        double heightValue = Double.parseDouble(height.replaceAll("[^0-9.]",""));

        if(weightUnit.equals("pounds")) {
            weightValue = weightValue * 0.453592;
        }

        if(heightUnit.equals("inches")) {
            heightValue = heightValue * 0.0254;
        }

        double bmi = weightValue / (heightValue * heightValue);
        bmi = Math.round(bmi * 10.0) / 10.0;

        String category;
        if(bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            category = "Normal Weight";
        } else if (bmi >= 25 && bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }

        return String.format("BMI: %.1f, Category : %s", bmi, category);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the weight in kilos or pounds along with the units(in words): ");
        String weight = sc.nextLine();
        System.out.print("Enter the height in inches or meters along with the units(in words): ");
        String height = sc.nextLine();
        System.out.println(BMI(weight, height));
    }
}
