package Bank1;

import java.time.LocalDateTime;
import java.time.LocalDate;


public class CurrentAccount extends Account{
	
	private final double withdrawalLimit = 50000;
	private double totalWithdrawnToday = 0.0;
	private LocalDate lastWithdrawalDate = null; 
	public CurrentAccount(long accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
	}
	
	@Override
	void withdraw(double amount) {
		
		 LocalDate today = LocalDate.now();

	        // Reset total withdrawn if it's a new day
	        if (lastWithdrawalDate == null || !lastWithdrawalDate.equals(today)) {
	            totalWithdrawnToday = 0.0;
	            lastWithdrawalDate = today;
	        }
	        
	        if (totalWithdrawnToday + amount > withdrawalLimit) {
	            System.out.println("Daily limit of ₹50,000 exceeded. Try again tomorrow.");
	            return;
	        }
	        
			if(getBalance() >= amount) {
			setBalance(getBalance() - amount);
		      setLastWithdrawalTime(LocalDateTime.now());
		      totalWithdrawnToday += amount;
		      System.out.println("** RECEIPT **");
	            System.out.printf("New Balance is: Rs%.2f\n", getBalance());
	            System.out.println("Withdrawal Time: " + getLastWithdrawalTime());
			}
		else {System.out.println("Insufficient funds");}
	}
	
	
	//function for daily withdrawal limit.
	


}
