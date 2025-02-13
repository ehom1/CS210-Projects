// Eric Hom
// Project #3
// October 30, 2024

public abstract class BankAccount 
{
	private int accountNumber; // instance variables 
	private String accountType;
	private double balance;
	
	public BankAccount(int accountNumber, String accountType, double balance) // constructor 
	{
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public double getBalance() // getter method for balance
	{
		return balance;
	}
	
	public void setBalance(double balance) // setter method for balance
	{
		this.balance = balance;
	}
	
	public int getAccountNumber() // getter method for account number 
	{
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) // setter method for account number 
	{
		this.accountNumber = accountNumber;
	}
	
	public boolean deposit(double value) // deposit method
	{
		if (value > 0)
		{
			balance += value;
			return true;
		}
		return false;
	}
	
	public abstract boolean withdraw(double amount); // abstract withdraw method that creates a blueprint for implementation in the other classes
	
	public String getAccountType() // getter method for account type 
	{
		return accountType;
	}
	
	public String toString() // create a toString method to call in Bank class to display all bank accounts
	{
		String output = "Account Number: " + accountNumber + "\nAccount Type: " + accountType + "\nBalance: " + String.format("%.2f", balance) + "\n";
		return output;
		
	} 
}
