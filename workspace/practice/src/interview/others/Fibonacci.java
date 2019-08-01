package interview.others;

public class Fibonacci {

	public static void main(String[] args) {
		int start = 1;
		System.out.println(start);
		int end = start;
		for (int i = 0; i < 10; i++) {
			// System.out.println(" start " + start + " end " + end);
			System.out.print(end + ", ");
			int temp = end;
			end = start + end;
			start = temp;
		}
		System.out.println();
		rec(0, 1);

	}

	public static void rec(int start, int end) {
		if (end > 100) {
			return;
		}
		if (end > 0) {
			System.out.print(end + ": ");
		}
		rec(end, start + end);
	}

}
