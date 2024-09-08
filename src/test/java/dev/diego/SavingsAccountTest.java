package dev.diego;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    private SavingsAccount savings;

    @BeforeEach
    public void setUp() {
        savings = new SavingsAccount(15000, 0.05f);
    }

    @Test
    public void testSavingsAccountInitialActive() {
        assertTrue(savings.isActive());
    }

    @Test
    public void testSavingsAccountActiveAfterDeposit() {
        savings.deposit(5000);
        assertTrue(savings.isActive());
    }

    @Test
    public void testSavingsAccountInactiveAfterWithdraw() {
        savings.withdraw(14000);
        assertFalse(savings.isActive());
    }

    @Test
    public void testSavingsAccountNoWithdrawWhenInactive() {
        savings.withdraw(14000);
        assertFalse(savings.isActive());

        float initialBalance = savings.getBalance();
        savings.withdraw(1000);
        assertEquals(initialBalance, savings.getBalance());
    }

    @Test
    public void testPrintAccountDetails() {
        savings.printAccountDetails();
    }
}
