
public class Item {
	private ItemType type;
	private int value = 0;
	
	public Item(int v) {
		this.value = v;
		this.type = ItemType.VALUE;
	}
	
	public Item(ItemType t) {
		this.value = 0;
		this.type = t;
	}
	
	public enum ItemType {
		ADD,
		SUB,
		MUL,
		DIV,
		VALUE,
		MOD
	}
	
	public int getValue() {
		return this.value;
	}
	
	public ItemType getType() {
		return this.type;
	}
}
