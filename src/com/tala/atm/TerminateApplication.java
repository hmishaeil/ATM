package com.tala.atm;

import static com.tala.atm.Common.COMPLETED_MSG;
import static com.tala.atm.Common.CONTINUING_MSG;
import static com.tala.atm.Common.EXIT_MSG;
import static com.tala.atm.Common.INVALID_EXIT_ANSWER_WARNING;
import static com.tala.atm.Common.reader;
import static com.tala.atm.Common.runApplicationFlag;
/*
 * Implementing the needed functions to terminate the application properly
 * There is below specification to quit the application,
 * - to ask to confirm to quit
 * - Data is not persist, i.e. when the user quits and restarts, data should be reset.
 * 
 */
public class TerminateApplication {
	public void run() {
		System.out.println(EXIT_MSG);
		char quit = reader.next().charAt(0);
		if (quit == 'y') {
			System.out.println(COMPLETED_MSG);
			reader.close();
			runApplicationFlag = false;
		} else if (quit == 'n') {
			System.out.println(CONTINUING_MSG);
		} else {
			System.out.println(INVALID_EXIT_ANSWER_WARNING);
		}
	}
}
