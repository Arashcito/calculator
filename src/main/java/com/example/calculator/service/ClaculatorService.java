package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class ClaculatorService {

    public double calculate(double operand1, double operand2, String operation) {
        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                return operand1 + operand2;
            case "subtract":
            case "-":
                return operand1 - operand2;
            case "multiply":
            case "*":
                return operand1 * operand2;
            case "divide":
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                return operand1 / operand2;
            case "power":
            case "^":
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }

    public double sqrt(double operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("Square root of negative number is not allowed");
        }
        return Math.sqrt(operand);
    }

    public double percentage(double operand) {
        return operand / 100;
    }
}
