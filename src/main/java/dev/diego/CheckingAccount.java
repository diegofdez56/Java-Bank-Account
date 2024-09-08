package dev.diego;

public class CheckingAccount extends Account {
    private float overdraft;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount > balance) {
            overdraft += (amount - balance);
            balance = 0;
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount > overdraft) {
                amount -= overdraft;
                overdraft = 0;
                super.deposit(amount);
            } else {
                overdraft -= amount;
            }
        } else {
            super.deposit(amount);
        }
    }

    @Override
    public void generateMonthlyStatement() {
        super.generateMonthlyStatement();
    }

    @Override
    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("Overdraft: " + overdraft);
    }

    public float getBalance() {
        return balance;
    }

    public float getOverdraft() {
        return overdraft;
    }
}
