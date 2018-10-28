import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * word as key.
         */
        private String key;
        /**
         * count as value.
         */
        private Integer val;
        /**
         * next node.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      n     { parameter_description }
         */
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * retunrs key.
         *
         * @return     { description_of_the_return_value }
         */
        String getkey() {
            return this.key;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        Integer getValue() {
            return this.val;
        }
        /**
         * sets value.
         *
         * @param      v     { parameter_description }
         */
        void setvalue(final Integer v) {
            this.val = v;
        }
    }
    /**
     * nodes table.
     */
    private Node[] st;
    /**
     * size.
     */
    private int s = (2 * (2 + 2 + 1)) * (2 * (2 + 2 + 1));
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[s];
    }
    /**.
     * hash.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    int hash(final String k) {
        final Integer num = 0x7fffffff;
        return (k.hashCode() & num) % s;
    }
    /**.
     * resizes.
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
    /**.
     * put.
     * Best case: O(k)
     * Average case: O(K)
     * Worst case: O(logN)
     * @param      k     { parameter_description }
     * @param      v     { parameter_description }
     */
    public void put(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**.
     * get.
     * Best case: O(k)
     * Average case: O(K)
     * Worst case: O(logN)
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        HashTable map = new HashTable();
        Scanner s = new Scanner(System.in);
        String[] num = s.nextLine().split(" ");
        String[] mag = s.nextLine().split(" ");
        String[] note = s.nextLine().split(" ");
        int i = 0;
        int flag = 0;
        if (Integer.parseInt(num[0]) > Integer.parseInt(num[1])) {
            for (String meg : mag) {
                map.put(meg, 1);
            }
            for (String n : note) {
                // System.out.println("mapping "+map.get(n));
                if (map.get(n)) {
                    flag++;
                } else {
                    flag--;
                }
            }
            if (flag == note.length) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }
}
