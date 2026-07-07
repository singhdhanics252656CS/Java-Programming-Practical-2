package javaapplication5;

import java.util.Scanner;

// Abstract class
abstract class MathOperation {
    // Abstract method
    abstract double calculate(double a, double b);

    // Concrete method
    void displayResult(String operation, double result) {
        System.out.println(operation + " Result: " + result);
    }
}

// Subclass for Addition
class Addition extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a + b;
    }
}

// Subclass for Subtraction
class Subtraction extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a - b;
    }
}

// Subclass for Multiplication
class Multiplication extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a * b;
    }
}

// Subclass for Division
class Division extends MathOperation {
    @Override
    double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Main class
public class JavaApplication5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        MathOperation add = new Addition();
        MathOperation subtract = new Subtraction();
        MathOperation multiply = new Multiplication();
        MathOperation divide = new Division();

        // Perform operations
        add.displayResult("Addition", add.calculate(a, b));
        subtract.displayResult("Subtraction", subtract.calculate(a, b));
        multiply.displayResult("Multiplication", multiply.calculate(a, b));

        // Handle division by zero
        try {
            divide.displayResult("Division", divide.calculate(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}