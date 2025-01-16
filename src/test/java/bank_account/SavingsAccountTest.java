package bank_account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(10000, 0.06f);
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(10500, account.balance);
        assertEquals(1, account.numDeposit);
    }

    @Test
    void testDepositInactiveAccount() {
        account = new SavingsAccount(5000, 0.06f);
        account.deposit(500);
        assertEquals(5000, account.balance);
        assertEquals(0, account.numDeposit);
    }

    @Test
    void testWithdraw() {
        account.withdraw(500);
        assertEquals(9500, account.balance);
        assertEquals(1, account.numWithdraw);
    }

    @Test
    void testWithdrawInactiveAccount() {
        account = new SavingsAccount(5000, 0.06f);
        account.withdraw(500);
        assertEquals(5000, account.balance);
        assertEquals(0, account.numWithdraw);
    }

   @Test
    void testGenMonthReport() {
        account.deposit(500); // 10500 without interest yet
        assertEquals(10500, account.balance);
        account.genMonthReport(); // 10552.5 with interest
        assertEquals(10552.5f, account.balance);

        for (int i=0; i<=3; i++) {
            account.withdraw(200); // -800
        }
        assertEquals(9752.5f, account.balance); // balance < 10000 = !isActive
        assertEquals(1, account.numDeposit);
        assertEquals(4, account.numWithdraw);
    }

    @Test
    void testGenMonthReport5Withdraws() {
        account.deposit(5000);
        assertEquals(15000, account.balance);

        for (int i=0; i<=4; i++) {
            account.withdraw(200); // -1000
        }
        assertEquals(14000, account.balance);

        account.genMonthReport(); // interest from 14000=70, -1000 extra for 5th withdraw
        assertEquals(13070, account.balance);

        assertEquals(1, account.numDeposit);
        assertEquals(5, account.numWithdraw);
    }

}

