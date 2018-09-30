import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * {Variable first of node type}.
     */
    private Node start;
    /**
     * {Variable last of node type}.
     */
    private Node end;
    /**
     * {Variable last of node type}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable item of type integer}.
         */
        private int item;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {

        this.start = null;
        this.end = null;
        this.size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int getSize() {

        return size;
    }
    /**
     * Pushes a front.
     *
     * @param      int1  The int 1
     */
    public void pushFront(final int int1) {
        if (start == null) {
            start = new Node();
            start.item = int1;
            start.next = null;
            end = start;
        } else {
            Node oldstart = start;
            start = new Node();
            start.item = int1;
            start.next = oldstart;
        }
        size++;
    }

    /**
     * Pushes a back.
     *
     * @param      item1  The item 1
     */
    public void pushBack(final int item1) {

        if (end == null) {
            end = new Node();
            end.item = item1;
            end.next = null;
        } else {
            Node oldend = end;
            end = new Node();
            end.item = item1;
            end.next = null;
            oldend.next = end;
        }
        size++;
    }
    /**
     * { remove front element}.
     */
    public void popFront() {

        if (start != null) {
            start = start.next;
            size--;
        }
    }
    /**
     * { for removing last elements}.
     */
    public void popBack() {

        if (end != null) {
            Node old = start;
            while (old.next.next != null) {
                old = old.next;
            }
            old.next = null;
            end = old;
            size--;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {

        if (size == 0) {
            return "[]";
        } else {
            String s = "[";
            Node old1 = start;
            while (old1 != null) {
                s += old1.item + ", ";
                old1 = old1.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque deque = new Deque();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "size":
                int a = deque.getSize();
                System.out.println(a);
                break;
            case "pushLeft":
                deque.pushFront(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "pushRight":
                deque.pushBack(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "popLeft":
                if (!(deque.isEmpty())) {
                    deque.popFront();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!(deque.isEmpty())) {
                    deque.popBack();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            default:
                break;
            }
        }
    }
}