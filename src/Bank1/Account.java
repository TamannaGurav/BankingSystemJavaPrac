package Bank1;
import java.time.LocalDateTime;

public class Account {
	
	private long accountNumber;
	private String accountHolder;
	private double balance;
	
	private LocalDateTime lastDepositTime;
	private LocalDateTime lastWithdrawalTime;
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(long accountNumber, String accountHolder) {
		super();
		this.setAccountNumber(accountNumber);
		this.setAccountHolder(accountHolder);
		balance = 0;
	}
	
	public Account(long accountNumber, String accountHolder, double balance) {
		super();
		this.setAccountNumber(accountNumber);
		this.setAccountHolder(accountHolder);
		this.balance = balance;
	}
	
	void deposit(double amount) {
		balance += amount;
		lastDepositTime = LocalDateTime.now();
		 System.out.println("** RECEIPT **");
	        System.out.printf("New Balance is: Rs%.2f\n", balance);
	        System.out.println("Deposit Time: " + lastDepositTime);		
	}
	
	void withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
		      lastWithdrawalTime = LocalDateTime.now();
		      System.out.println("** RECEIPT **");
	            System.out.printf("New Balance is: Rs%.2f\n", balance);
	            System.out.println("Withdrawal Time: " + lastWithdrawalTime);
		}else {
			System.out.println("Insufficient funds");
		}
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public LocalDateTime getLastDepositTime() {
		return lastDepositTime;
	}

	public void setLastDepositTime(LocalDateTime lastDepositTime) {
		this.lastDepositTime = lastDepositTime;
	}

	public LocalDateTime getLastWithdrawalTime() {
		return lastWithdrawalTime;
	}

	public void setLastWithdrawalTime(LocalDateTime lastWithdrawalTime) {
		this.lastWithdrawalTime = lastWithdrawalTime;
	}
	
	

}
