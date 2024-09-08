package dev.diego;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.isActive = balance >= 10000;
    }

    @Override
    public void withdraw(float amount) {
        if (isActive) {
            super.withdraw(amount);
        }
        updateAccountStatus();
    }

    @Override
    public void deposit(float amount) {
        super.deposit(amount);
        updateAccountStatus();
    }

    private void updateAccountStatus() {
        isActive = balance >= 10000;
    }

    @Override
    public void generateMonthlyStatement() {
        if (numWithdrawals > 4) {
            monthlyFee += (numWithdrawals - 4) * 1000;
        }
        super.generateMonthlyStatement();
        updateAccountStatus();
    }

    @Override
    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("Account Active: " + isActive);
    }
}
