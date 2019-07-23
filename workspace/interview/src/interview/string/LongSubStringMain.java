package interview.string;

import java.util.HashSet;
import java.util.Set;

public class LongSubStringMain {

	public static void main(String[] args) { 
		LongSubStr longSubStr = new LongSubStr(); 
		longSubStr.getLongestSubString("ABCDABCDE");
		longSubStr.getLongestSubString("ABCDAKBJLMCDBABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

}

class LongSubStr {
	public String getLongestSubString(String arg) {
		String longSubStr = "";
		for (int j = 0; j < arg.length(); j++) {
			String tempSubStr = "";
			Set<Character> charSet = new HashSet<>();
			for (int i = j; i < arg.length(); i++) {
				char charRead = arg.charAt(i);
				if (charSet.contains(charRead)) {
					charSet = new HashSet<>();
					tempSubStr = "" + charRead;
				} else {
					tempSubStr = tempSubStr + charRead;
				}
				charSet.add(charRead);
				//print(charSet, tempSubStr);
				System.out.println(" tempSubStr "+tempSubStr);
			}
			if (longSubStr.length() < tempSubStr.length()) {
				longSubStr = tempSubStr;
				System.out.println(" longSubStr "+longSubStr);
			}
		}
		System.out.println(" return "+longSubStr);
		return longSubStr;
	}

	private void print(Set<Character> charSet, String longSubStr) {
		System.out.print("charSet => ");
		charSet.forEach(action -> System.out.print(action));
		System.out.print(", longSubStr => " + longSubStr + "\n");

	}
}
 