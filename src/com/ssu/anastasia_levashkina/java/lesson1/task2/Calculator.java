package com.ssu.anastasia_levashkina.java.lesson1.task2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.myCalculator();

    }

    public void myCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number A:");
        int a = scanner.nextInt();

        System.out.println("Enter number B:");
        int b = scanner.nextInt();

        scanner.nextLine();
        while (true) {
            System.out.println("\nChoose an operation:\n+, -, *, /, 1 - change numbers, 0 - exit");
            String operation = scanner.nextLine();

            switch (operation) {
                case "+":
                    System.out.println(a + " + " + b + " = " + addition(a, b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + subtraction(a, b));
                    break;
                case "*":
                    System.out.println(a + " * " + b + " = " + multiplication(a, b));
                    break;
                case "/":
                    System.out.println(a + " / " + b + " = " + division(a, b));
                    break;
                case "1":
                    System.out.println("Enter number A:");
                    a = scanner.nextInt();

                    System.out.println("Enter number B:");
                    b = scanner.nextInt();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid value");
                    break;
            }
        }
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("Division by 0");
            return Integer.MAX_VALUE;
        }
    }
}
