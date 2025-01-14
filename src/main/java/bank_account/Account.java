package bank_account;

public class Account {
    protected float balance;
    protected int numDeposits = 0;
    protected int numWithdrawals = 0;
    protected float annualInterest;
    protected float monthlyCommission = 0;

    public Account(float balance, float annualInterest) {
        this.balance = balance;
        this.annualInterest = annualInterest;
    }

    public void deposit(float amount) {
        this.balance += amount;
        numDeposits++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            this.balance -= amount;
            numWithdrawals++;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterest = (balance * annualInterest) / 12;
        balance += monthlyInterest;
    }

    public void generateMonthReport() {
        calculateMonthlyInterest();
        this.balance -= monthlyCommission;
    }

    public void print() {
        System.out.println("Balance: " + balance);
        System.out.println("Monthly Commission: " + monthlyCommission);
        System.out.println("Number of Transactions: " + (numDeposits + numWithdrawals));
    }
}

