import java.util.Scanner;
import java.util.Arrays;
class LinkList{
	private Node firstelem = null;
	LinkList() {
	}
	class Node{
		String element;
		Node nextaddress;
	}
	boolean isempty(){
		return firstelem == null;
	}
	void push(String item) {
		Node oldfirst = firstelem;
		firstelem = new Node();
		firstelem.element = item;
		firstelem.nextaddress = oldfirst;
	}
	String pop(String str) {
		if (isempty() || str != firstelem.element) {
			return null;
		}
		String popitem = firstelem.element;
		firstelem = firstelem.nextaddress;
		return popitem;
	}
}
public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkList ll = new LinkList();
		while(scan.hasNext()) {
			String[] s = scan.nextLine().split("\n");
			int a = 0;
			int b = 0;
			String[] newstring = new String[s.length];
			for (String str: s) {
				String[] semp = str.split("");
				for (String se: semp) {
					if (semp.equals(")") || semp.equals("}") || semp.equals("]")) {
						a++;
					} else if (semp.equals("(") || semp.equals("{") || semp.equals("[")) {
						b++;
					}
					if (a == b) {
						if (semp.equals(")") || semp.equals("}") || semp.equals("]")) {
							ll.pop(se); 
						} else if(semp.equals("(") || semp.equals("{") || semp.equals("[")) {
							ll.push(se);
						}
					}
					}
			}
		}
		System.out.println(ll.isempty());
	}
}
