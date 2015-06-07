package com.corejava.synch.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Lock instance;
 * @author jason
 *
 */
public class Bank {
	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientsFunds;
	
	
	public Bank(int n , double initialBalance) {
		accounts = new double[n];
		for (int i=0;i<accounts.length;i++) {
			accounts[i] = initialBalance;
			bankLock = new ReentrantLock();
		}
		sufficientsFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount) throws InterruptedException {
		bankLock.lock();
		try {
			while(accounts[from] < amount) {
				sufficientsFunds.await();// release the lock until it awake by the lock holder to use signall() method inform 
			}
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount,from,to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f %n", getTotalBalance());
			sufficientsFunds.signalAll();
		}
		finally {
			bankLock.unlock();
		}
	}

	private double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for(double d: accounts) {
				sum += d;
			}
			return sum;
		}
		finally{
			bankLock.unlock();
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank(10, 1000);
		
		for(int i= 0; i < 10 ;i ++ ) {
			ThreadRunnable r = new ThreadRunnable(bank,i,1000);
			Thread t = new Thread (r);
			t.start();
		}
	}

	public double size() {
		return accounts.length;
	}
	
}
class ThreadRunnable implements Runnable {
    private Bank bank;
	private int fromAccount;
	private double maxAccount;
	static int DELAY = 10;

	
	public ThreadRunnable(Bank bank, int fromAccount, double maxAccount) {
		super();
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAccount = maxAccount;
	}


	@Override
	public void run() {
		try {
			while (true) {
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAccount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY*Math.random()));
			}
		}
		catch(InterruptedException e) {
			
		}
	}
	
}