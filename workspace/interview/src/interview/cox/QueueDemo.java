package interview.cox;

import java.util.LinkedList;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> queue = new QueueImpl<>();
		System.out.println(queue.isEmpty());
		System.out.println(queue.queue("Brandy"));
		System.out.println(queue.queue("Mindy"));
		System.out.println(queue.queue("Candy"));
		System.out.println(queue.queue("Andy"));
		System.out.println(queue.deQueue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.deQueue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.deQueue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.deQueue());
		System.out.println(queue.isEmpty());
	}

}

interface Queue<T> {
	public boolean queue(T t);

	public T deQueue();

	public boolean isEmpty();
}

class QueueImpl<T> implements Queue<T> {
	LinkedList<T> values = new LinkedList<>();

	@Override
	public boolean queue(T t) {
		return values.add(t);
	}

	@Override
	public T deQueue() { 
		return values.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

}
