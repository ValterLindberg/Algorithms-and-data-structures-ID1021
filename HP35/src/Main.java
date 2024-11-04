//import java.util.Stack;

public class Main {
	//Stack stack = new Stack(4);
	//int ip = -1;
	final static int EXPR_LENGTH = 9;
	Item[] expr = new Item[9];
	
	public static void main(String[] args) {
		int counter = 0;
		long t0 = System.nanoTime();
		long t1 = System.nanoTime();
		int sum = 0;
		
		Item[] e = new Item[EXPR_LENGTH];
		e[0] = new Item(4);
		e[1] = new Item(2);
		e[2] = new Item(Item.ItemType.MOD);
		e[3] = new Item(5);
		e[4] = new Item(3);
		e[5] = new Item(Item.ItemType.MOD);
		e[6] = new Item(Item.ItemType.MOD);
		e[7] = new Item(9);
		e[8] = new Item(Item.ItemType.MOD);
		
		
		for(int j = 9; j < e.length; j++) {
			if(j % 2 == 0) {
				e[j] = new Item(5);
			}
			else
				e[j] = new Item(4);
		}
		
		for(int i = 0; i < e.length; i++) {
			if(e[i] !=null) {
				counter++;
				sum += (t1 - t0);
			}
				
		}
		Item[] itemCopy = new Item[counter];
		
		for(int i = 0; i < counter; i++) {
			itemCopy[i] = e[i];
		}
		
		Calculator calc = new Calculator(itemCopy);
		System.out.println(calc.run());
		System.out.println("Resolution time: " + sum);
	}




/* public int run() {
	while ( ip < expr.length ) {
		step();
	}
	return stack.pop();
}

public void step() {
	

	Item nxt = expr[ip++];
	
	switch(nxt.getType()) {
	
	case ADD : {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x + y);
		break;
	}	
	case SUB : {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x - y);
		break;
	}
	case MUL : {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x * y);
		break;
	}
	case DIV : {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x / y);
		break;
	}
	case VALUE : {
		stack.push(nxt.getValue());
		break;
	}
   }
  } */
}
