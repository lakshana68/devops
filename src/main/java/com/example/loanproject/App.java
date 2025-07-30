package com.example.loanproject;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Inputs
        System.out.println("Enter your gender (Male/Female): ");
        String gender = sc.nextLine().trim().toLowerCase();

        System.out.println("Are you married? (Yes/No): ");
        String married = sc.nextLine().trim().toLowerCase();

        System.out.println("Enter your monthly income: ");
        double income = sc.nextDouble();

        System.out.println("Do you own property? (Yes/No): ");
        sc.nextLine(); // consume newline
        String property = sc.nextLine().trim().toLowerCase();

        System.out.println("Enter the total loan amount you are requesting: ");
        double requestedAmount = sc.nextDouble();

        // Logic to determine approval and loan percentage
        boolean isApproved = false;
        double loanPercentage = 0;

        if (income > 25000 && property.equals("yes")) {
            isApproved = true;
            loanPercentage = 80;
        } else if (income > 15000 && married.equals("yes")) {
            isApproved = true;
            loanPercentage = 60;
        } else if (income > 10000 && gender.equals("male")) {
            isApproved = true;
            loanPercentage = 50;
        } else {
            isApproved = false;
            loanPercentage = 0;
        }

        // Final Result
        System.out.println("\n--- Loan Prediction Result ---");
        if (isApproved) {
            double eligibleAmount = (loanPercentage / 100.0) * requestedAmount;
            System.out.println("✅ Loan Approved!");
            System.out.println("You are eligible for " + loanPercentage + "% of the requested amount.");
            System.out.println("Eligible loan amount: ₹" + eligibleAmount);
        } else {
            System.out.println("❌ Loan Not Approved.");
            System.out.println("You are not eligible for the requested loan based on the provided details.");
        }

        sc.close();
    }
}
