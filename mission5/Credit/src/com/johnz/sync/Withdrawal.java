package com.johnz.sync;
/**
 * 取款线程
 * 
 * @author Administrator
 *
 */
class Withdrawal implements Runnable {
	private Account account;

	public Withdrawal(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1500; i++) {
			account.sub(1);
		}
	}

}