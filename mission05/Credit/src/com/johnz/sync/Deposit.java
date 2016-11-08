package com.johnz.sync;
/**
 * 存款线程
 * 
 * @author Administrator
 *
 */
class Deposit implements Runnable {
	private Account account;

	public Deposit(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1500; i++) {
			account.add(1);
		}
	}
}