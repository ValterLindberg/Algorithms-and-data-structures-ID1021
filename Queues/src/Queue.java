import java.util.Iterator;
public class Queue {

	static Node head;
	Node tail;
	
	public static class Node{
		public Integer item;
		public Node next;
		public Node left, right;
		
		public Node(Integer item) {
			this.item = item;
			this.next = null;
			this.left = this.right = null;
		}
	}
	
	public Queue() {
		head = null;
		tail = null;
	} 
	
	public static class BinaryTree{
		Node root;
		
		public BinaryTree(){
			root = head;
		}
		
		void addTreeNode(Integer value, Node root) {

			if(value < root.item) {
				if(root.left != null) {
					addTreeNode(value, root.left);
				}
				else {
					System.out.println(value + " added to the left of " + root.item);
					root.left = new Node(value);
				}
			}
			
			else if(value > root.item) {
				if(root.right != null) {
					addTreeNode(value, root.right);
				}
				else {
					System.out.println(value + " added to the right of " + root.item);
					root.right = new Node(value);
				}
			}
		}
		
		void printNodeAtLevel() {
			Integer h = treeHeight(root);
			for(int i = 1; i <= h; i++) {
				printAtLevel(root, i);
			}
		}
		
		Integer treeHeight(Node root) {
			if(root == null) {
				return 0;
			}
			else {
				Integer leftHeight = treeHeight(root.left);
				Integer rightHeight = treeHeight(root.right);
				
				if(leftHeight > rightHeight)
					return (leftHeight + 1);
				else
					return (rightHeight + 1);
			}
		}
		
		void printAtLevel(Node root, Integer level) {
			if(root == null)
				return;
			
			if (level == 1)
				System.out.println(root.item + " ");
			else if(level > 1) {
				printAtLevel(root.left, level-1);
				printAtLevel(root.right, level-1);
			}
		}
		
		public boolean hasNext() {
			return root.next != null;
		}
		
		public Integer next() {
			return 1;
		}
	}
	
	
	public Queue add(Integer item, Queue list) {
		Node node = new Node(item);
		//if list is empty
		if(list.head == null) {
			list.head = node;
		}
		else {
			Node last = list.head;
		
			while(last.next != null) {
				last = last.next;
			}
			last.next = node;
			tail = node;
		}
		return list;
	}
	public static void printList(Queue list) {
		Node currNode = list.head;
		
		if(currNode == null) {
			System.out.println("list is empty");
			return;
		}
		
		System.out.println("Linked list: ");
		while(currNode != null) {
			System.out.println(currNode.item + " ");
			currNode = currNode.next;
		}
	}
	
	public boolean empty(Queue list) {				
		if(list.head == null) {
			//System.out.println("empty");
			return false;
		}
		else {
			//System.out.println("not empty");
			return true;
		} 
	}
	
	public Integer remove(Queue list) {
		//removes head node of the queue
		if(!empty(list)) {
			System.out.print("nothing to remove\n");
			return null;
		}
		else {
			Node r = list.head;
			Node next = r.next;
			while(r != null) {
				r = null;
			}
			list.head = next;
			return list.head.item;
		}
	}
	
	public Integer addAtTail(Integer item, Queue list) {
		tail.next = new Node(item);
		tail = tail.next;
		return tail.item;
	}
	
	public Node getHead(Queue list) {
		System.out.println("head of the queue : " + head.item);
		return list.head;
	}
	
	public Node getTail(Queue list) {
		System.out.println("tail of the queue: " + tail.item);
		return list.tail;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		
		long t0 = System.nanoTime();
		for(int i = 1; i < 11; i++) {
			q.add(i*2, q);
		}
		long t1 = System.nanoTime();
		
		printList(q);
		long totalTime = (t1 - t0);
		System.out.println("add operation time: " + totalTime + " ns");
		
		Queue.BinaryTree tree = new Queue.BinaryTree();
		Queue.head.item = 10;
		tree.addTreeNode(12,head);
		tree.addTreeNode(2, head);
		tree.addTreeNode(4,head );
		tree.addTreeNode(10, head);
		tree.addTreeNode(16, head);
		tree.addTreeNode(14, head);
		tree.addTreeNode(6,head );
		tree.addTreeNode(20, head);
		tree.addTreeNode(18, head);
		tree.addTreeNode(22, head);
		tree.addTreeNode(8, head);
		tree.addTreeNode(1, head);
		tree.addTreeNode(3, head);
		tree.addTreeNode(5, head);
		tree.addTreeNode(30, head);
	
		System.out.println("Breadth first traversal of " +
							"binary tree");
		tree.printNodeAtLevel(); 
		
	}

}

