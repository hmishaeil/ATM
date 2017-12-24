package com.tala.atm;

import static com.tala.atm.Common.balance_amount;

public class Balance {

	/*
	 * The needed function to show the current balance of the account.
	 * The default value for balance amount is defined based on the 
	 * 	blance_amount value.
	 */
	public void show() {
		System.out.println(Common.BALANCE_AMOUNT_INFO + balance_amount);
	}
}
