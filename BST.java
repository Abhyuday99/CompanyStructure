//package Company ;
public class BST<E extends Comparable<E>,V> {
	
	public Leaf<E,V> root ;
	public int size ;
	
	BST() {
		this.root = null ;
		this.size = 0 ;
	}
	BST(E entry,V location) {
		
		this.root = new Leaf<E,V>(entry,location) ;
		this.size = 1 ;
	}
	
	public Leaf<E,V> addX(E entry,V location,Leaf<E,V> root) {
		
		if(root == null) {
			return new Leaf<E,V>(entry,location) ;
		}
		
		if(entry.compareTo(root.value) < 0) {
			root.left = addX(entry,location,root.left) ;
		}
		else {
			root.right = addX(entry,location, root.right) ;
		}
		
		return root ;
		
	}
	public void add(E entry,V location) {
		size++ ;
		root = addX(entry,location,root) ;
		return ;
	}
	public Leaf<E,V> search(E entry){
		
		Leaf<E,V> temp = root ;
		while(true) {
			if(temp == null) {
				return null ;
			}
			if(entry.compareTo(temp.value) < 0) {
				temp = temp.left ;
			}
			else if(entry.compareTo(temp.value) > 0) {
				temp = temp.right ;
			}
			else {
				return temp ;
			}
			
		}
	}
	public static <E,V> void preorder(Leaf<E,V> root) {
		
		if(root == null) {
			return  ;
		}
		preorder(root.right) ;
		System.out.println(root.value);
		preorder(root.left) ;
		
		return ;
	}
	
	
	public static <E,V> int height(Leaf<E,V> root) {
		
		if(root == null) {
			return 0 ;
		}
		int rightheight = BST.height(root.right) ;
		int leftheight = BST.height(root.left) ;
		return Math.max(rightheight ,leftheight) + 1 ;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
