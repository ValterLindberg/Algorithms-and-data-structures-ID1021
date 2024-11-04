import java.util.Random;
import java.util.Iterator;
public class BinaryTree implements Iterable<Integer> {

	public static class Node{
		public Integer key;
		public Integer value;
		public Node left, right;
		
		public Node(Integer key, Integer value) {
			this.key = key;
			this.value = value;
			this.left = this.right = null;
		}
		
		public void print() {
			if(left != null) {
				left.print();
			}
			System.out.println(" key: " + key + "\tvalue: " + value);
			if(right != null) {
				right.print();
			}
		}
	}
	public static class TreeIterator implements Iterator<Integer>{
		private Node next;
		private Stack<Node> stack;
		BinaryTree tree = new BinaryTree();
		Integer counter = -1;
		Integer index = 0;
		public TreeIterator() {
			next = root;
			stack = new Stack(12);
		}
		
		@Override
		public boolean hasNext() {
			if(stack.array[index] != null) {
				System.out.println("true");
				return true;
			}
			else {
				System.out.println("false");
				return false;
			}
		}
		public void inOrder(Node next) {
			if(next == null) return;
			inOrder(next.left);
			tree.add(next.key, next.value, root);
			if(stack.full()) {
				stack.push(next);
			}
			stack.push(next);
			System.out.println(next.value);
			inOrder(next.right);

		}
		
		@Override
		public Integer next() {
			System.out.println("value: " + stack.array[index].value);
			//System.out.println(stack.array[0].value);
			return stack.array[index++].value;
			
			
			/*if(next != null) {
				stack.push(next);
				counter++;
				next = next.left;
				next();
			}
			counter--;
			stack.pop(next);
			next = Stack.array[counter];
			if(next != null) {
				next = next.right;
				stack.push(next);
				counter++;
				next();
			}
			return next.value; */
			
			
			
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
	static Node root;
	
	public BinaryTree() {
		/*Random rnd = new Random();
		Integer n = rnd.nextInt(500000);
		root = new Node(n, n*10); */
		root = new Node(5, 105);
	} 
	
	public Iterator<Integer> iterator(){
		return new TreeIterator();
	} 
	
	static void add(Integer key, Integer value,Node root){
		
		if(key < root.key) {
			if(root.left != null) {
				add(key, value, root.left);
			}
			else {
				System.out.println(value + " added to the left of " + root.value);
				root.left = new Node(key, value);
			}
			
		}
		else if(key > root.key){
			if(root.right != null) {
				add(key, value, root.right);
			}
			else {
				System.out.println(value + " added to the right of " + root.value);
				root.right = new Node(key, value);
			}
		}
		
			
			//System.out.println("keys are the same size, no node added");
		
		
	}
	
	static Integer lookup(Integer key, Node root) {
		while(root != null) {
		if(key == root.key) {
			System.out.println("key found " + root.value);
			return root.value;
		}
		if(key < root.key) {
			System.out.println("searching to the left...");
			return lookup(key, root.left);
		}
		if(key > root.key) {
		System.out.println("searching to the right...");
		 return lookup(key, root.right);
		}
		}
		
		System.out.println("key is null");
		return null;
		
		
	}
	
	public static void constructTree() {
		BinaryTree tree = new BinaryTree();
		//Node root = new BinaryTree.Node(5, 105);
		/*Random random = new Random();
		Integer[] rnd = new Integer[500];
		Integer n = random.nextInt(3000);
		root = new Node(n, n*10);
		for(int i = 0; i < rnd.length; i++) {
			rnd[i] = random.nextInt(50000);
		}
		int j = 0;
		while(j < rnd.length) {
			tree.add(rnd[j], rnd[j]*10, root);
			j++;
		} */
		
		
		add(1, 101, root);
		add(17, 117, root);
		add(3, 103, root);
		add(4, 104, root);
		add(8, 108, root);
		add(0, 100, root);
		add(16, 116, root);
		add(7, 107, root);
		add(6,106, root);
		add(25, 125, root);
		add(23, 123, root);
		add(24, 124, root); 
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		//constructTree();
		BinaryTree.TreeIterator iterator = new TreeIterator();
		tree.add(1, 101, root);
		tree.add(17, 117, root);
		tree.add(3, 103, root);
		tree.add(4, 104, root);
		tree.add(8, 108, root);
		tree.add(0, 100, root);
		tree.add(16, 116, root);
		tree.add(7, 107, root);
		tree.add(6,106, root);
		tree.add(25, 125, root);
		tree.add(23, 123, root);
		tree.add(24, 124, root);
		
		
		tree.add(26, 126, root);
		tree.add(30, 130, root);
		tree.add(35, 135, root);
		tree.add(2, 102, root);
		tree.add(14, 114, root);
		
		
		iterator.inOrder(root);		
		/*iterator.stack.pop(Stack.array[16]);
		iterator.stack.pop(Stack.array[15]);
		iterator.stack.pop(Stack.array[14]); */
		tree.add(36, 136, root);
		BinaryTree.Node node = new BinaryTree.Node(36, 136);
		iterator.inOrder(node);
		
		for(int i = 0; i < 18; i++) {
			iterator.next();
		}
	/*	for(int i : tree) {
			System.out.println(iterator.next());
		}*/
		iterator.hasNext();
		
		
		
		//System.out.println(iterator.next() + "");
		
		
		/*Stack p = new Stack(5);
		BinaryTree.Node node = new BinaryTree.Node(1, 101);
		
		for(int i = 0; i < 7; i++) {
			p.push(node);
			node.key++;
			node.value++;
		} */
		System.out.print("jag älskar dig mest av allt valter <3333333333");
		
		//Node root = new BinaryTree.Node(5, 105);
		/*long t0 = System.nanoTime();
		lookup(1, root);
		long t1 = System.nanoTime();
		long totalTime = (t1 - t0);
		System.out.println("lookup resolution time " + totalTime + " ns");*/
	}
	
}

