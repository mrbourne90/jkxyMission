package com.johnz.sync;

public class Credit {
	public static void main(String[] args) {

		Account account = new Account(100);
		Thread deposit = new Thread(new Deposit(account));
		Thread withdrawal = new Thread(new Withdrawal(account));
		deposit.start();
		withdrawal.start();
	}
}