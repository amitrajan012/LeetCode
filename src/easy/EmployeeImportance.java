package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/employee-importance/description/
 *
 */
public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> emp = new HashMap<Integer, Employee>();
		for(Employee e: employees) {
			emp.put(e.id, e);
		}
       
		return traverseSubordinates(emp, id);
    }
	
	private int traverseSubordinates(Map<Integer, Employee> emp, int id) {
		Employee e = (Employee) emp.get(id);
		int importance = e.importance;
		for(int sub: e.subordinates) {
			importance += traverseSubordinates(emp, sub);
		}
		return importance;
	}
}
