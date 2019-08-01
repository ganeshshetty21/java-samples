package interview.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CallableImpl implements Callable<Account> {

	private int acctNumber;
	private CountDownLatch countDownLatch;

	CallableImpl(int acctNumber, CountDownLatch countDownLatch) {
		this.acctNumber = acctNumber;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public Account call() throws Exception {
		try {
			Account account = new Account(acctNumber);
			System.out.println("Account = " + account + ", " + this.countDownLatch.getCount());
			//TimeUnit.SECONDS.sleep(3);
			Thread.sleep(3000);
			return account;
		} finally {
			this.countDownLatch.countDown();
			System.out.println(" finally =>> " + this.countDownLatch.getCount());
		}
	}

}
