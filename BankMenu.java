 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: BankSystem.java
*/

import java.util.Scanner;

public class BankMenu extends Menu {
	/**
	The accounts array. 
	*/
	BankAccount[] accounts;

	/**
	Default contractor 
	*/
	BankMenu() {
		accounts = new BankAccount[2];
		accounts[0] = new CheckingAccount();
		accounts[1] = new SavingAccount();
	}

	/**
	Default contractor, creating 2 fake account.
	*/
	public void addAccount(BankAccount account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				return;
			}
		}
		BankAccount[] newAccounts = new BankAccount[2 * accounts.length];
		for (int i = 0; i < accounts.length; i++) {
			newAccounts[i] = accounts[i];
		}
		newAccounts[accounts.length] = account;
		accounts = newAccounts;
	}

	/**
	Handle user's input for this menu.
	*/
	@Override
	public boolean listenerUserInput() {
		Scanner scan = new Scanner(System.in);
		menuLoop: while (true) {
			printPromptMessage();
			String input = scan.nextLine();
			switch (input) {
			case "1":
				createNewAccount();
				break;
			case "2":
				new AccountsMenu(accounts).listenerUserInput();
				break;
			case "3":
				setWithdrawalLimit();
				break;
			case "4":
				setOverdraftFine();
				break;
			case "5":
				setOverdraftLimitAmount();
				break;
			case "6":
				break menuLoop;
			default:
				print(input + " is not supported, please enter number from 1 to 6");
			}
		}
		return false;
	}

	/**
	Create a new account to accounts array.
	*/
	private void createNewAccount() {
		Scanner scan = new Scanner(System.in);
		print("Please choice which type of account you want to create, 1 for checking and 2 for saving");
		String input = scan.nextLine();
		Integer type;
		try {
			type = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			print(input + " is not a valid integer number");
			return;
		}
		BankAccount account = null;
		if (type == 1) {
			account = new CheckingAccount();
		} else if (type == 2) {
			account = new SavingAccount();
		} else {
			print("Please only choice 1 or 2");
			return;
		}
		addAccount(account);
	}

	/**
	Set the withdraw limit for saving account.
	*/
	private void setWithdrawalLimit() {
		Scanner scan = new Scanner(System.in);
		print("Please enter the withdraw limit for saving account");
		String input = scan.nextLine();
		Integer limit;
		try {
			limit = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			print(input + " is not a valid integer number");
			return;
		}
		SavingAccount.setWithdrawLimit(limit);
		print(input + " withdraw limit is set successfully for checking account");
	}

	/**
	Set the overdraft limit amount for checking account.
	*/
	private void setOverdraftLimitAmount() {
		Scanner scan = new Scanner(System.in);
		print("Please enter the withdraw limit amount for checking account");
		String input = scan.nextLine();
		Double limit;
		try {
			limit = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			print(input + " is not a valid integer number");
			return;
		}
		CheckingAccount.setOverdraftLimitAmount(limit);
		print(input + " overdraft limit amountis set successfully for checking account");
	}
	
	/**
	Set the overdraft fine.
	*/
	public void setOverdraftFine() {
		Scanner scan = new Scanner(System.in);
		print("Please enter the overdraft fine for checking account");
		String input = scan.nextLine();
		Double fine;
		try {
			fine = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			print(input + " is not a valid double number");
			return;
		}

		CheckingAccount.setOverdraftFine(fine);
		print(input + "$ overdraft fine is set successfully for checking account");
	}

	/**
	Print the prompt message for this menu.
	*/
	@Override
	public void printPromptMessage() {
		// TODO Auto-generated method stub
		String msg = "---------Bank Menu----------\n" + "Checking Account overdraw limit/fine: " + CheckingAccount.getOverdraftLimitAmount() + "/" + CheckingAccount.getOverdraftFine() + "$, Saving account withdraw limit: " + SavingAccount.getWithDrawLimit() + "\n\n1. Create new account\n2. List all account\n3. Set saving account withdraw limit\n4. Set checking account overdraft fine\n5. Set checking account overdraft limit amount\n6. Exit Program\n\n";
		System.out.println(msg + "Please enter a number for one of the options given above:\n");
	}
}
