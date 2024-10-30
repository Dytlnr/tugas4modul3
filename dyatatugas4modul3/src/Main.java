import java.util.Scanner;

// Class to manage account-related operations
class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: " + balance);
    }

    public int getBalance() {
        return balance;
    }
}

// Main ATM program with refactored structure
 class ATMRefactored {
    // Menu options as constants
    public static final int CHECK_BALANCE = 1;
    public static final int WITHDRAW = 2;
    public static final int DEPOSIT = 3;
    public static final int EXIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(10000);  // Start with initial balance

        displayMenu(scanner, account);
    }

    // Refactored display menu logic
    public static void displayMenu(Scanner scanner, Account account) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("ATM Menu");
            System.out.println(CHECK_BALANCE + ". Check Balance");
            System.out.println(WITHDRAW + ". Withdraw");
            System.out.println(DEPOSIT + ". Deposit");
            System.out.println(EXIT + ". Exit");
            System.out.print("Choose an option: ");
            int choice = getUserInput(scanner);

            switch (choice) {
                case CHECK_BALANCE:
                    account.checkBalance();
                    break;
                case WITHDRAW:
                    System.out.print("Enter amount to withdraw: ");
                    int amountToWithdraw = getUserInput(scanner);
                    account.withdraw(amountToWithdraw);
                    break;
                case DEPOSIT:
                    System.out.print("Enter amount to deposit: ");
                    int amountToDeposit = getUserInput(scanner);
                    account.deposit(amountToDeposit);
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Function to handle user input validation
    public static int getUserInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();  // Clear the invalid input
        }
        return scanner.nextInt();
    }
}