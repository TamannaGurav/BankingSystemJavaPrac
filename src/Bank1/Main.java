package Bank1;
import java.lang.System;
import java.util.Scanner;

public class Main {
	
	void createAcc(char choice, Scanner sc) {
		char lowerChoice = Character.toLowerCase(choice);
		String accChoice;
		if(lowerChoice == 'y') {
			System.out.println("Enter your choice. Savings/Current ?: ");
			accChoice = sc.nextLine().trim().toLowerCase();
			
			System.out.print("Enter Account number: ");
            long accNumber = sc.nextLong();
            sc.nextLine(); // clear buffer

            System.out.print("Enter Full Name: ");
            String fullName = sc.nextLine();

            System.out.print("Enter Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); // clear buffer

            Account acc;
            if(accChoice.equals("savings")) {
            	acc = new SavingsAccount(accNumber, fullName, balance);
            	System.out.println("Savings account created successfully");
		}else if(accChoice.equals("current")) {
			acc = new CurrentAccount(accNumber, fullName, balance);
			System.out.println("Current account created successfully");
		}
		else {
			System.out.println("Invalid account type");
			return;
		}
            
            //deposit withdraw
            
          	System.out.println("Enter deposit/withdraw. If neither required write 'no': ");
        	String actionChoice = sc.nextLine().trim().toLowerCase();
        	if(actionChoice.equals("no")) {
        		return;
        	}else if(actionChoice.equals("deposit")) {
        		System.out.println("Enter Amount: ");
        		double amt = sc.nextDouble();
        		sc.nextLine(); // consume leftover newline
        		acc.deposit(amt);
        	}else if(actionChoice.equals("withdraw")){
        		System.out.println("Enter Amount: ");
        		double amt = sc.nextDouble();
        		sc.nextLine(); // consume leftover newline
        		acc.withdraw(amt);
        	}else {
                System.out.println("Invalid action.");
            }
            
		}else {
	        System.out.print("Thank You for visiting Apna bank!");
		}
	}
	
	
	
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	        System.out.println("Welcome to Apna Bank");
	        System.out.print("Do you want to create an Account? (y/n): ");
	        char choice = sc.next().toLowerCase().charAt(0);
	        sc.nextLine();
	        Main app = new Main();
	        app.createAcc(choice, sc);
	        
	        sc.close();
	        
	}
}
