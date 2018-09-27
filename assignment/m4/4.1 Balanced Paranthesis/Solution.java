import java.util.Scanner;
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
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		while (size > 0) {
			String input = sc.next();
			if(checkParanthesis(input)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			size--;
		}
	}
	public static boolean checkParanthesis(String str) {
		Linkedlist obj = new Linkedlist();
		int strLength = str.length();
		for (int i = 0; i < strLength; i++) {
			char character = str.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				obj.push(character);
			}
			else {
				if(obj.isEmpty()) return false;
				if (character == ')' && obj.topelement() == '(') {
				obj.pop();
			} else if (character == '}' && obj.topelement() == '{') {
				obj.pop();
			} else if (character == ']' && obj.topelement() == '[') {
				obj.pop();
			} else return false;
		}
	}
	return obj.isEmpty();
}
}
