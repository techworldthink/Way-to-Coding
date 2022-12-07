package sortingobjects;

import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		Set<Employee> set = new TreeSet<>(new EmployeeNameComparator());
		set.add(new Employee(100, "Obama"));
		set.add(new Employee(400, "Tom"));
		set.add(new Employee(300, "Bharath"));
		set.add(new Employee(200, "Rambo"));

		for (Employee employee : set) {
			System.out.println(employee.id);
			System.out.println(employee.name);
		}

	}

}
