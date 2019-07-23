package interview.group.sort;

import java.util.Comparator;

public class DobSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.dob.compareTo(o2.dob);
	}

}
