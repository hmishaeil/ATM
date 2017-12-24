package com.tala.atm;

import java.util.Scanner;

/*
 * Defining needed common elements which are used in multiple classes.
 * 
 */
public final class Common {

	public static int balance_amount = 1000;

	public static long now;

	public static Scanner reader = new Scanner(System.in);

	public static boolean runApplicationFlag = true;

	/*
	 * 24 hours * 60 minutes * 60 seconds
	 */
	public static final int SECONDS_OF_A_DAY = 86400;

	public static final int MAX_DEPOSIT_AMOUNT_PER_DAY = 150000;
	public static final int MAX_DEPOSIT_PER_TRANSACTION = 40000;
	public static final int MAX_DEPOSIT_FREQUENCY = 4;

	public static final int MAX_WITHDRAWAL_PER_DAY = 50000;
	public static final int MAX_WITHDRAWAL_PER_TRANSACTION = 20000;
	public static final int MAX_WITHDRAWAL_FREQUENCY = 3;

	public static final String INVALID_OPTION_WARNING = "Invalid option.";

	public static final String BALANCE_AMOUNT_INFO = "Your balance amount is: ";
	public static final String NEW_BALANCE_AMOUNT_INFO = "Your new balance amount is: ";

	public static final String GET_DEPOSIT_AMOUNT_MSG = "Enter your deposit amount: ";
	public static final String EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_DAY_WARNING = "You exceeded the limit of 150k for transactions per day.";
	public static final String EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING = "You exceeded the limit of 40k per deposit transaction.";
	public static final String EXCEEDED_MAX_DEPOSIT_FREQUENCY_PER_DAY_WARNING = "You exceeded the limit of 4 deposit transactions per day.";

	public static final String GET_WITHDRAWAL_AMOUNT_MSG = "Enter your withdrawal amount: ";
	public static final String EXCEEDED_MAX_WITHDRAWAL_FREQUENCY_PER_DAY_WARNING = "You exceeded the limit of 3 withdrawal transactions per day.";
	public static final String EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_TRANSACTION_WARNING = "The withdrawal amount should be less than 20k in each try.";
	public static final String EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_DAY_WARNING = "You exceeded the maximum withdrawal amount of 50k for today. Try tommorrow.";
	public static final String INVALID_WITHDRAWAL_AMOUNT_WARNING = "The withdrawal amount is greater than current balance.";

	public static final String EXIT_MSG = "Are you sure to exit? (y/n)";
	public static final String INVALID_EXIT_ANSWER_WARNING = "Please enter y or n to continue or exit the program.";

	public static final String CONTINUING_MSG = "Continuing...";
	public static final String COMPLETED_MSG = "Completed!";

}
