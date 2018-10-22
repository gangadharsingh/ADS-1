import java.util.Scanner;
/**.
 * Class for nonrecursive bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class NonrecursiveBST<Key extends Comparable<Key>, Value> {
    /**.
     * { var_description }
     */
    private Node root;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        public Key key;
        /**.
         * { var_description }
         */
        public Value val;
        /**.
         * { var_description }
         */
        private Node left, right;
        /**.
         * @param      key   The key
         * @param      val   The value
         */
        public Node(final Key key, final Value val) {
            this.key = key;
            this.val = val;
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left  = z;
        } else {
            parent.right = z;
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Value get(final Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }
}
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        NonrecursiveBST<String, Integer> st = new
        NonrecursiveBST<String, Integer>();
        while (scan.hasNext()) {
            String l = scan.nextLine();
            if (l.length() == 0) {
                break;
            }
            String[] str = l.split(",");
            String sub = str[1] + " " + str[2] + " "  + str[2 + 1];
            switch (str[0]) {
            case "put":
                st.put(sub, Integer.parseInt(str[2 + 2]));
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
