// Eric Hom
// Project #3
// October 30, 2024

public class SavingAccount extends BankAccount // inherits all methods and properties of BankAccount class
{
	private static double interestRate = 2.5; // 2.5%
	
	public SavingAccount(int accountNumber, String accountType, double balance)
	{
		super(accountNumber, accountType, balance); // accessing class from BankAccount
	}
	
	public void applyInterestRate() // sets the balance to have interest rate included
	{
        setBalance(getBalance() + calculateInterest());
	}
	
	public double calculateInterest() // calculating the interest rate 
	{
		return getBalance() * (interestRate / 100);
	}
	
	public boolean withdraw(double amount) // ovveriding withdraw method from BankAccount 
	{
		if (getBalance() >= amount)
		{
			setBalance(getBalance() - amount);
			return true;
		}
		return false;
	}
	
	public String toString() // overriding toString method that also adds the interest rate when displaying info for savings accounts
	{
    	String output = super.toString() + "Interest Rate: " + String.format("%.2f", interestRate) + "%\n";
    	return output;
	}
}
