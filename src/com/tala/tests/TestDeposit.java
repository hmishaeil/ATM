package com.tala.tests;

import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_DAY_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING;
import static com.tala.atm.Common.EXCEEDED_MAX_DEPOSIT_FREQUENCY_PER_DAY_WARNING;
import static com.tala.atm.Common.NEW_BALANCE_AMOUNT_INFO;
import static com.tala.atm.Common.balance_amount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tala.atm.Deposit;
/*
 * Implementing the needed functions to test the deposit functionality
 * We are going to test below main items
 * - Testing deposit limitation amount per day 
 * - Testing maximum deposit frequency per day
 * - Testing regular deposit 
 * - Testing maximum deposit amount per day
 * - Testing maximum deposit amount per transaction
 * 
 */
public class TestDeposit {

	private String str;
	private int amountToDeposit = 0;

	@BeforeEach
	void setUp() throws Exception {
		balance_amount = 0;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("______________________________________________________________________");
	}

	@Test
	void testDepositAmountLimitationPerDay() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		amountToDeposit = 40000;

		Deposit deposit = new Deposit();

		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));

		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));

		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));

		amountToDeposit = 30000;
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		str = deposit.run(false, amountToDeposit);
		System.out.println(str);
		assertEquals(str, NEW_BALANCE_AMOUNT_INFO + ((40000 * 3) + 30000));
	}

	@Test
	void testDepositFrequencyPerDay() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		amountToDeposit = 1;

		Deposit deposit = new Deposit();
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		String str = deposit.run(false, 1);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_DEPOSIT_FREQUENCY_PER_DAY_WARNING);
	}

	@Test
	void testDoDeposit() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		amountToDeposit = 1;

		Deposit deposit = new Deposit();
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		str = deposit.run(false, amountToDeposit);
		System.out.println(str);
		assertEquals(str, NEW_BALANCE_AMOUNT_INFO + 1);

	}

	@Test
	void testMaximumDepositAmountPerDay() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		amountToDeposit = 40000;

		Deposit deposit = new Deposit();
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		System.out.println(deposit.run(false, amountToDeposit));
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		str = deposit.run(false, amountToDeposit);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_DAY_WARNING);
	}

	@Test
	void testMaximumDepositAmountPerTransaction() {
		System.out.println("#" + Thread.currentThread().getStackTrace()[1].getMethodName());

		amountToDeposit = 40001;

		Deposit deposit = new Deposit();
		System.out.println(
				"Current balance: " + balance_amount + ", adding " + amountToDeposit + " to current balance...");
		str = deposit.run(false, amountToDeposit);
		System.out.println(str);
		assertEquals(str, EXCEEDED_MAX_DEPOSIT_AMOUNT_PER_TRANSACTION_WARNING);
	}
}
