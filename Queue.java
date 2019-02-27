//package Company ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


 
// Implemented Stack

public class Queue<E> {
	
	public DLinkedList<E> queue = new DLinkedList<E>() ;
	public int size ;
	
	
	Queue(){
		this.size = 0 ;
	}
	Queue(E entry){
		this.queue.insertLast(entry) ;
		this.size = 1 ;
			
	}
	
	public void enqueue(E entry) {
		
		queue.insertLast(entry);
		this.size++ ;
		
		
	}
	
	public E dequeue() {
		if(isEmpty()) {
			return null ;
		}
		size-- ;
		return queue.removeFirst() ;
		
		
	}
	
	public int size() {
		return size ;
	}
	public boolean isEmpty() {
		return size == 0 ;
	}
	
	public E topElement() {
		if(isEmpty()) {
			return null ;
		}
		return queue.first() ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> test = new Queue<Integer>() ;
		test.enqueue(10) ;
		test.enqueue(20) ;
		test.enqueue(40) ;
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		test.enqueue(80) ;
		test.enqueue(30) ;
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());

	}

}
