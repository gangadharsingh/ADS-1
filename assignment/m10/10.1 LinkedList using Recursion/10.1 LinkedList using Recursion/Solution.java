import java.util.Scanner;
class LinkedList {
	class Node {
		int value;
		Node address;
		Node(int val) {
			value = val;
		}
	}
    Node head;
    int size;
    LinkedList() {
        head = null;
        size = 0;
    }
    public void insertAt(int pos, int ele) throws Exception{
        Node newNode = new Node(ele);
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        head = insertAt(pos, head, newNode, 0);
    }
    public Node insertAt(int pos, Node first, Node obj, int count) {
        if (pos == count) {
            obj.address = first;
            size++;
            return obj;
        }
        first.address = insertAt(pos, first.address, obj, count + 1);
        return first;
    }
    public void reverse() {
        reverse(null, head);
    }
    void reverse(Node previous, Node current) {
        if (current != null) {
            reverse(current, current.address);
            current.address = previous;
        } else {
            head = previous;
        }
    }
    void display() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.value+", ";
            temp = temp.address;
        }
        System.out.println(str.substring(0,str.length()-2));
    }
}
public final class Solution {
	private Solution() { }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] tokens = data.split(" ");
            switch (tokens[0]) {
                case "insertAt":
                try {
                    l.insertAt(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    l.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }
                break;
                case "reverse":
                try {
                    l.reverse();
                    l.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
                default:
                break;
            }
        }
	}
}
