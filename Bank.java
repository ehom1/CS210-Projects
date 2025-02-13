// Eric Hom
// Project #3
// October 30, 2024

import java.util.*;

public class Bank 
{
	private static int nextAccountNumber = 1000;
	private static final int MAX_ACCOUNTS = 10;
    private static BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS]; // Array to store accounts
    private static int numOfAccounts = 0;
	
	public static void main (String[] args)
	{
		int choice;
		Scanner user = new Scanner(System.in);
	
		do { // do while loop that gives the user options until they exit by choosing option 5
			System.out.print("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display All Accounts\n5. Exit\nChoose an option: ");
			choice = user.nextInt();
			
			switch (choice) // switch statements for the menu loop 
			{
				case 1: // adding an account 
				    if (numOfAccounts >= MAX_ACCOUNTS) // error case if the maximum number of accounts is created 
				    {
				        System.out.println("Error: The bank has reached the maximum number of accounts. No more accounts can be created.");
				        continue; // Skip to the next loop iteration
				    }
					while (!isBankAccountUnique(accounts, numOfAccounts, nextAccountNumber)) // makes sure that the next account number is unique using the unique account method 
					{
                        nextAccountNumber++;
                    }
			        System.out.print("Enter 'S' for Saving Account or 'C' for Checking Account: "); // asks user for either a savings or checking account 
			        char accountType = user.next().charAt(0);
			        
			        BankAccount newAccount;
			        if (accountType == 'S' || accountType == 's') // creating savings account if user chooses saving
			        {
				        System.out.print("Enter initial balance: ");
				        double balance = user.nextDouble();
			            newAccount = new SavingAccount(nextAccountNumber, "Saving", balance);
			        } 
			        else if (accountType == 'C' || accountType == 'c') // creates checking account if user chooses checking 
			        {
				        System.out.print("Enter initial balance: ");
				        double balance = user.nextDouble();
			            System.out.print("Enter overdraft limit: ");
			            double overdraftLimit = user.nextDouble();
			            newAccount = new CheckingAccount(nextAccountNumber, "Checking", balance, overdraftLimit);
			        } 
			        else // error case neither savings or checking account is selected 
			        {
			            System.out.println("Invalid account type.");
			            continue;
			        }
			        
                    numOfAccounts = addAccount(accounts, numOfAccounts, newAccount); // saving the new account by calling the add account method 
                    if (numOfAccounts > 0 && numOfAccounts <= MAX_ACCOUNTS) // prints feedback message if the account is successfully created 
                    {
                        System.out.println("Account created successfully. Account Number: " + nextAccountNumber);
                    }
                    
                    nextAccountNumber++; // Increment the account number for the next account
					break;
					
				case 2: // depositing from a bank account 
					System.out.print("Enter your bank account number: ");
					int depositAccountNumber = user.nextInt();
					System.out.print("Enter the amount you wish to deposit: ");
					double depositAmount = user.nextDouble();
					
					deposit(accounts, numOfAccounts, depositAccountNumber, depositAmount); // calling the deposit method 
					
					break;
					
				case 3: // withdrawing from a bank account 
					System.out.print("Enter your bank account number: ");
					int withdrawAccountNumber = user.nextInt();
					System.out.print("Enter the amount you wish to withdraw: ");
					double withdrawAmount = user.nextDouble();
					
					withdraw(accounts, numOfAccounts, withdrawAccountNumber, withdrawAmount); // calling the withdraw method 
					
					break;
					
				case 4: // displaying all the accounts created 
					displayAllAccounts(accounts, nextAccountNumber); // calling the display all accounts method 
					break;
					
				case 5: // exiting the loop 
					System.exit(0);
					
				default: // error case if one of the five choices are not selected 
					System.out.println("Invalid choice, please try again.");
			}
		}
		while (choice != 5); 
		
		user.close();
	}
	
	public static int addAccount(BankAccount[] accounts, int numOfAccounts, BankAccount newAccount) 
	{  
		accounts[numOfAccounts] = newAccount; // adding accounts to an array of bank accounts
		return ++numOfAccounts; // adds up the number of accounts created 
	}
	
	public static void deposit(BankAccount[] accounts, int numOfAccounts, int nextAccountNumber, double amount) 
	{
		if (amount <= 0) // error case if deposit amount is less than or equal to 0
		{
			System.out.print("Deposit amount must be greater than 0.\n");
			return;
		} 
		
        for (int i = 0; i < numOfAccounts; i++)
        {
            if (accounts[i].getAccountNumber() == nextAccountNumber) 
            {
	            // Check if withdrawal is successful
	            boolean success = accounts[i].deposit(amount);
	            if (success) 
	            {
	                System.out.println("Deposit successful! New balance: " + accounts[i].getBalance() + "\n"); // feedback message if the deposit is successful
	            }
	            else
	            {
	                System.out.println("Deposit unsuccessful. Deposit amount must be greater than 0.\n"); // feedback message if the deposit is unsuccessful
	            }
                return;
            }
        }
        System.out.println("Account number " + nextAccountNumber + " not found.\n"); // feedback message if account number is not found  
	}
	
	public static void withdraw(BankAccount[] accounts, int numOfAccounts, int nextAccountNumber, double amount)
	{
		if (amount <= 0) // error case if withdraw amount is less than or equal to 0
		{
			System.out.print("Withdraw must be greater than 0.\n");
			return;
		}
		
	    for (int i = 0; i < numOfAccounts; i++) 
	    {
	        if (accounts[i].getAccountNumber() == nextAccountNumber) 
	        {
	            // check if withdrawal is successful
	            boolean success = accounts[i].withdraw(amount);
	            if (success) 
	            {
	                System.out.println("Withdrawal successful! New balance: " + accounts[i].getBalance() + "\n"); // feedback message if withdraw is successful
	            } 
	            else 
	            {
	                System.out.println("Withdrawal unsuccessful. Overdraft limit exceeded or insufficient balance.\n"); // feedback message if withdraw is unsuccessful
	            }
	            return;  // exit the method after processing the correct account
	        }
	    }
        System.out.println("Account number " + nextAccountNumber + " not found."); 
	}
	
	public static void displayAllAccounts(BankAccount[] accounts, int nextAccountNumber)
	{
        System.out.println("Displaying all accounts:");
        for (int i = 0; i < numOfAccounts; i++) 
        {
            System.out.println(accounts[i].toString()); // calls the override toString method to print out details of each account created 
        }
	}
	
	public static boolean isBankAccountUnique(BankAccount[] accounts, int numOfAccounts, int nextAccountNumber)
	{
	    for (int i = 0; i < numOfAccounts; i++) // checks if each bank account is a unique number 
	    {
	        if (accounts[i].getAccountNumber() == nextAccountNumber) 
	        {
	            return false; // Account number is not unique
	        }
	    }
	    return true;
	}
}