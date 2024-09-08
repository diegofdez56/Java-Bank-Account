package dev.diego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testDeposit() {
        Account account = new Account(5000, 0.05f);
        account.deposit(1000);
        assertEquals(6000, account.balance);
    }

    @Test
    public void testWithdraw() {
        Account account = new Account(5000, 0.05f);
        account.withdraw(2000);
        assertEquals(3000, account.balance);
    }

    @Test
    public void testMonthlyInterest() {
        Account account = new Account(12000, 0.12f);
        account.calculateMonthlyInterest();
        assertEquals(12120, account.balance, 0.01);
    }

    @Test
    public void testCheckingAccountOverdraft() {
        CheckingAccount checking = new CheckingAccount(5000, 0.05f);
        checking.withdraw(6000);
        assertEquals(0, checking.balance);
        assertEquals(1000, checking.getOverdraft());
    }
}
