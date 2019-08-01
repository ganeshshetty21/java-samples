package interview.string;

import java.util.HashSet;
import java.util.Set;

public class LongSubStringMain {

	public static void main(String[] args) {
		LongSubStr longSubStr = new LongSubStr();
		longSubStr.getLongestSubString("ABCDABCDE");
		longSubStr.getLongestSubString("ABCDAKBJLMCDBABCDEFGHIJKLMNOPQRSTUVWXYZA");
	}

}

class LongSubStr {
	public String getLongestSubString(String in) {
		String tempLongSubStr = "";
		String longSubStr = "";
		Set<Character> chars = new HashSet<>();
		for (int i = 0; i < in.length(); i++) {
			if (chars.contains(in.charAt(i))) {
				chars.clear();
				i--;
				tempLongSubStr = "";
			}
			tempLongSubStr = tempLongSubStr + (in.charAt(i));
			chars.add(in.charAt(i));
			if (longSubStr.length() < tempLongSubStr.length()) {
				longSubStr = tempLongSubStr;
			}
			print(chars, longSubStr);
		}

		return longSubStr;
	}

	private void print(Set<Character> charSet, String longSubStr) {
		System.out.print("charSet => ");
		charSet.forEach(action -> System.out.print(action));
		System.out.print(", longSubStr => " + longSubStr + "\n");

	}
}
