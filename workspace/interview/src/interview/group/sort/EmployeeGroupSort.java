package interview.group.sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://howtodoinjava.com/sort/groupby-sort-multiple-comparators/
public class EmployeeGroupSort {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Ganesh", 1000, LocalDate.parse("2002-09-21")),
				new Employee(1, "Sundara", 2000, LocalDate.parse("2003-09-21")),
				new Employee(1, "Ram", 3000, LocalDate.parse("2000-09-21")),
				new Employee(1, "Shetty", 4000, LocalDate.parse("2004-09-21")),
				new Employee(1, "Bhat", 5000, LocalDate.parse("2004-09-21")));

		employees.forEach(employee -> printList(employee));

		Collections.sort(employees, new DobSorter().thenComparing(new NameSorter()));

		System.out.println("After sorting");
		employees.forEach(employee -> printList(employee));

	}

	private static void printList(Employee employee) {
		System.out.println(employee);
	}

}
