import java.util.Random;
public class LinkedList {
	static Node head;
	LinkedList tail;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static LinkedList insertNode(int data, LinkedList list) {
		Node node = new Node(data);
		
		if(list.head == null) {
			list.head = node;
		}
		else {
			Node last = list.head;
			
			while(last.next != null) {
				last = last.next;
			}
			last.next = node;
		}
		return list;
	}
	
	public static void printList(LinkedList list) {
		Node currNode = list.head;
		
		System.out.println("Linked List: ");
		
		while(currNode != null) {
			System.out.println(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	public static  void append(LinkedList b) {
		Node node = new Node(50);
		node.next = null;
		if(head == null) {
			System.out.println("empty list");
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			//return node;
		}
	}
	
	public static int[] appendArray(int[] a, int[] b) {
		int[] extendedArray = new int[a.length + b.length];
		
		long t0 = System.nanoTime();
		for(int i = 0; i < a.length; i++) {
			extendedArray[i] = a[i];
		}
		int index = 0;
		for(int j = a.length; j < a.length+b.length; j++) {
			extendedArray[j] = b[index];
			index++;
		}
		long t1 = System.nanoTime();
		long time = (t1 - t0);
		
		
		 for(int k = 0; k < a.length+b.length; k++) {
			System.out.println(extendedArray[k]);
		} 
		
		System.out.println("appendArray resolution time: " + time + " ns");
		
		return extendedArray;
	}
	
	public static void main(String[] args) {
	/*	int[] n = new int[100];
		int[] k = new int[8000];
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		
		
		  for(int i = 0; i < n.length; i++) {
			list1 = insertNode(i, list1);
		}
	
		for(int j = 0; j < k.length; j++) {
			list2 = insertNode(n.length + 1 + j, list2);
		}
		long t0 = System.nanoTime();
		append(list2);
		long t1 = System.nanoTime();
		long totalTime = (t1 - t0);
		printList(list1);
		System.out.println(totalTime + " ns"); */
		
		/*for(int i = 0; i < n.length; i++) {
			n[i] = i;
		}
		int ind = 0;
		for(int j = n.length; j < n.length+k.length; j++) {
			k[ind] = j;
			ind++;
		}
		
		appendArray(n,k); */
		LinkedList list = new LinkedList();
		for(int f = 0; f < 20; f++) {
			insertNode(f, list);
		}
		printList(list);
	}

}
