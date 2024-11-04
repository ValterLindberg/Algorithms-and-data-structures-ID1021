
public class Stack {
	int size;
	int[] array;
	int ip;
	
	public Stack(int size) {
		this.size = size;
		this.array = new int[size];
		this.ip = -1;
	}
	
	public boolean empty() {
		return (ip == -1);
	}
	
	public boolean full() {
		return (size-1 == ip);
	}
	
	public void push(int x) {
		/* if(ip == array.length) {
			int[] newStack = new int[array.length*2];
			for(int i = 0; i < array.length; i++) {
				newStack[i] = array[i];
			}
		} */
			
		if(full()) {
			System.out.println("Stack overflow");
			biggerStack();
			System.out.println("Stack size increased");
		}
		else {
			array[++ip] = x;
			System.out.println(x + " pushed onto stack");
		}
		
	}
	
	public int pop() {
		 /* if(ip < array.length/2-1) {
			int[] newStack = new int[(array.length/2)];
			for(int i = 0; i < array.length/2; i++) {
				newStack[i] = array[i];
			}
		} */
		
		if(empty()) {
			System.out.println("The stack is empty");
			return -1;
		}
		else {
		    int y = array[ip];
			ip--;
			System.out.println(y + " popped");
			return y;
		}
		
	}
	
	private void biggerStack() {
		int[] newStack = new int[size*2];
		for(int i = 0; i<size; i++) {
			newStack[i] = array[i];
		}
		array = newStack;
		size = size*2;
	}
	
	public int check() {
		return array[ip];
	}
}
