package com.tala.tests;

import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_DAY_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_TRANSACTION_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_WITHDRAWAL_FREQUENCY_PER_DAY_WARNING;
import static com.tala.atm.Common.INVALID_WITHDRAWAL_AMOUNT_WARNING;
import static com.tala.atm.Common.NEW_BALANCE_AMOUNT_INFO;
import static com.tala.atm.Common.balance_amount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.tala.atm.Withdrawal;

/*
 * Implementing the needed functions to test the withdraw functionality
 * We are going to test below main items:
 * - Testing regular withdraw action 
 * - Testing withdraw with greater amount than balance
 * - Testing withdrawing maximum permissible amount per day
 * - Testing withdrawing maximum permissible amount per transaction
 * - Testing withdrawal frequency per day (which is 3 times)
 * 
 */

class TestWithdrawal {

	private String str;
	private int amountToWithdraw = 1;

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("______________________________________________________________________");
	}

	@Test
	void testDoWithdrawal() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		balance_amount = 1;
		amountToWithdraw = 1;

		Withdrawal withdraw = new Withdrawal();
		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		str = withdraw.run(false, amountToWithdraw);
		System.out.println(str);
		assertEquals(str, NEW_BALANCE_AMOUNT_INFO + 0);

	}

	@Test
	void testGreaterWithdrawalAmountThanBalance() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		balance_amount = 10;
		amountToWithdraw = 11;

		Withdrawal withdraw = new Withdrawal();
		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		str = withdraw.run(false, amountToWithdraw);
		System.out.println(str);
		assertEquals(str, INVALID_WITHDRAWAL_AMOUNT_WARNING);
	}

	@Test
	void testMaximumWithdrawAmountPerDay() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		balance_amount = 100000;
		amountToWithdraw = 20000;

		Withdrawal withdraw = new Withdrawal();
		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		System.out.println(withdraw.run(false, amountToWithdraw));

		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		System.out.println(withdraw.run(false, amountToWithdraw));

		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		str = withdraw.run(false, amountToWithdraw);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_DAY_WARNING);
	}

	@Test
	void testMaximumWithdrawAmountPerTransaction() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		balance_amount = 20002;
		amountToWithdraw = 20001;

		Withdrawal withdraw = new Withdrawal();
		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		str = withdraw.run(false, amountToWithdraw);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_WITHDRAWAL_AMOUNT_PER_TRANSACTION_WARNING);
	}

	@Test
	void testWithdrawFrequencyPerDay() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		balance_amount = 1000;
		amountToWithdraw = 1;

		Withdrawal withdraw = new Withdrawal();
		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		System.out.println(withdraw.run(false, amountToWithdraw));

		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		System.out.println(withdraw.run(false, amountToWithdraw));

		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		System.out.println(withdraw.run(false, amountToWithdraw));

		System.out.println("Current balance: " + balance_amount + ", withdrawing " + amountToWithdraw
				+ " from current balance...");
		String str = withdraw.run(false, amountToWithdraw);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_WITHDRAWAL_FREQUENCY_PER_DAY_WARNING);
	}
}
