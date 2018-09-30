class Node {
	String value;
	Node address;
}
public class LinkedList {
	LinkedList() {
		// System.out.println("linkedlist");
	}
	Node last, first;
	int size = 0;
	boolean isempty() {
		return first == null;
	}
	void pushstart(String item) {
		// System.out.println("pushstart");
		Node oldfirst = first;

		first = new Node();
		first.value = item;
		first.address = oldfirst;
		if (first.address == null) {
			last = first;
		}
		size++;
	}
	void pushend(String item) {
		// System.out.println("item:"+item);
		// System.out.println("pushend");
		if (last == null && first == null) {
			// System.out.println("(pushend)pushstart:");
			pushstart(item);
		} else {
			Node temp = new Node();
			temp.value = item;
			temp.address = null;
			last.address = temp;
			last = temp;
			if (first == null && last != null) {
				first = last;
			}
			size++;
		}
	}
	String popstart() {
		if (isempty()) {
			return null;
		}
		String popitem = first.value;
		first = first.address;
		size--;
		// System.out.println("popitem:"+popitem);
		return popitem;
	}
	String popend() {
		//System.out.println("popend");
		if (isempty()) {
			return null;
		} else {
			String popitem = last.value;
			Node temp = first;
			while (temp != last) {
				temp = temp.address;
			}
			temp.address = null;
			last = temp;
			size--;
		// System.out.println("popitem"+popitem);
			return popitem;
		}
	}
	public Node getfirst() {
		return first;
	}
	public void setfirst(Node frst) {
		first = frst;
	}

	public int getsize() {
		return size;
	}

	public void setsize(int sz) {
		size = sz;
	}
	String print() {
		// System.out.println("print");
		if (first == null) {
			// System.out.println("empty linkedlist");
			return null;
		}
		// System.out.println("1");
		Node temp = first;
		// System.out.println("2");
		String str = "";
		// System.out.println("3");
		while (temp.address != null) {
			// System.out.println("4");
			str += temp.value;
			// System.out.println("5");
			temp = temp.address;
			// System.out.println("6");
		}
		// System.out.println("7");
		str += temp.value;
		// System.out.println("8");
		return str;
	}
}
