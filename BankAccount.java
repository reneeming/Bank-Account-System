 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: BankAccount.java
*/

public abstract class BankAccount {
	/**
	Account's ID
	*/
	private int ID;
	
	/**
	Account's balance
	*/
	private double balance;
	
	/**
	Account's annualInterestRate
	*/
	private double annualInterestRate;
	
	
	/**
	Account's type
	*/
	private AcountType type;
	
	/**
	Account's total number
	*/
	private static int totalAcountNumber = 0;
	
	/**
	Default contractor, add one for totalAcountNumber.
	*/
	BankAccount() {
		this.ID = totalAcountNumber++;
		balance = 0;
	}
	
	/**
	Get the ID of account.
	* @return ID
	*/
	public int getID() {
		return ID;
	}
	
	/**
	withdraw method.
	*/
	public abstract boolean withdraw(double amount);
	
	/**
	Add the balance amount.
	* @param val
	*/
	public void deposit(double val) {
		this.balance += val;
	}
	
	/**
	Get the annualInterestRate of account.
	* @return annualInterestRate
	*/
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/**
	Set the annualInterestRate.
	* @param val
	*/
	public void setAnnualInterestRate(double val) {
		this.annualInterestRate = val;
	}
	
	/**
	Get the getMonthlyInterestRate of account.
	*/
	public double getMonthlyInterestRate() {
		return Math.pow(Math.E, Math.log(1 + annualInterestRate)/12) - 1;
	}
	
	/**
	Get the balance of account.
	* @return balance
	*/
	public double getBalance() {
		return balance;
	}
	
	/**
	Set the setBalance.
	* @param val
	*/
	public void setBalance(double val) {
		this.balance = val;
	}
	
	/**
	Get the type of account.
	* @return type
	*/
	public AcountType getAccountType() {
		return type;
	}
	
	/**
	Set the type of account.
	* @param val
	*/
	public void setAccountType(AcountType val) {
		this.type = val;
	}
	
	enum AcountType {
		Checking, Saving;
	}
	
}
