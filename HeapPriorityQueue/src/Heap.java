import java.util.Random;
public class Heap {
	Node head;
	Node tail;
	Node smallest;
	Node previous;
	
	public static class Node{
		Integer value;
		Node next;
		public Node(Integer value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public Heap() {
		head = null;
		tail = head;
	}
	
	public static void add(Integer value, Heap list) {
		Node node = new Node(value);
		if(list.head == null) {
			list.head = node;
			list.smallest = list.head;
			return;
		}
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = node;
			list.tail = node;
			System.out.println(last.value + " added");
		}
		if(node.value < list.smallest.value) {
			list.smallest = node;
		}
	}
	
	public static void addAtTail(Integer value, Heap list) {
		Node node = new Node(value);
		
		if(list.head == null) {
			list.head = node;
			list.tail = node;
		}
		else {
			list.tail.next = node;
		}
		list.tail = node;
	}
	
	public static void printList(Heap list) {
		Node currentNode = list.head;
		
		if(list.head == null) {
			System.out.println("empty list");
		}
		else {
			System.out.println("List of items");
			while(currentNode != null) {
				System.out.println(currentNode.value);
				currentNode = currentNode.next;
			}
		}
	}
	
	public static Node findPrevious(Heap list, Node prev) {
		Node current = list.head;
		while(current.next != null) {
			if(current.next == prev) {
				return current;
			}
			else {
				current = current.next;
			}
		}
		return null;
	}
	
	public static void removeN(Heap list) {
		Node node = list.head;
		Node remove = list.head;
		
		if(list.head == null) {
			System.out.println("nothing to remove");
			return;
		}
		else {
			while(node != null) {
				if(node.value < remove.value) {
					remove = node;
					node = node.next;
				}
				else {
					node = node.next;
				}
			}
			System.out.println(remove.value + " removed");
			
		}
		list.previous = findPrevious(list, remove);
		list.previous.next = list.previous.next.next;
		remove = null;
	}
	
	public static void removeOne(Heap list) {
		System.out.println(list.smallest.value + " REMOVED");
		list.previous = findPrevious(list, list.smallest);
		list.previous.next = list.previous.next.next;
		
		Node searchSmallest = list.head;
		Node smallest = list.head;
		while(searchSmallest != null) {
			if(searchSmallest.value < smallest.value) {
				smallest = searchSmallest;
				searchSmallest = searchSmallest.next;
			}
			else {
				searchSmallest = searchSmallest.next;
			}
		}
		list.smallest = smallest;
		
	}
		
	public static void main(String[] args) {
		Heap list = new Heap();
		Random rnd = new Random();
		
		add(1000, list);
		add(3, list);
		add(2, list);
		add(195, list);
		add(200, list);
		add(5, list);
		add(10, list);
		add(15, list);
		add(20, list);
		add(25, list);
		add(30, list);
		add(35, list);
		add(40, list);
		add(90, list);
		add(100, list);
		add(50, list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		removeOne(list);
		
		
		printList(list); 
	/*	long t0 = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			addAtTail(rnd.nextInt(50000), list);
		}
		addAtTail(40, list);
		addAtTail(45, list);
		addAtTail(50, list);
		addAtTail(55, list);
		addAtTail(15, list);
		addAtTail(25, list);
		addAtTail(10, list);
		addAtTail(60, list); 
		addAtTail(70, list);
		addAtTail(100, list);
		long t1 = System.nanoTime();
		long total = (t1 - t0);
		printList(list); 
		System.out.println(total + " ns"); */
		
		/*removeN(list);
		removeN(list);
		removeN(list);
		//removeN(list);
		printList(list);*/
		/*System.out.println(list.previous.value + " prev value\n " +
		"addAtTail time: " + total + " ns"); */
		//System.out.println(list.smallest.value + " smallest");
	}

}
