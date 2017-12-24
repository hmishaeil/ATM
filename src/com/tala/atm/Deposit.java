package com.tala.atm;

import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_DAY_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_FREQUENCY_PER_DAY_WARNING;
import static com.tala.atm.Common.GET_DEPOSIT_AMOUNT_MSG;
import static com.tala.atm.Common.MAX_DEPOSIT_AMOUNT_PER_DAY;
import static com.tala.atm.Common.MAX_DEPOSIT_FREQUENCY;
import static com.tala.atm.Common.MAX_DEPOSIT_PER_TRANSACTION;
import static com.tala.atm.Common.NEW_BALANCE_AMOUNT_INFO;
import static com.tala.atm.Common.SECONDS_OF_A_DAY;
import static com.tala.atm.Common.balance_amount;
import static com.tala.atm.Common.now;
import static com.tala.atm.Common.reader;

import java.time.Instant;

/*
 * Implementing the Deposit functionality
 * 
 * There are below limitations for user to deposit the amount
 * - Max deposit for the day = 150K
 * - Max deposit per transaction = 40K
 * - Max deposit frequency = 4
 * 
 */
public class Deposit {

	private int userInputDepositAmount = 0;
	private int todayDepositAmount = 0;
	private int depositFrequencyCounter = 0;
	private long firstSuccessfulDepositTime = 0;

	public String run(boolean getInputFromUser, int depositAmount) {
		now = Instant.now().getEpochSecond();
		if (now - firstSuccessfulDepositTime < SECONDS_OF_A_DAY) {
			if (depositFrequencyCounter < MAX_DEPOSIT_FREQUENCY) {
				if (getInputFromUser) {
					System.out.println(GET_DEPOSIT_AMOUNT_MSG);
					userInputDepositAmount = reader.nextInt();
				} else {
					userInputDepositAmount = depositAmount;
				}

				if (userInputDepositAmount <= MAX_DEPOSIT_PER_TRANSACTION) {
					todayDepositAmount += userInputDepositAmount;
					if (todayDepositAmount > MAX_DEPOSIT_AMOUNT_PER_DAY) {
						return (EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_DAY_WARNING);
					} else {
						balance_amount += userInputDepositAmount;
						depositFrequencyCounter++;
						return (NEW_BALANCE_AMOUNT_INFO + balance_amount);
					}
				} else {
					return (EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING);
				}
			} else {
				return (EXCEEDED_MAX_DEPOSIT_FREQUENCY_PER_DAY_WARNING);
			}
		} else {
			if (getInputFromUser) {
				System.out.println(GET_DEPOSIT_AMOUNT_MSG);
				userInputDepositAmount = reader.nextInt();
			} else {
				userInputDepositAmount = depositAmount;
			}
			if (userInputDepositAmount <= MAX_DEPOSIT_PER_TRANSACTION) {
				firstSuccessfulDepositTime = Instant.now().getEpochSecond();
				depositFrequencyCounter = 1;
				balance_amount += userInputDepositAmount;
				todayDepositAmount = 0;
				todayDepositAmount += userInputDepositAmount;
				return (NEW_BALANCE_AMOUNT_INFO + balance_amount);
			} else {
				return (EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING);
			}
		}
	}
}
