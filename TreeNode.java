//package Company ;

public class TreeNode<E extends Comparable<E>> {
	
	public E data ;
	public DLinkedList<TreeNode<E>> childs = new DLinkedList<TreeNode<E>>() ;
	public TreeNode<E> parent ;
	public int no_of_children ;
	
	TreeNode() {
		this.data = null ;
		this.parent = null ;
		this.no_of_children = 0 ;
	}
	
	TreeNode(E entry){
		this.data = entry ;
		this.parent = null ;
		this.no_of_children = 0 ;
	}
	TreeNode(E entry, TreeNode<E> p){
		this.data = entry ;
		this.parent = p ;
		this.no_of_children = 0 ;
	}
	
	public  void insertNode(E parent,E entry) {
		TreeNode<E> temp = searchNode(parent) ;
		if(temp == null) {
			System.out.println("Parent not found");
			return ;
		}
		TreeNode<E> toAdd = new TreeNode<E>(entry,temp) ;
		System.out.println("Parent found");
		temp.childs.insertFirst(toAdd);
		no_of_children++ ;
	}
	
	public TreeNode<E> searchNode(E query) {
		if(data.compareTo(query) == 0) {
			return this ;
		}
		Queue<TreeNode<E>> q = new Queue<TreeNode<E>>() ;
		q.enqueue(this) ;
		TreeNode<E> temp,temp2 ;
		DNode<TreeNode<E>> cursor ;
		while(!q.isEmpty()) {
			temp = q.dequeue();
			cursor = temp.childs.getHead().getNext();
			while(cursor != temp.childs.getTail()) {
				temp2 = cursor.getData() ;
				if(temp2.data.compareTo(query) == 0) {
					return temp2 ;
				}
				q.enqueue(temp2) ;
				cursor = cursor.getNext();
			}
			
		}
		return null ;
	}
	
	public void deleteNode(E toDelete,E newParent) {
		Queue<TreeNode<E>> q = new Queue<TreeNode<E>>() ;
		q.enqueue(this) ;
		TreeNode<E> temp,temp2 ;
		DNode<TreeNode<E>> cursor,temp3 = null,temp4 = null ;
		boolean flag = true ;
		while(flag && !q.isEmpty()) {
			temp = q.dequeue();
			cursor = temp.childs.getHead();
			while(cursor.getNext() != temp.childs.getTail()) {
				temp2 = cursor.getNext().getData() ;
				if(temp2.data.compareTo(toDelete) == 0) {
					temp3 = cursor ;
				}
				if(temp2.data.compareTo(newParent) == 0) {
						temp4 = cursor ;
				}
				if(temp3 != null && temp4 != null) {
					flag = false ;
					break ;
				}
				
				q.enqueue(temp2) ;
				cursor = cursor.getNext();
			}
			if(flag) {
				System.out.println("Error: invalid name of Employee");
				return ;
			}
			
			
		}
	}
	
	
	public void printTree() {
		Queue<TreeNode<E>> q = new Queue<TreeNode<E>>() ;
		q.enqueue(this) ;
		TreeNode<E> temp,temp2 ;
		DNode<TreeNode<E>> cursor ;
		while(!q.isEmpty()) {
			temp = q.dequeue();
			System.out.print(temp.data + " ");
			cursor = temp.childs.getHead().getNext() ;
			while(cursor != temp.childs.getTail() ){
				temp2 = cursor.getData() ;
				q.enqueue(temp2) ;
				cursor = cursor.getNext();
			}
		}
		System.out.println() ;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Employee> test = new TreeNode<Employee>(new Employee("Abhyuday",1)) ;
		test.printTree();
		Employee temp =  new Employee("Abhyuday",2) ;
		test.insertNode(temp, new Employee("Dick",2));
		test.insertNode(new Employee("Dick",2), new Employee("Sushant",3));
		test.printTree();
		test.insertNode(new Employee("Dick",2), new Employee("Kshitij",3));
		test.printTree();
		test.insertNode(new Employee("Kshitij",3), new Employee("Kashvi",4));
		test.insertNode(temp, new Employee("Tom",2));
		test.printTree();

	}

}
