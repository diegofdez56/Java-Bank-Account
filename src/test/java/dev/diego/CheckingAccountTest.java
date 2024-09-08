package dev.diego;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    private CheckingAccount checking;

    @BeforeEach
    public void setUp() {
        checking = new CheckingAccount(5000, 0.05f);
    }

    @Test
    public void testCheckingAccountInitialOverdraft() {
        assertEquals(0, checking.getOverdraft());
    }

    @Test
    public void testCheckingAccountWithdrawWithinBalance() {
        checking.withdraw(2000);
        assertEquals(3000, checking.getBalance());
        assertEquals(0, checking.getOverdraft());
    }

    @Test
    public void testCheckingAccountWithdrawOverBalance() {
        checking.withdraw(6000);
        assertEquals(0, checking.getBalance());
        assertEquals(1000, checking.getOverdraft()); 
    }

    @Test
    public void testCheckingAccountDepositReducesOverdraft() {
        checking.withdraw(6000);
        assertEquals(1000, checking.getOverdraft());

        checking.deposit(1500);
        assertEquals(0, checking.getOverdraft());
        assertEquals(500, checking.getBalance()); 
    }

    @Test
    public void testPrintAccountDetails() {
        checking.printAccountDetails();
    }
}
