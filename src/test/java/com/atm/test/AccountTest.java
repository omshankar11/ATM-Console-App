package com.atm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.atm.model.Account;

/**
 * Unit tests for the Account class.
 */
public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account(123456, 1111, 5000.00);
    }

    @Test
    public void testAccountCreation() {
        assertEquals(123456, account.getAccountNumber());
        assertEquals(1111, account.getPin());
        assertEquals(5000.00, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(500.00);
        assertEquals(5500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        boolean result = account.withdraw(1000.00);
        assertTrue(result);
        assertEquals(4000.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(6000.00);
        assertFalse(result);
        assertEquals(5000.00, account.getBalance(), 0.01);
    }

    @Test
    public void testNegativeDeposit() {
        account.deposit(-500.00);
        assertEquals(5000.00, account.getBalance(), 0.01);
    }

    @Test
    public void testNegativeWithdraw() {
        boolean result = account.withdraw(-500.00);
        assertFalse(result);
        assertEquals(5000.00, account.getBalance(), 0.01);
    }
}
