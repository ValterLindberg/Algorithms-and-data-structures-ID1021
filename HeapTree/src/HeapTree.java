
public class HeapTree {
	static Node head;
	static int sizeLeft, sizeRight = 0;
		
	static int sizeLeftLeft, sizeRightRight = -1;
	static int sizeLeftRight,sizeRightLeft = 0; 
	
	
	public static class Node{
		Integer value;
		Integer priority;
		Node left, right;
		int count;
		public Node(Integer value, Integer priority){
			this.value = value;
			this.priority = priority;
			this.left = this.right = null;
			count = 0;
		}
	}
	
	public HeapTree() {
		head = new Node(1, 10);
	}
	
	public static void add(Integer value, Integer priority, Node root) {
		Node currentNode = new Node(value, priority);
		
	/*	if(head == null) {
			System.out.println("New root: " + root.value);
			head = currentNode;
		} */	
		
	
		
		
		
		while(root != null) {
			if(root.left == null) {
				System.out.println(value + " left of " + root.value);
				root.left = new Node(value, priority);
				return;
			}
			else {
				add(value, priority, root.left);
				
			}
			
			if(root.right == null) {
				System.out.println(value + " right of " + root.value);
				root.right = new Node(value, priority);
				return;
			}
			else {
				add(value, priority, root.right);
				return;
			}
		}
		
		
		
		
		
	/*	if(sizeLeft <= sizeRight) {
			if(sizeLeftLeft <= sizeLeftRight) {
				if(root.left != null) {
					add(value, priority, root.left);
				}
				else {
					System.out.println(value + " added left of " + root.value);
					root.left = new Node(value, priority);
					sizeLeft++;
					sizeLeftLeft++;
				}
			}
			else {
				if(root.right != null) {
					add(value, priority, root.right);
				}
				else {
					System.out.println(value + " added right of " + root.value);
					root.right = new Node(value, priority);
					sizeLeft++;
					sizeLeftRight++;
				}
			}
		}
		else if (sizeRight < sizeLeft) {
			if(sizeRightRight <= sizeRightLeft) {
				if(root.right != null) {
					add(value, priority, root.right);
				}
				else {
					System.out.println(value + " added right of " + root.value);
					root.right = new Node(value, priority);
					sizeRight++;
					sizeRightRight++;
				}
			}
			else {
				if(root.left != null) {
					add(value, priority, root.left);
				}
				else {
					System.out.println(value + " added left of " + root.value);
					root.left = new Node(value, priority);
					sizeRight++;
					sizeRightLeft++;
				}
			}
		} */
		
	}
	
	public static void swap(Node first, Node second) {
		Node temp = first;
		first = second;
		second = temp;
	}
	
	public static void main(String[] args) {
		HeapTree tree = new HeapTree();
		
		add(5, 50, head);
		add(10, 100, head);
		add(15, 150, head);
		add(20, 200, head);
		add(30, 300, head);
		add(35, 350, head);
		add(40, 400, head);
		add(45, 450, head);
		add(50, 500, head);
		
	}

}
