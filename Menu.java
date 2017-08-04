 /**
@author Ming Ni
@version 1.0

COP5007 Exam 1
File Name: Exam1ProgramDriver.java
*/

public abstract class Menu {
	/**
	Handle user's input for this menu.
	*/
	public abstract boolean listenerUserInput();

	/**
	Print the prompt message for this menu.
	*/
	public abstract void printPromptMessage();

	/**
	Print out the object.
	*/
	public void print(Object o) {
		System.out.println(o);
	}
}
