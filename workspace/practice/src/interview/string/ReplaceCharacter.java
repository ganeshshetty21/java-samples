package interview.string;

public class ReplaceCharacter {

	public static void main(String[] args) {
		String words = "hello world, i am a java program, how are you today?";
		char from = 'a';
		char to = '/';

		//System.out.println(words.substring(1));
		System.out.println(replace(words, from, to));
	}

	public static String replace(String s, char from, char to) {
		if (s.length() < 1) {
			return s;
		} else {
			char first = from == s.charAt(0) ? to : s.charAt(0);
			return first + replace(s.substring(1), from, to);
		}
	}

}