
public class Stack<T> {
	Integer size;
	static BinaryTree.Node[] array;
	static Integer pointer;
	
	public Stack(Integer size) {
		this.size = size;
		this.array = new BinaryTree.Node[size];
		this.pointer = -1;
	}
	
	public boolean empty() {
		return (pointer == -1);
	}
	
	public boolean full() {
		return (size-1 == pointer);
	}
	
	
	
	public void push(BinaryTree.Node x) {
		if(full()) {
			System.out.println("Stack overflow, stack size increaed");
			biggerStack();
		}
		else {
			array[++pointer] = x;
			System.out.println(x.value + " pushed onto stack");
		}
	}
	
	public void pop(BinaryTree.Node y) {
		if(empty()) {
			System.out.println("the stack is empty");
		}
		y = array[pointer];
		pointer--;
		System.out.println(y.value + " popped off the stack");
	}
	
	private void biggerStack() {
		BinaryTree.Node[] newStack = new BinaryTree.Node[size*2];
		for(int i = 0; i < size; i++) {
			newStack[i] = array[i];
		}
		array = newStack;
		size = size*2;
	}
	
	public BinaryTree.Node check() {
		return array[pointer];
	}
	
}
