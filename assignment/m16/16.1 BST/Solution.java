import java.util.Scanner;
class NonrecursiveBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    public void put(Key key, Value val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
    }

    Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NonrecursiveBST<String, Integer> st = new NonrecursiveBST<String, Integer>();
        while (scan.hasNext()) {
            String l = scan.nextLine();
            if (l.length() == 0) break;
            String[] str = l.split(",");
            String sub = str[1] + " " + str[2] + " "  + str[3];
            switch (str[0]) {
            case "put":
                st.put(sub, Integer.parseInt(str[4]));
                break;
            case "get":
                System.out.println(st.get(sub));
                break;
            default:
                break;
            }
        }
    }
}
