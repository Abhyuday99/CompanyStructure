
//package Company ;

public class EmployeeNotFoundException extends Exception {

	EmployeeNotFoundException(String s){
		super(s) ;
	}
	EmployeeNotFoundException() {
		super("Employee") ;
	}
}
