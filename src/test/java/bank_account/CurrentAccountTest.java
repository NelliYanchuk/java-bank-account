package bank_account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount(1000, 0.06f);
    }

    @Test
    void testWithdraw() {

        assertEquals(1000, account.balance);
        assertEquals(0, account.getOverdraft());

        account.withdraw(1000);
        assertEquals(0, account.balance);
        assertEquals(0, account.getOverdraft());

        account.withdraw(200);
        assertEquals(0, account.balance);
        assertEquals(200, account.getOverdraft());
    
    }

    @Test
    void testDeposit() {
        assertEquals(1000, account.balance);

        account.withdraw(1500); //overdraft = 500
        assertEquals(0, account.balance);
        assertEquals(500, account.getOverdraft());
        
        account.deposit(400); //overdraft = 100
        assertEquals(0, account.balance);
        assertEquals(100, account.getOverdraft());
    }

    @Test
    void testWithdrawLessThanBalance() {
        account.withdraw(500);
        assertEquals(500, account.balance);
        assertEquals(0, account.getOverdraft());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        account.withdraw(1500);
        assertEquals(0, account.balance);
        assertEquals(500, account.getOverdraft());
    }

    @Test
    void testWithdrawExactlyBalance() {
        account.withdraw(1000);
        assertEquals(0, account.balance);
        assertEquals(0, account.getOverdraft());
    }

    @Test
    void testWithdrawMoreThanBalanceAndOverdraft() {
        account.withdraw(2000);
        assertEquals(0, account.balance);
        assertEquals(1000, account.getOverdraft());
    }

    @Test
    void testGenMonthReport() {
        account.deposit(1000);
        account.withdraw(500);
        account.genMonthReport();
        assertEquals(1500, account.balance);
        assertEquals(0, account.getOverdraft());
    }

    @Test
    void testPrintAccount() {
        account.deposit(1000);
        account.withdraw(500);
        account.printAccount();
    }
}
