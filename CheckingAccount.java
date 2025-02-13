// Eric Hom
// Project #3
// October 30, 2024

public class CheckingAccount extends BankAccount // inherits all methods and properties of BankAccount class
{
	private double overDraftLimit;
	
	public CheckingAccount(int accountNumber, String accountType, double balance, double overDraftLimit)
	{
		super(accountNumber, accountType, balance); // accessing class from BankAccount
		this.overDraftLimit = overDraftLimit;
	}
	
	public double getOverDraftLimit() // getter method for overdraft limit
	{
		return overDraftLimit;
	}
	
    public boolean withdraw(double amount)  // overriding withdraw method from BankAccount
    {
        if (getBalance() + overDraftLimit >= amount) 
        {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
    
    public String toString() // overriding toString method that also adds the overdraft limit when displaying info for checking accounts
    {
    	String output = super.toString() + "Overdraft Limit: " + String.format("%.2f", overDraftLimit) + "\n";
    	return output;
    }
}
