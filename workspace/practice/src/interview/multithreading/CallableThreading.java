package interview.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CallableThreading {
	ExecutorService executorService = null;

	public void init(int thredSize) {
		executorService = Executors.newFixedThreadPool(thredSize);
	}

	public void destroy() {
		executorService.shutdownNow();
	}

	public static void main(String[] args) {
		CallableThreading callableThreading = new CallableThreading();
		callableThreading.init(2);

		List<Account> accounts = callableThreading.demoCallable(12, 1);
		accounts.forEach(account -> System.out.println("account.getAcctNumber()" + account.getAcctNumber()));

		accounts = callableThreading.demoCallable(12, 3);
		accounts.forEach(account -> System.out.println("account.getAcctNumber()" + account.getAcctNumber()));

		callableThreading.destroy();
	}

	public List<Account> demoCallable(int taskSize, int waitingSeconds) {
		System.out.println("DemoMultiThreading demoCallable started. taskSize = " + taskSize + " waitingSeconds ="
				+ waitingSeconds);

		CountDownLatch countDownLatch = new CountDownLatch(taskSize);
		List<Future<Account>> futures = new ArrayList<>();

		for (int i = 0; i < taskSize; i++) {
			futures.add(executorService.submit(new CallableImpl(i, countDownLatch)));
		}
		List<Account> accounts = futures.parallelStream().map(future -> {
			try {
				return future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		cancelUndoneTask(countDownLatch, futures);
		System.out.println("DemoMultiThreading demoCallable completed. taskSize = " + taskSize + "  waitingSeconds ="
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
