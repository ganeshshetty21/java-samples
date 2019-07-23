package interview.others;

public class Factorial {

	public static void main(String[] args) {
		FactorialTest factorialTest = new FactorialTest();
		System.out.println(factorialTest.test(3));
		System.out.println(factorialTest.test(8));
		System.out.println(factorialTest.testRec(3));
		System.out.println(factorialTest.testRec(8));
	}

}

class FactorialTest {
	int test(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	int testRec(int n) {
		if (n == 0) {
			return 1;
		}

		return n * testRec(n - 1);
	}
}