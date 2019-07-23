package interview.others;

public class StringToIntWidoutSplFunxn {

	public static void main(String[] args) {
		String arg = "1234";

		char[] chars = arg.toCharArray();
		int powerFactor = 0;
		int sum = 0;

		for (int index = chars.length - 1; index > -1; index--) {
			int temp = chars[index] - '0';
			System.out.println(" temp " + temp);
			temp = temp * powerFactored(powerFactor);
			System.out.println(" powered " + temp);
			powerFactor = powerFactor + 1;
			System.out.println("powerFactor " + powerFactor);
			sum = sum + temp;
			System.out.println(" sum " + sum);
		}

	}

	private static int powerFactored(int powerFactor) {
		int result = 1;
		for (int i = 0; i < powerFactor; i++) {
			result = result * 10;
		}

		return result;
	}

}
