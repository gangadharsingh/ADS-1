import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * {Variable first of type node}.
     */
    private Node first;
    /**
     * {Variable last of type node}.
     */
    private Node last;
    /**
     * {Variable size of type integer}.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable nm of type int}.
         */
        private int nm;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (first == null);
    }
    /**
     * {Method to pop an element from the front}.
     *
     * @return     {Integer}
     */
    public int popFront() {
        if (first != null) {
            int item = first.nm;
            first = first.next;
            return item;
        }
        return last.nm;
    }
    /**
     * Method to push back an element.
     *
     * @param      nm  The nm
     */
    public void pushBack(final int nm) {
        if (last == null) {
            last = new Node();
            last.nm = nm;
            last.next = null;
            first = last;
        } else {
            Node temp = last;
            last = new Node();
            last.nm = nm;
            last.next = null;
            temp.next = last;
        }
    }
    /**
     * {Method to get size}.
     *
     * @return     {Integer}
     */
    public int getsize() {
        return size;
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
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            int count = Integer.parseInt(tokens[0]);
            int rounds = Integer.parseInt(tokens[1]);
            String s = "";
            Deque deque = new Deque();
            for (int i = 0; i < count; i++) {
                deque.pushBack(i);
            }
            while (!deque.isEmpty()) {
                for (int i = 0; i < rounds - 1; i++) {
                    deque.pushBack(deque.popFront());
                }
                s += deque.popFront() + " ";
            }
            System.out.print(s.substring(0, s.length() - 1));
            System.out.println();
        }
    }
}
