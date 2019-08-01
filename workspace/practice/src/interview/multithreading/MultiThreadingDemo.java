package interview.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadingDemo {

	public static void main(String[] args) {
		MultiThreading multiThreading = new MultiThreading();
		// multiThreading.demo(10, 2, 20);
		multiThreading.demoCallable(10, 2, 3);
		// CopyOnWriteArrayList<Account> accounts = multiThreading.demoRunnable(12, 2,
		// 4);
		// accounts.forEach(account -> System.out.println("account.getAcctNumber()" +
		// account.getAcctNumber()));
	}

}

class MultiThreading {
	@SuppressWarnings("unchecked")
	public CopyOnWriteArrayList<Account> demoRunnable(int taskSize, int thredSize, int waitingSeconds) {
		System.out.println("DemoMultiThreading demoRunnable started. taskSize = " + taskSize + ", thredSize = "
				+ thredSize + ", waitingSeconds =" + waitingSeconds);
		ExecutorService executorService = Executors.newFixedThreadPool(thredSize);
		CountDownLatch countDownLatch = new CountDownLatch(taskSize);
		List<Future<Account>> futures = new ArrayList<>();
		CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

		for (int i = 0; i < taskSize; i++) {
			futures.add((Future<Account>) executorService.submit(new RunnableImpl(i, countDownLatch, accounts)));
		}
		try {
			executorService.shutdown(); // stop taking requests
			countDownLatch.await(waitingSeconds, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cancelUndoneTask(countDownLatch, futures);
		executorService.shutdownNow();
		System.out.println("DemoMultiThreading demoRunnable completed. taskSize = " + taskSize + ", thredSize = "
				+ thredSize + ", waitingSeconds =" + waitingSeconds);
		return accounts;
	}

	public void demoCallable(int taskSize, int thredSize, int waitingSeconds) {
		System.out.println("DemoMultiThreading demoCallable started. taskSize = " + taskSize + ", thredSize = "
				+ thredSize + ", waitingSeconds =" + waitingSeconds);
		ExecutorService executorService = Executors.newFixedThreadPool(thredSize);
		CountDownLatch countDownLatch = new CountDownLatch(taskSize);
		List<Future<Account>> futures = new ArrayList<>();

		for (int i = 0; i < taskSize; i++) {
			futures.add(executorService.submit(new CallableImpl(i, countDownLatch)));
		} 
		futures.forEach(future -> {
			try {
				System.out.println("future.getAcctNumber()" + future.get().getAcctNumber());
			} catch (InterruptedException | ExecutionException | NullPointerException e) { 
				e.printStackTrace();
			}
		});
		cancelUndoneTask(countDownLatch, futures);
		executorService.shutdownNow();
		System.out.println("DemoMultiThreading demoCallable completed. taskSize = " + taskSize + ", thredSize = "
				+ thredSize + ", waitingSeconds =" + waitingSeconds);

	}

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
