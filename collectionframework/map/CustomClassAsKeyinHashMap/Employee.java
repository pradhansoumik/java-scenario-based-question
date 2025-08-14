package CustomClassAsKeyinHashMap;

public class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Override equals() and hashCode()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee other = (Employee) o;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return "[" + id + "," + name + "]";
        }

}
