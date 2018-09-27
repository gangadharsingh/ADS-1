class Linkedlist {
	private Node firstelement = null;
	private class Node {
		char item;
		Node nextAddress;
	}
	public char topelement() {
		return firstelement.item;
	}

	public boolean isEmpty() {
		return firstelement == null;
	}
	public void push(char item) {
		Node oldfirst = firstelement;
		firstelement = new Node();
		firstelement.item = item;
		firstelement.nextAddress = oldfirst;
	}
	public char pop() {
		char item = firstelement.item;
		firstelement = firstelement.nextAddress;
		return item;
	}
}