package com.johnz.sync;

class Account {
	private int sum;

	public Account(int sum) {
		this.setSum(sum);
	}

	public synchronized void add(int num) {
		System.out.print("账户余额：" + sum + "元\t");
		this.sum += num;
		System.out.print("账户存入:" + num + "元\t" + "账户余额：" + sum + "元\n");
		notifyAll();
	}

	public synchronized void sub(int num) {
		if ((this.sum - num) < 0) {
			System.out.println("账户余额：" + sum + "元\t" + "账户取现:" + num + "元\t" + "余额不足！");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("账户余额：" + sum + "元\t");
		this.sum -= num;
		System.out.print("账户取现:" + num + "元\t" + "账户余额：" + sum + "元\n");

	}

	public synchronized int getSum() {
		return sum;
	}

	public synchronized void setSum(int sum) {
		this.sum = sum;
	}
}