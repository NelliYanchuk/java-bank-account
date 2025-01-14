package bank_account;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float balance, float annualInterest) {
        super(balance, annualInterest);
        checkActive();
    }

    private void checkActive() {
        isActive = (balance >= 10000);
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
        } else {
            System.out.println("Account is inactive.");
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive) {
            super.withdraw(amount);
        } else {
            System.out.println("Account is inactive.");
        }
    }

    @Override
    public void genMonthReport() {
        super.genMonthReport();
        if (numWithdraw > 4) {
            monthCommission += 1000 * (numWithdraw - 4);
        }
        this.balance -= monthCommission;
        checkActive();
    }

    @Override
    public void printAccount() {
        System.out.println("Account balance: " + balance);
        System.out.println("Monthly commission: " + monthCommission);
        System.out.println("Transactions quantity: " + (numDeposit + numWithdraw));
    }
}