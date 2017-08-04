 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: UserMenu.java
*/

import java.util.Scanner;

public class UserMenu extends Menu {
	/**
	The account in this menu. 
	*/
	private BankAccount account;
	
	/**
	Parameterized constructor that accepts BankAccount
	* @param val
	*/
	UserMenu(BankAccount val) {
		this.account = val;
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
				print("Please enter a new blance");
				input = scan.nextLine();
				Double val = null;
				try {
					val = Double.parseDouble(input);
				} catch (NumberFormatException e) {
					print(input + " is not a valid double number");
				}
				account.setBalance(val);
				break;
			case "2":
				print("Please enter a new anual interest rate");
				input = scan.nextLine();
				val = null;
				try {
					val = Double.parseDouble(input);
				} catch (NumberFormatException e) {
					print(input + " is not a valid double number");
				}
				account.setAnnualInterestRate(val);
				break;
			case "3":
				print("Please enter a withdraw amount");
				input = scan.nextLine();
				val = null;
				try {
					val = Double.parseDouble(input);
				} catch (NumberFormatException e) {
					print(input + " is not a valid double number");
				}
				account.withdraw(val);
				break;
			case "4":
				print("Please enter a deposit amount");
				input = scan.nextLine();
				val = null;
				try {
					val = Double.parseDouble(input);
				} catch (NumberFormatException e) {
					print(input + " is not a valid double number");
				}
				account.deposit(val);
				break;
			case "5":
				break menuLoop;
			default:
				print(input + " is not supported, please enter number from 1 to 5");
			}
		}
		return false;
	}

	/**
	Print the prompt message for this menu.
	*/
	@Override
	public void printPromptMessage() {
		String message = "\n---------------User Menu--------------\nID: " + account.getID() + ", Balance: " + account.getBalance() + ", Annual Interest Rate" + account.getAnnualInterestRate() + ", Monthly Interest Rate" + account.getMonthlyInterestRate()
				+ "\n\n"
				+ "1. Set Balance\n2. Set Annual Interest Rate\n3. Withdraw\n4. Deposit\n5. Return to Account Menu\n" + "Please enter a number for one of the options given above:\n";
		print(message);
	}

}
