package interview.others;

public class PrimeNumber {

	public static void main(String[] args) {
		isPrimeNumber(2);
		isPrimeNumber(5);
		isPrimeNumber(11);
		isPrimeNumber(21);
		isPrimeNumber(23);
		isPrimeNumber(30);
	}

	private static boolean isPrimeNumber(int number) {
		for (int i = 2; i < number; i++) {
			if ((number % i) == 0) {
				System.out.println(number + " is not a prime");
				return false;
			}
		}
		System.out.println(number + " is a prime");
		return true;
	}

}
