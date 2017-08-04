 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: SavingAccount.java
*/

public class SavingAccount extends BankAccount {
	/**
	The accounts withdrawLimit. 
	*/
	private static int withdrawLimit;
	
	/**
	The accounts withdrawCounter. 
	*/
	private int withdrawCounter;
	
	/**
	Default contractor.
	*/
	SavingAccount() {
		super();
		withdrawCounter = withdrawLimit;
		setAccountType(AcountType.Saving);
	}
	
	/**
	Get the overdraftLimitAmount of account.
    * @return withdrawLimit
	*/
	public static int getWithDrawLimit() {
		return withdrawLimit;
	}
	
	/**
	Set the withdrawLimit.
	* @param val
	*/
	public static void setWithdrawLimit(int val) {
		withdrawLimit = val;
	}
	
	/**
	Reset the withdrawCounter of account.
	*/
	public void resetWithdrawCounter() {
		withdrawCounter = withdrawLimit;
	}
	
	/**
	Withdraw from balance.
    * @param amount
	*/
	@Override
	public boolean withdraw(double amount) {
		if (getBalance() < amount || withdrawLimit <= 0) {
			return false;
		}
		setBalance(getBalance() - amount);
		withdrawLimit--;
		return true;	
	}
}
