package com.example.personalfinanceapp;

public class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + '\'' +
                ": $" + amount;
    }
}
