//package Company ;

public class Leaf<E,V> {
	
	public E value ;
	public V location ;
	public Leaf<E,V> left,right ;
	
	Leaf(E entry,V location){
		this.value = entry ;
		this.location = location ;
	}
	Leaf() {
		this.value = null ;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
