package interview.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SortStringDates {

	public static void main(String[] args) {
		usingDate();
		usingLocalDate();
	}

	private static void usingDate() {
		List<String> sDates = Arrays.asList("01 FEB 2019", "01 MAR 2019", "01 JAN 2019");
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

		sDates.forEach(arg0 -> System.out.println("Before " + arg0));

		Collections.sort(sDates, new Comparator<String>() {

			@Override
			public int compare(String date1, String date2) {
				try {
					return sdf.parse(date1).compareTo(sdf.parse(date2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}

		});

		sDates.forEach(arg0 -> System.out.println("After " + arg0));
	}

	private static void usingLocalDate() {
		List<String> sDates = Arrays.asList("01 FEB 2019", "01 MAR 2019", "01 JAN 2019");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy");

		sDates.forEach(arg0 -> System.out.println("Before " + arg0));

		Collections.sort(sDates, new Comparator<String>() {

			@Override
			public int compare(String date1, String date2) {
				return LocalDate.parse(date1, format).compareTo(LocalDate.parse(date2, format));
			}

		});

		sDates.forEach(arg0 -> System.out.println("After " + arg0));
	}

}

class Solution {

	public List<String> sortDates(List<String> sDates) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		// SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
		Collections.sort(sDates, new Comparator<String>() {

			@Override
			public int compare(String fDate, String sDate) {

				try {
					return sdf.parse(fDate).compareTo(sdf.parse(sDate));

				} catch (ParseException e) {
					e.printStackTrace();
				}
				return -1;
			}

		});
		return sDates;

	}
}

//https://stackoverflow.com/questions/27657626/sorting-java-list-of-objects-using-string-date
class GoogleSolution {
	private final String dateFormat = "dd MMM yyyy";
	// private final String dateFormat = "EEE MMM dd HH:mm:ss yyyy";
	private final Comparator<String> dateComp = new Comparator<String>() {
		public int compare(String s1, String s2) {
			Date d1 = null;
			try {
				d1 = new SimpleDateFormat(dateFormat, Locale.ENGLISH).parse(s1);
			} catch (ParseException e) {
				// HANDLE THIS EXCEPTION
			}

			Date d2 = null;
			try {
				d2 = new SimpleDateFormat(dateFormat, Locale.ENGLISH).parse(s2);
			} catch (ParseException e) {
				// HANDLE THIS EXCEPTION
			}
			return d1.compareTo(d2);
		}
	};

	public List<String> sortDates(List<String> sDates) {
		Collections.sort(sDates, dateComp);
		return sDates;

	}
}
