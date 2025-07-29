package Bank1;
import java.time.LocalDate;

public class SavingsAccount extends Account {

    private LocalDate lastWithdrawalDate;
    private int withdrawCount = 0;

    public SavingsAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public SavingsAccount(long accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    void withdraw(double amount) {
        LocalDate currentDate = LocalDate.now();

        // Reset withdraw count if month/year has changed
        if (lastWithdrawalDate == null ||
            currentDate.getMonthValue() != lastWithdrawalDate.getMonthValue() ||
            currentDate.getYear() != lastWithdrawalDate.getYear()) {
            withdrawCount = 0;
        }

        if (withdrawCount < 3) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                lastWithdrawalDate = currentDate;
                withdrawCount++;
                System.out.println("Withdrawal Successful (No Fee)");
                System.out.printf("New balance is: Rs%.2f\n", getBalance());
                System.out.println("Monthly withdrawals so far: " + withdrawCount);
            } else {
                System.out.println("Insufficient Funds");
            }
        } else {
            double fee = 10.0;
            double totalAmount = amount + fee;
            if (getBalance() >= totalAmount) {
                setBalance(getBalance() - totalAmount);
                lastWithdrawalDate = currentDate;
                withdrawCount++;
                System.out.println("Withdrawal Successful (₹10 fee applied)");
                System.out.printf("New balance is: Rs%.2f\n", getBalance());
                System.out.println("Monthly withdrawals so far: " + withdrawCount);
            } else {
                System.out.println("Insufficient Funds");
            }
        }
    }

    public int getWithdrawCount() {
        return withdrawCount;
    }

    public LocalDate getLastWithdrawalDate() {
        return lastWithdrawalDate;
    }
}

