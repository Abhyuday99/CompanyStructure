//package Company ;

import java.io.* ;
import java.util.StringTokenizer ;
import java.util.Scanner ;

public class CompanyStructure {
	
	private TreeNode<Employee> tree  ;
	private BST<String,TreeNode<Employee>> locations ;
	int size ;
	
	CompanyStructure() {
		this.tree = new TreeNode<Employee>() ;
		this.locations = new BST<String,TreeNode<Employee>>() ;
		this.size =  0 ;
	}
	CompanyStructure(String a) {
		this.tree = new TreeNode<Employee>(new Employee(a,1)) ;
		this.locations = new BST<String,TreeNode<Employee>>(a,this.tree) ;
		this.size =  1 ;
	}
	
	public  void AddEmployee(String parent,String entry) throws EmployeeNotFoundException{
		
		Leaf<String,TreeNode<Employee>> temp2 = locations.search(parent) ;
		if(temp2 == null) {
			throw new EmployeeNotFoundException(parent) ;
		}
		TreeNode<Employee> temp = temp2.location ;
		TreeNode<Employee> toAdd = new TreeNode<Employee>(new Employee(entry,temp.data.getLevel() + 1)) ;
		toAdd.parent = temp ;
		locations.add(entry, toAdd);
		temp.childs.insertFirst(toAdd);
		temp.no_of_children++ ;
	}
	
	public int getLevel(String s) {
		Employee query = new Employee(s) ;
		TreeNode<Employee> temp = tree.searchNode(query) ;
		if(temp == null) {
			System.out.println("Employee not found");
			return 0 ;
		}
		return temp.data.getLevel();
	}
	
	public void DeleteEmployee(String r, String s) throws EmployeeNotFoundException{
		
		DNode<TreeNode<Employee>> cursor,temp3 = null,temp4 = null ;
		Leaf<String,TreeNode<Employee>> temp = locations.search(r) ;
		Leaf<String,TreeNode<Employee>> temp2 = locations.search(s) ;
		
		if(temp == null) {
				throw new EmployeeNotFoundException(r) ;
		}
		if(temp2 == null) {
				throw new EmployeeNotFoundException(s) ;
		}
		TreeNode<Employee> e1 = temp.location ;
		cursor = e1.parent.childs.getHead().getNext() ;
		while(cursor != e1.parent.childs.getTail() ){
			if(cursor.getData().equals(e1)) {
				temp3 = cursor ;
				break ;
			}
			cursor = cursor.getNext();
		}
		if(cursor == e1.parent.childs.getTail()) {
			throw new EmployeeNotFoundException(r) ;
		}
		TreeNode<Employee> e2 = temp2.location ;
		cursor = e2.parent.childs.getHead().getNext() ;
		
		while(cursor != e2.parent.childs.getTail() ){
			if(cursor.getData().equals(e2)) {
				temp4 = cursor ;
				break ;
			}
			cursor = cursor.getNext();
		}
		if(cursor == e2.parent.childs.getTail()) {
			throw new EmployeeNotFoundException(s) ;
		}
		
			TreeNode<Employee> a,b ;
			cursor = temp3.getPrev() ;
			cursor.setNext(temp3.getNext()) ;
			temp3.getNext().setPrev(cursor);
			temp3.setNext(null);
			temp3.setPrev(null);
			a = temp3.getData() ;
			b = temp4.getData() ;
			TreeNode<Employee> child ;
			while(a.childs.getSize() > 0) {
				
					child = a.childs.removeFirst() ;
				
				/*catch(Exception e){
					System.out.println("\n" + a.childs.getSize()) ;
					throw new EmployeeNotFoundException(r) ;
				}*/
				child.parent = b ;
				b.childs.insertFirst(child) ;
			}
			b.no_of_children += a.no_of_children ;
			e1.parent.no_of_children-- ;
			DLinkedList<TreeNode<Employee>> parent = e1.parent.childs ;
			parent.setSize(parent.getSize() -1) ;
	}
	
	public void getCommonBoss(String s , String r) throws EmployeeNotFoundException{
		if(s.compareTo(r) == 0) {
			System.out.println("Error: Input Employee names are same.");
			return ;
		}
		String name = tree.data.getName() ;
		if(s.compareTo(name) == 0 || r.compareTo(name) == 0) {
			System.out.println("Invalid Input: No one is the boss of " + name);
			return ;
		}
		String answer ;
		try {
			answer = findAncestor(s,r) ;
		}
		catch(EmployeeNotFoundException e) {
			throw new EmployeeNotFoundException("Parent") ;
		}
		if(answer == null) {
			System.out.println("Error : invalid name of employee!");
			return ;
		}
		else {
			System.out.println(answer);
			return ;
		}
	}
	
