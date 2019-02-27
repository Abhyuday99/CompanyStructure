//package Company ;

public class Employee implements Comparable<Employee> {

		private String name ;
		private int level ;
		
		Employee() {
			this.name = "A" ;
			this.level = 0 ;
			
		}
		Employee(String s){
			this.name = s ;
			this.level = 0 ;
		}
		Employee(String s ,int x){
			this.name = s ;
			this.level = x ;
		}
		
		public int compareTo(Employee that) {
			
			return name.compareTo(that.name) ;
		}
		public String toString() {
			return name ;
		}
		public int getLevel() {
			return level ;
		}
		public String getName() {
			return name ;
		}
		
		public static void main(String[] args) {
			
			Employee a = new Employee("Abhyuday",1) ;
			Employee b = new Employee("Sushant",2) ;
			Employee c = new Employee("Abhyuday",3) ;
			System.out.println(a.equals(b));
			System.out.println(a.equals(c));
		}
}
