package interview.string;

public class StringToNumber {

	public static void main(String[] args) {
		String s = "1234";

		char[] chars = s.toCharArray();
		int result = 0;
		int temp = -1;
		for (int i = 0; i < chars.length; i++) {
			System.out.println("chars[i] " + chars[i]);
			temp = chars[i] - '0';
			System.out.println("temp " + temp);
			result = (result * 10) + temp;
			System.out.println("result " + result);
		}

		System.out.println(result);

	}

}