	public String findAncestor(String s,String r) throws EmployeeNotFoundException{
		
		Leaf<String,TreeNode<Employee>> temp = locations.search(s) ;
		Leaf<String,TreeNode<Employee>> temp2 = locations.search(r) ;
		if(temp == null ) {
			throw new EmployeeNotFoundException(s) ;
		}
		if(temp2 == null ) {
			throw new EmployeeNotFoundException(r) ;
		}
		TreeNode<Employee> a,b,employee_temp ;
		a = temp.location ;
		b = temp2.location ;
		int diff = a.data.getLevel() - b.data.getLevel() ;
		if(diff < 0) {
			diff = -diff ;
			employee_temp = a ;
			a = b ;
			b = employee_temp ;
		}
		while(diff-- > 0) {
			a = a.parent ;
		}
		
		if(a == b){
			return a.parent.data.getName() ;
		}
		boolean found = false ;
		while(a != null && b != null) {
			if(a == b) {
				found = true ;
				break ;
			}
			else {
				a = a.parent ;
				b = b.parent ;
			}
		}
		
		if(found) {
			return a.data.getName() ;
		}
		else {
			return null ;
		}
		
		
		
	}
	
	
	
	public static void main (String[] args)  throws IOException{
		// TODO Auto-generated method stub
		/*CompanyStructure test = new CompanyStructure("Abhyuday") ;
		test.tree.printTree();
		String temp = "Abhyuday" ;
		test.AddEmployee("Dick", "Sushant");
		test.AddEmployee(temp, "Dick");
		test.AddEmployee(temp, "Harry");
		test.AddEmployee("Dick", "Sushant");
		test.tree.printTree();
		test.AddEmployee("Dick", "Kshitij");
		test.AddEmployee("Abhyuday", "Tom");
		test.tree.printTree();
		test.AddEmployee("Dick", "Appu");
		test.AddEmployee("Tom", "Sejal");
		test.tree.printTree();
		test.AddEmployee("Dick", "Bagga");
		test.AddEmployee("Tom", "Raghav");
		test.tree.printTree();
		test.AddEmployee("Tom", "Arsh");
		test.AddEmployee("Harry", "Jim");
		test.AddEmployee("Jim", "Kim");
		test.AddEmployee("Jim", "Tim");
		test.AddEmployee("Harry", "Pim");
		test.tree.printTree();
		System.out.println();
		test.getCommonBoss("Dick","Tom") ;
		test.getCommonBoss("Ron","Choot") ;
		test.getCommonBoss("Harry", "Tim");
		test.getCommonBoss("Tom", "Abhyuday");*/
		String filename = args[0] ;
		BufferedReader br ;
		try {
			br = new BufferedReader(new FileReader(filename)) ;
		}
		catch(FileNotFoundException e) {
			
			System.out.println("File could not be found. Please check the filename");
			return ;
		}
		int n = Integer.parseInt(br.readLine()) ;
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine()) ;
		String Employee = st.nextToken() ;
		String Boss = st.nextToken() ;
		CompanyStructure test = new CompanyStructure(Boss) ;
		try {
			test.AddEmployee(Boss, Employee);
		}
		catch(EmployeeNotFoundException e) {
			System.out.println(e.getMessage() + " not found. Please check name of the employee");
			return ;
		}
		for(int i = 0 ; i < n-1 ; i++) {
			st = new StringTokenizer(br.readLine()) ;
			Employee = st.nextToken() ;
			Boss = st.nextToken() ;
			try {
				test.AddEmployee(Boss,Employee);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage() + " not found. Please check name of the employee");
				return ;
			}
		}
		//test.tree.printTree() ;
		
		int q = Integer.parseInt(br.readLine()) ;
		int command;
		String Employee1, Employee2 ;
		for(int i = 0 ; i < q ; i++){
			st = new StringTokenizer(br.readLine()) ;
			command = Integer.parseInt(st.nextToken()) ;
			if(command == 3){
				test.tree.printTree() ;
			}
			else{
				Employee1 = st.nextToken() ;
				Employee2 = st.nextToken() ;
				if(command == 0){
					try {
						test.AddEmployee(Employee2,Employee1);
					}
					catch(EmployeeNotFoundException e) {
						System.out.println(e.getMessage() + " not found. Please check name of the employee");
						return ;
					}
				}
				else if(command == 1){
					try {
						test.DeleteEmployee(Employee1,Employee2);
					}
					catch(EmployeeNotFoundException e) {
						System.out.println(e.getMessage() + " not found. Please check name of the employee");
						return ;
					}
				}
				else if(command == 2){
					try {
						test.getCommonBoss(Employee2,Employee1);
					}
					catch(EmployeeNotFoundException e) {
						System.out.println(e.getMessage() + " not found. Please check name of the employee");
						return ;
					}
				}
				
				else{
					System.out.println("Error: Invalid Command.\n") ;
					return ;
				}
			}
			
		} 
		
		

	}
}
