 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: AccountsMenu.java
*/

import java.util.Scanner;

public class AccountsMenu extends Menu {
	/**
	The accounts array. 
	*/
	private BankAccount[] accounts;

	/**
	The number of valid account. 
	*/
	private int numberOfValidAccount;

	/**
	Parameterized constructor that accepts BankAccount array
	* @param vals
	*/
	AccountsMenu(BankAccount[] vals) {
		this.accounts = vals;
		updateNumberOfValidHotels();
	}

	/**
	Update updateNumberOfValidHotels
	*/
	private void updateNumberOfValidHotels() {
		BankAccount[] hotels = accounts;
		for (int i = 0; i < hotels.length; i++) {
			if (hotels[i] == null) {
				break;
			} else {
				numberOfValidAccount = i + 1;
			}
		}
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
			int opt;
			try {
				opt = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				print(input + " is not a valid integer number");
				return false;
			}

			if (opt <= numberOfValidAccount) {
				/*
				Go to User Menu
				*/
				new UserMenu(accounts[opt - 1]).listenerUserInput();
			} else if (opt == numberOfValidAccount + 1) {
				/*
				Exit.
				*/
				break menuLoop;
			} else {
				print(opt + " is not supported, please enter number from 1 to " + numberOfValidAccount + 1);
			}

		}
		return false;
	}

	/**
	Print the prompt message.
	*/
	@Override
	public void printPromptMessage() {
		String message = "";
		int counter = 1;
		for (BankAccount account : accounts) {
			if (account == null) {
				break;
			}
			message += (counter++ + ". Account ID " + account.getID() + ", type: " + account.getAccountType() + "\n");
		}
		message += counter++
				+ ". Return to Bank menu\n\n" + "Please enter a number for one of the options given above:\n";
		print("\n-------------Account Menu----------------\n" + message);
	}
}
