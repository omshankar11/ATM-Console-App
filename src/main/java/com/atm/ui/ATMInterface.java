package com.atm.ui;

import java.util.Scanner;

import com.atm.model.Account;
import com.atm.service.AccountService;

/**
 * Main ATM user interface class.
 */
public class ATMInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n========================================");
                System.out.println("      Welcome to the ATM System!");
                System.out.println("========================================");

                System.out.print("Enter account number: ");
                int accountNumber = getIntInput(scanner);

                System.out.print("Enter PIN: ");
                int pin = getIntInput(scanner);

                Account account = AccountService.getAccount(accountNumber, pin);
                if (account != null) {
                    System.out.println("\n✓ Login successful!");
                    showATMMenu(scanner, account);
                } else {
                    System.out.println("\n✗ Invalid account number or PIN.");
                }

                System.out.print("\nDo you want to perform another transaction? (yes/no): ");
                String response = scanner.nextLine().toLowerCase().trim();
                running = response.equals("yes") || response.equals("y");

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }

        System.out.println("\nThank you for using the ATM. Goodbye!");
        scanner.close();
    }

    private static void showATMMenu(Scanner scanner, Account account) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("          ATM Menu");
            System.out.println("========================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Recent Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    deposit(scanner, account);
                    break;
                case 3:
                    withdraw(scanner, account);
                    break;
                case 4:
                    viewTransactions(account);
                    break;
                case 5:
                    System.out.println("\nReturning to main menu...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBalance(Account account) {
        System.out.println("\n----------------------------------------");
        System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));
        System.out.println("----------------------------------------");
    }

    private static void deposit(Scanner scanner, Account account) {
        System.out.print("Enter amount to deposit: $");
        double amount = getDoubleInput(scanner);

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        account.deposit(amount);
        if (AccountService.updateBalance(account)) {
            AccountService.logTransaction(account.getAccountNumber(), "DEPOSIT", amount);
            System.out.println("✓ Deposit successful!");
            System.out.println("New balance: $" + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("✗ Deposit failed. Please try again.");
        }
    }

    private static void withdraw(Scanner scanner, Account account) {
        System.out.print("Enter amount to withdraw: $");
        double amount = getDoubleInput(scanner);

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (account.withdraw(amount)) {
            if (AccountService.updateBalance(account)) {
                AccountService.logTransaction(account.getAccountNumber(), "WITHDRAWAL", amount);
                System.out.println("✓ Withdrawal successful!");
                System.out.println("New balance: $" + String.format("%.2f", account.getBalance()));
            } else {
                // Rollback the withdrawal if database update fails
                account.deposit(amount);
                System.out.println("✗ Withdrawal failed. Please try again.");
            }
        } else {
            System.out.println("✗ Insufficient funds.");
            System.out.println("Current balance: $" + String.format("%.2f", account.getBalance()));
        }
    }

    private static void viewTransactions(Account account) {
        System.out.println("\n----------------------------------------");
        System.out.println("Recent Transactions for Account: " + account.getAccountNumber());
        System.out.println("----------------------------------------");
        System.out.println("Feature to be implemented in v2.0");
        System.out.println("----------------------------------------");
    }

    private static int getIntInput(Scanner scanner) {
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getIntInput(scanner);
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        try {
            String input = scanner.nextLine().trim();
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            return getDoubleInput(scanner);
        }
    }
}
