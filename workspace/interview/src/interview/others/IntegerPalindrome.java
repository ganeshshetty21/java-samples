package interview.others;

public class IntegerPalindrome {

	public static void main(String[] args) {
		IntPalindromeTest intPalindromeTest = new IntPalindromeTest();
		System.out.println(" " + intPalindromeTest.test(1234));
		System.out.println(" " + intPalindromeTest.test(121));
		System.out.println(" " + intPalindromeTest.test(10501));
		System.out.println(" " + intPalindromeTest.test(1001));

	}

}

class IntPalindromeTest {

	public boolean test(int number) {
		System.out.println(" number = " + number);
		int rem = 0;
		int temp = number;
		int reverse = 0;
		while (temp > 0) {
			rem = temp % 10;
			reverse = reverse * 10 + rem;
			temp = temp / 10;
			System.out.println(" rem = " + rem + " temp = " + temp + " reverse " + reverse);
		}

		if (number == reverse) {
			return true;
		}

		return false;
	}

}
