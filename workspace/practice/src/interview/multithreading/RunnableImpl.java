package interview.multithreading;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RunnableImpl implements Runnable {

	private int acctNumber;
	private CountDownLatch countDownLatch;
	private CopyOnWriteArrayList<Account> accounts;

	RunnableImpl(int acctNumber, CountDownLatch countDownLatch, CopyOnWriteArrayList<Account> accounts) {
		this.acctNumber = acctNumber;
		this.countDownLatch = countDownLatch;
		this.accounts = accounts;
	}

	@Override
	public void run() {
		try {
			Account account = new Account(acctNumber);
			accounts.add(account);
			System.out.println("Account = " + account + ", " + this.countDownLatch.getCount());
			//TimeUnit.SECONDS.sleep(3);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.countDownLatch.countDown();
			System.out.println(" finally =>> " + this.countDownLatch.getCount());
		}
	}

}
