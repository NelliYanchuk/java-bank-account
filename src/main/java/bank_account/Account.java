package bank_account;

public class Account {
    protected float balance;
    protected int numDeposit = 0;
    protected int numWithdraw = 0;
    protected float annualInterest;
    protected float monthCommission = 0;

    public Account(float balance, float annualInterest) {
        this.balance = balance;
        this.annualInterest = annualInterest;
    }

    public void deposit(float amount) {
        this.balance += amount;
        numDeposit++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            this.balance -= amount;
            numWithdraw++;
        } else {
            System.out.println("There is not enough money to withdraw.");
        }
    }

    public void calcMonthInterest() {
        float monthInterest = (balance * annualInterest) / 12;
        balance += monthInterest;
    }

    public void genMonthReport() {
        calcMonthInterest();
        this.balance -= monthCommission;
    }

    public void printAccount() {
        System.out.println("Balance: " + balance);
        System.out.println("Deposits number: " + numDeposit);
        System.out.println("Withdraws number: " + numWithdraw);
        System.out.println("Annual interest: " + annualInterest);
        System.out.println("Monthly commission: " + monthCommission);
    }
}
