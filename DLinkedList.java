//package Company ;

public class DLinkedList<E> {
	
	private DNode<E> head = new DNode<E>(null) ;
	private DNode<E> tail = new DNode<E>(null) ;
	private int size ;
	
	DLinkedList(){
		this(null) ;
		this.size = 0 ;
	}
	
	DLinkedList(DNode<E> node){
		if(node == null) {
			this.head.setNext(this.tail) ;
			this.tail.setPrev(this.head) ;
			this.size = 0 ;
			return ;
		}
		this.head = node ;
		int temp = 0 ;
		DNode<E> temp2 = node ; 
		
		while(temp2.getNext() != null) {
			temp2 = temp2.getNext();
			temp++ ;
		}
		this.head.setNext(node) ;
		this.tail.setPrev(temp2) ;
		this.size = temp ;
		return ;
	}
	
	public void insertFirst(E entry) {
		DNode<E> temp = head.getNext() ;
		head.setNext(new DNode<E>(entry));
		head.getNext().setPrev(head);
		head.getNext().setNext(temp);
		temp.setPrev(head.getNext());
		size++ ;
		return ;
		
	}
	
	public void insertLast(E entry) {
		DNode<E> temp = tail.getPrev() ;
		tail.setPrev(new DNode<E>(entry));
		tail.getPrev().setNext(tail);
		tail.getPrev().setPrev(temp);
		temp.setNext(tail.getPrev());
		size++ ;
		return ;
		
	}
	
	public E removeFirst() {
		if(size == 0) {
			return null ;
		}
		DNode<E> temp = head.getNext() ;
		head.setNext(temp.getNext());
		temp.getNext().setPrev(head);
		temp.setNext(null);
		temp.setPrev(null);
		size-- ;
		return temp.getData() ;
	}
	
	public E removeLast() {
		if(size == 0) {
			return null ;
		}
		DNode<E> temp = tail.getPrev() ;
		tail.setPrev(temp.getPrev());
		temp.getPrev().setNext(tail);
		temp.setNext(null);
		temp.setPrev(null);
		size-- ;
		return temp.getData() ;
	}
	
	public E first() {
		if(size == 0) {
			return null ;
		}
		return head.getNext().getData();
	}
	
	public E last() {
		if(size == 0) {
			return null ;
		}
		return tail.getPrev().getData();
	}
	
	public DNode<E> getHead() {
		return head ;
	}
	public DNode<E> getTail() {
		return tail ;
	}
	public int getSize() {
		return size ;
	}
	public void setSize(int x){
		size = x ;
		return ;
	}
	
	public void printList() {
		if(size == 0) {
			System.out.println("Empty List");
			return ;
		}
		DNode<E> temp = head.getNext() ;
		while(temp != tail) {
			System.out.print(temp.getData().toString() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DLinkedList<Integer> test = new DLinkedList<Integer>() ;
		test.insertFirst(10);
		test.insertFirst(30);
		test.insertLast(20);
		test.insertFirst(40);
		test.insertLast(50);
		test.insertLast(60);
		test.printList();
		System.out.println(test.removeFirst());
		test.printList();
		System.out.println(test.first());
		test.printList();
		System.out.println(test.removeLast());
		test.printList();
		System.out.println(test.removeLast());
		test.printList();
		System.out.println(test.last());
		test.printList();
		System.out.println(test.removeLast());
		test.printList();
		System.out.println(test.removeLast());
		test.printList();

	}

}
