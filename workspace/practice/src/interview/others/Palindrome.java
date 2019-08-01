package interview.others;

public class Palindrome {

	public static void main(String[] args) {
		PalindromeRecurisveTest palindromeTest = new PalindromeRecurisveTest();
		System.out.println("result = " + palindromeTest.test("BOb"));
		System.out.println("result = " + palindromeTest.test("Abcd"));
		System.out.println("result = " + palindromeTest.test("Abca"));
		System.out.println("result = " + palindromeTest.test("Abba"));
		System.out.println("result = " + palindromeTest.test("AbXba"));

	}

}

class PalindromeTest {
	public boolean test(String input) {
		System.out.println(input);
		boolean result = true;
		if (input != null && !"".equalsIgnoreCase(input)) {
			int length = input.length();
			int start = 0;
			int end = length - 1;
			while (start < end) {
				System.out.println("start = " + start + " end = " + end);
				if (Character.toLowerCase(input.charAt(start)) == Character.toLowerCase(input.charAt(end))) {
					System.out.println(" Inside if ");
					start++;
					end--;
				} else {
					System.out.println(" Inside else ");
					result = false;
					break;
				}
			}

		}

		return result;
	}
}

class PalindromeRecurisveTest {
	public boolean test(String input) {
		System.out.println(" input " + input);
		if (input != null && !"".equalsIgnoreCase(input) && input.length() >= 2) {
			System.out.println(" Character.toLowerCase(input.charAt(0)) = " + Character.toLowerCase(input.charAt(0))
					+ " Character.toLowerCase(input.charAt(input.length() - 1)) = "
					+ Character.toLowerCase(input.charAt(input.length() - 1)));

			if (Character.toLowerCase(input.charAt(0)) == Character.toLowerCase(input.charAt(input.length() - 1))) {
				System.out.println(" input.substring(1, input.length() - 1) " + input.substring(1, input.length() - 1));
				return test(input.substring(1, input.length() - 1));
			} else {
				return false;
			}
		}
		return true;
	}
}