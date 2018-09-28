import java.util.Scanner;
class Node {
	String value;
	Node address;
}
class Linkedlst {
	Node last, first;
	boolean isempty() {
		return first == null;
	}
	void pushLeft(String item) {
		Node oldfirst = first;
		first = new Node();
		first.value = item;
		first.address = oldfirst;
		if (first.address == null) {
			last = first;
		}
		/*print();*/
	}
	void pushRight(String item) {
		if (first == null && last == null) {
			pushLeft(item);
		} else {
		Node temp = new Node();
			temp.value = item;
			temp.address = null;
			last.address = temp;
			last = temp;
			if(first == null && last!=null){
				first = last;
			}
		/*print();*/
		}
	}
	void popLeft() {
		if (isempty()) {
			return;
		}
		first = first.address;
		/*print();*/
	}
	void popRight() {
		if (isempty()) {
			return ;
		}
		Node temp = first;
		while(temp.address.address != null) {
			temp = temp.address;
		}
		temp.address = null;
		last = temp;

		// print();
	}
	void size() {
		Node temp = first;
		int count = 0;
		while (temp.address != null) {
			count++;
			temp = temp.address;
		}
		System.out.println(++count);
	}
	void print() {
		if(first == null){
			System.out.println("empty linkedlist");
			return;
		}
		Node temp = first;
		System.out.print("[");
		while (temp.address != null) {
			System.out.print(temp.value+", ");
			temp = temp.address;
		}
		System.out.println(temp.value+"]");
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Linkedlst ll = new Linkedlst();
		int iteration = scan.nextInt();
		while (iteration >= 0) {
			String[] s = scan.nextLine().split(" ");
			if (s[0].equals("pushLeft")) {
				ll.pushLeft(s[1]);
				ll.print();
			} else if (s[0].equals("pushRight")) {
				ll.pushRight(s[1]);
				ll.print();
			} else if (s[0].equals("popRight")) {
				ll.popRight();
				ll.print();
			} else if (s[0].equals("popLeft")) {
				ll.popLeft();
				ll.print();
			} else if (s[0].equals("size")) {
				ll.size();
			}
			iteration--;
		}
	}
}
