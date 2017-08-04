 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: CheckingAccount.java
*/

public class CheckingAccount extends BankAccount {
	/**
	The overdraft limit amount .
	*/
	private static double overdraftLimitAmount;
	
	/**
	The overdraft fine amount .
	*/
	private static double overdraftFine;
	
	/**
	Default contractor.
	*/
	CheckingAccount() {
		super();
		setAccountType(AcountType.Checking);
	}

	/**
	Set the setOverdraftFine.
	* @param val
	*/
	public static void setOverdraftFine(double val) {
		overdraftFine = val;
	}
	
	/**
	Get the overdraftFine of account.
    * @return overdraftFine
	*/
	public double getAbleToOverdraft() {
		return overdraftFine;
	}
	
	/**
	Set the overdraftLimitAmount.
	* @param val
	*/
	public static void setOverdraftLimitAmount(double val) {
		overdraftLimitAmount = val;
	}
	
	/**
	Get the overdraftLimitAmount of account.
	* @return overdraftLimitAmount
	*/
	public static double getOverdraftLimitAmount() {
		return overdraftLimitAmount;
	}
	
	/**
	Get the overdraftFine of account.
    * @return overdraftFine
	*/
	public static double getOverdraftFine() {
		return overdraftFine;
	}
	
	/**
	Withdraw from balance.
    * @param amount
	*/
	@Override
	public boolean withdraw(double amount) {
		if (getBalance() < amount) {
			if (getBalance() + overdraftLimitAmount < amount) {
				return false;
			}
			setBalance(getBalance() - amount - overdraftFine);
			return true;
		}
		setBalance(getBalance() - amount);
		return true;
	}
}
