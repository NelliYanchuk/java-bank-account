package bank_account;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        overdraft = 0;
    }

    // Getter for overdraft
    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            overdraft += (amount - balance);
            balance = 0;
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft = overdraft - amount;
                amount = 0;
            }
        }
        super.deposit(amount);

    }

    @Override
    public void genMonthReport() {
        super.genMonthReport();
    }

    @Override
    public void printAccount() {
        System.out.println("Account balance: " + balance);
        System.out.println("Monthly commission: " + monthCommission);
        System.out.println("Transactions quantity: " + (numDeposit + numWithdraw));
        System.out.println("Overdraft: " + overdraft);
    }
}
