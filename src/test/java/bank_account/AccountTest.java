package bank_account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testCalcMonthInterest() {
        Account account = new Account(1000, 0.06f);
        account.calcMonthInterest();
        assertEquals(1005, account.balance, 0.001);
    }

    @Test
    void testDeposit() {
        Account account = new Account(1000, 0.06f);
        account.deposit(500);
        assertEquals(1500, account.balance);
        assertEquals(1, account.numDeposit);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1000, 0.06f);
        account.withdraw(400);
        assertEquals(600, account.balance);
        assertEquals(1, account.numWithdraw);
    }

    @Test
    void testWithdrawNotEnoughMoney() {
        Account account = new Account(500, 0.06f);
        account.withdraw(600);
        assertEquals(500, account.balance);
        assertEquals(0, account.numWithdraw);
    }

    @Test
    void testGenMonthReport() {
        Account account = new Account(1500, 0.02f);
        account.genMonthReport();
        assertEquals(1502.5f, account.balance);
    }

    @Test
    void testPrintAccount() {
        Account account = new Account(1000, 0.06f);
        account.deposit(500);
        account.withdraw(200);
        account.printAccount();
    }
}
