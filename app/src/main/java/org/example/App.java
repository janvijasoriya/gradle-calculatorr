package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1;
        try {
            num1 = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            scanner.close();
            return;
        }
        System.out.print("Enter second number: ");
        double num2;
        try {
            num2 = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            scanner.close();
            return;
        }
        System.out.print("Choose operation (+, -, *, /): ");
        String operation = scanner.next();

        double result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid operation! Use +, -, *, or /.");
        }
        scanner.close();
    }
}