package CustomClassAsKeyinHashMap;

import java.util.HashMap;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Alice");
        Employee emp2 = new Employee(101, "Bob");  // Same id → treated as same key

        HashMap<Employee, String> map = new HashMap<>();

        map.put(emp1, "First Entry");
        map.put(emp2, "Second Entry");  // Will overwrite because equals() returns true

        System.out.println("Map size: " + map.size());
        for (Employee e : map.keySet()) {
            System.out.println(e + " => " + map.get(e));
        }
    }
}
