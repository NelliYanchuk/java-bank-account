package bank_account;

public class CheckingAccount extends Account {
    private float overdraft;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            balance = 0;
            overdraft += (amount - balance);
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft -= amount;
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
