package interview.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnableThreading {
	ExecutorService executorService = null;

	public void init(int thredSize) {
		executorService = Executors.newFixedThreadPool(thredSize);
	}

	public void destroy() {
		executorService.shutdownNow();
	}

	public static void main(String[] args) {
		RunnableThreading runnableThreading = new RunnableThreading();
		runnableThreading.init(2);

		List<Account> accounts = runnableThreading.demoRunnable(12, 1);
		accounts.forEach(account -> System.out.println("XXX account.getAcctNumber()" + account.getAcctNumber()));
		System.out.println("-------------------------------------------------------------");
		accounts = runnableThreading.demoRunnable(12, 30);
		accounts.forEach(account -> System.out.println("YYY account.getAcctNumber()" + account.getAcctNumber()));

		runnableThreading.destroy();
	}

	@SuppressWarnings("unchecked")
	public List<Account> demoRunnable(int taskSize, int waitingSeconds) {
		System.out.println("DemoMultiThreading demoRunnable started. taskSize = " + taskSize + " waitingSeconds ="
				+ waitingSeconds); 
		CountDownLatch countDownLatch = new CountDownLatch(taskSize);
		List<Future<Account>> futures = new ArrayList<>();
		CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

		for (int i = 0; i < taskSize; i++) {
			futures.add((Future<Account>) executorService.submit(new RunnableImpl(i, countDownLatch, accounts)));
		}
		try { 
			countDownLatch.await(waitingSeconds, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cancelUndoneTask(countDownLatch, futures); 
		countDownLatch = null;
		futures = null;
		System.out.println("DemoMultiThreading demoRunnable completed. taskSize = " + taskSize + " waitingSeconds ="
				+ waitingSeconds);
		return accounts;
	}

	/*
	 * No tasks are cancelled
	 */
	private void cancelUndoneTask(CountDownLatch countDownLatch, List<Future<Account>> futures) {
		System.out.println(" cancelUndoneTask countDownLatch.getCount() " + countDownLatch.getCount());
		if (countDownLatch.getCount() > 0) {
			futures.forEach(future -> {
				if (!future.isDone()) {
					future.cancel(true);
				}
			});
		}
	}
}
