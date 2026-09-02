// Challenge 2. Create a small REPL application where a user can:
//Check account balance (start at 0)
//Deposit into their account
//Withdraw from their account
//Exit


import java.util.Scanner;

public class AccountREPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance=0;
        Scanner Scanner = new Scanner(System.in);
        double Balance = 0;

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Balance: $" + balance);

            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                balance += amount;
                System.out.println("Deposit successful.");

            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();

                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }

            } else if (choice == 4) {
                System.out.println("have a good day!");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}

