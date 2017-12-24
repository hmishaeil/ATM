package com.tala.atm;

import static com.tala.atm.Common.reader;
import static com.tala.atm.Common.runApplicationFlag;

public class ATM {

	public static void main(String[] args) {

		int menuOption;

		/*
		 * Creating the needed objects to kick off the application
		 */
		Balance balance = new Balance();
		Deposit deposit = new Deposit();
		Withdrawal withdrawal = new Withdrawal();
		TerminateApplication terminate = new TerminateApplication();

		/*
		 * Displaying the menu options to get input from user
		 * Any input except numbers 1,2,3, and 4 is considers as invalid input.
		 * As far as the runApplicationFlag is true, the application continue running.
		 */
		do {

			menuOption = 0;

			System.out.println("____________________________________");
			System.out.println("### Choose your option from menu ###");
			System.out.println("1. Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdrawal");
			System.out.println("4. Quit");

			while (!reader.hasNextInt()) {
				reader.next();
				System.out.println("Please choose a valid menu option between 1 and 4.");
			}
			menuOption = reader.nextInt();

			switch (menuOption) {
			case 1:
				balance.show();
				break;
			case 2:
				System.out.println(deposit.run(true, 0));
				break;
			case 3:
				System.out.println(withdrawal.run(true, 0));
				break;
			case 4:
				terminate.run();
				break;
			default:
				System.out.printf("\"%s\" is not a valid menu option.\n", menuOption);
				break;
			}

		} while (runApplicationFlag);
	}
}
