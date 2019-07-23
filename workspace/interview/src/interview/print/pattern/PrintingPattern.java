package interview.print.pattern;

public class PrintingPattern {
	public static void main(String[] args) {
		PrintingPatternTest printingPatternTest = new PrintingPatternTest();
		printingPatternTest.print("*", 5);
	}
}

class PrintingPatternTest {

	public void print(String string, int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(string);
			}
			System.out.println();
		}

	}

}