package dev.diego;

public class Account {
    protected float balance;
    protected int numDeposits;
    protected int numWithdrawals;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.numDeposits = 0;
        this.numWithdrawals = 0;
        this.monthlyFee = 0;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            numDeposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numWithdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = annualInterestRate / 12;
        float monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }

    public void generateMonthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public void printAccountDetails() {
        System.out.println("Balance: " + balance);
        System.out.println("Deposits: " + numDeposits);
        System.out.println("Withdrawals: " + numWithdrawals);
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        System.out.println("Monthly Fee: " + monthlyFee);
    }
}
