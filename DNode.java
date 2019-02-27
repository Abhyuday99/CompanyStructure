//package Company ;

public class DNode<E> {
	
	private E data ;
	private DNode<E> next ;
	private DNode<E> prev ;
	
	public DNode( E entry) {
		this.data = entry ;
		this.next = null ;
		this.prev = null ;
		
	}
	public E getData() {
		return data ;
	}
	public void setData(E entry) {
		 data = entry ;
	}
	public DNode<E> getNext() {
		return next ;
	}
	public void setNext(DNode<E> entry) {
		next = entry ;
	}
	public DNode<E> getPrev() {
		return prev ;
	}
	public void setPrev(DNode<E> entry) {
		prev = entry ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
