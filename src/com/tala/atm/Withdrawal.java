package com.tala.atm;

import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_DAY_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_TRANSACTION_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_FREQUENCY_PER_DAY_WARNING;
import static com.tala.atm.Common.GET_WITHDRAWAL_AMOUNT_MSG;
import static com.tala.atm.Common.INVALID_WITHDRAWAL_AMOUNT_WARNING;
import static com.tala.atm.Common.MAX_WITHDRAWAL_FREQUENCY;
import static com.tala.atm.Common.MAX_WITHDRAWAL_PER_DAY;
import static com.tala.atm.Common.MAX_WITHDRAWAL_PER_TRANSACTION;
import static com.tala.atm.Common.NEW_BALANCE_AMOUNT_INFO;
import static com.tala.atm.Common.SECONDS_OF_A_DAY;
import static com.tala.atm.Common.balance_amount;
import static com.tala.atm.Common.now;
import static com.tala.atm.Common.reader;

import java.time.Instant;
/*
 * Implementing the required functions to withdraw the user amount from the account.
 * There are the below specification for withdrawal functionality,
 * 
 * - Max withdrawal for the day = 50K
 * - Max withdrawal per transaction = 20K
 * - Max withdrawal frequency = 3
 * - Cannot withdraw when balance is less than withdrawal amount
 *  
 */
public class Withdrawal {

	private long firstSuccessfulWithdrawalTime = 0;
	private int userInputWithdrawalAmount = 0;
	private int withdrawalFrequencyCounter = 0;
	private int todayWithdrawalAmount = 0;

	public String run(boolean getInputFromUser, int withdrawalAmount) {
		now = Instant.now().getEpochSecond();
		if (withdrawalFrequencyCounter < MAX_WITHDRAWAL_FREQUENCY) {
			if (getInputFromUser) {
				System.out.println(GET_WITHDRAWAL_AMOUNT_MSG);
				userInputWithdrawalAmount = reader.nextInt();
			} else {
				userInputWithdrawalAmount = withdrawalAmount;
			}

			if (userInputWithdrawalAmount <= balance_amount) {
				if (userInputWithdrawalAmount <= MAX_WITHDRAWAL_PER_TRANSACTION) {
					if (now - firstSuccessfulWithdrawalTime <= SECONDS_OF_A_DAY) {
						if (withdrawalFrequencyCounter == 0) {
							firstSuccessfulWithdrawalTime = Instant.now().getEpochSecond();
						}
						todayWithdrawalAmount += userInputWithdrawalAmount;
						if (todayWithdrawalAmount > MAX_WITHDRAWAL_PER_DAY) {
							return (EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_DAY_WARNING);
						} else {
							withdrawalFrequencyCounter++;
							balance_amount -= userInputWithdrawalAmount;
							return (NEW_BALANCE_AMOUNT_INFO + balance_amount);
						}

					} else {
						withdrawalFrequencyCounter = 1;
						firstSuccessfulWithdrawalTime = Instant.now().getEpochSecond();
						balance_amount -= userInputWithdrawalAmount;
						todayWithdrawalAmount += userInputWithdrawalAmount;
						return (NEW_BALANCE_AMOUNT_INFO + balance_amount);
					}
				} else {
					return (EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_TRANSACTION_WARNING);
				}
			} else {
				return (INVALID_WITHDRAWAL_AMOUNT_WARNING);
			}
		} else {
			return (EXCEEDED_MAX_WITHDRAWAL_FREQUENCY_PER_DAY_WARNING);
		}
	}
}
