import java.util.Scanner;
class Steque {
    private Node start, end;
    private int size;
    private class Node {
        private String item;
        private Node next;
        }

    Steque() {
        start = null;
        end = null;
        size = 0;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int getSize() {

        return size;
    }
    public void enqueue(final String int1) {
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

    public void push(final String item1) {

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

    public void pop() {
        if (start != null) {
            start = start.next;
            size--;
        }
    }

    // public void popBack() {
    //     if (end != null) {
    //         Node old = start;
    //         while (old.next.next != null) {
    //             old = old.next;
    //         }
    //         old.next = null;
    //         end = old;
    //         size--;
    //     }
    // }
    public String toString() {

        if (size == 0) {
            return "";
        } else {
            String s = "";
            Node old1 = start;
            while (old1 != null) {
                s += old1.item;
                old1 = old1.next;
            }
            return s;
        }
    }
}
public class Solution {
    private Solution() { }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        Steque st = new Steque();
        // int num2 = scan.nextInt();
        // StqueueOperation squeue = new StqueueOperation();
        while (num1 > 0) {
            String[] command = scan.nextLine().split(" ");
            switch(command[0]) {
                case "push":
                    st.push(command[1]);
                    System.out.println(st);
                    break;
                case "enqueue":
                    st.enqueue(command[1]);
                    System.out.println(st);
                    break;
                case "pop":
                    st.pop();
                    System.out.println(st);
                    break;
                default:
                    break;
            }
            num1--;
        }
    }
}
// class StqueueOperation {

// }