package executable;

public class Node {
	private Game value;
	private Node next;
	
	public Game getValue() {
		return value;
	}

	public void setValue(Game value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
