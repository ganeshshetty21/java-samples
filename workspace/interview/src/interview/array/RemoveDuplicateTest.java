package interview.array;

public class RemoveDuplicateTest {
	public static void main(String[] args) {
		RemoveDuplicate remDup = new RemoveDuplicate();
		String[] strs = { "a", "b", "c", "a", "d", "e" };
		String[] newArr = remDup.remDup(strs);
		remDup.print(strs);
		remDup.print(newArr);
	}

}

class RemoveDuplicate {
	String[] remDup(String[] strs) {
		String[] news = new String[strs.length];
		int j = -1;
		for (int i = 0; i < strs.length; i++) {
			if (!isDuplicate(news, strs[i])) {
				j = j + 1;
				news[j] = strs[i];
			}
		}
		return news;
	}

	private boolean isDuplicate(String[] news, String string) {
		for (int i = 0; i < news.length; i++) {
			if (string.equals(news[i])) {
				return true;
			}

		}
		return false;
	}

	public void print(String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + ",");
		}
		System.out.println();
	}
}