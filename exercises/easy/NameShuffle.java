package com.edstem.ecld.pratice;

import java.util.Scanner;

public class NameShuffle {

    public static String nameShuffle(String name) { // Easy Challenge
        String firstName = name.substring(0,(name.indexOf(" ")));
        String lastName = name.substring(name.indexOf(" "));
        String cName = lastName + " " + firstName;
        return cName;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name to be shuffled:");
        String name = sc.nextLine();
        name = nameShuffle(name);
        System.out.println(name);
    }

}
