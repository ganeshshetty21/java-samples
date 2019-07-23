package interview.sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringDatesSort {

	public static void main(String[] args) {
		List<String> dates = Arrays.asList("2019-03-01", "2018-03-01", "2017-03-01", "2017-02-01", "2018-02-01",
				"2019-02-01", "2018-01-01", "2017-01-01", "2019-01-01");

		dates.forEach(date -> System.out.println(" before "+date));

		Collections.sort(dates, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return (LocalDate.parse(arg0)).compareTo(LocalDate.parse(arg1));
			}
		});

		dates.forEach(date -> System.out.println(date));

	}

}
