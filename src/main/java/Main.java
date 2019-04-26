package main.java;

import main.java.DueCalculator;

public class Main {

    public static void main(String[] args) {
        DueCalculator calculator = new DueCalculator();
        System.out.println(calculator.calculateDueDate("Monday 9:12AM", 28));
    }
}
