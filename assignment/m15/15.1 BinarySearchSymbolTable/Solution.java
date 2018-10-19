import java.util.Scanner;
/**
 * Solution class to pass the.
 * commands
 */
public final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {

    }
    /**
     * main method to call methods of the.
     * SymbolTable
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        SymbolTable
        <String, Integer> st = new SymbolTable
        <String, Integer>();
        Scanner sc = new Scanner(System.in);
        String[] keys = sc.nextLine().split(" ");
        for (int i = 0; i < keys.length; i++) {
            st.put(keys[i], i);
        }
        while (sc.hasNext()) {
            String[] cmd = sc.nextLine().split(" ");
            switch (cmd[0]) {
            case "max":
                System.out.println(st.max());
                break;
            case"floor":
                System.out.println(st.floor(cmd[1]));
                break;
            case "rank":
                System.out.println(st.rank(cmd[1]));
                break;
            case "deleteMin":
                st.deleteMin();
                break;
            case "contains":
                System.out.println(st.contains(cmd[1]));
                break;
            case "keys":
                // for (String s : st.keys()) {
                // System.out.println(s + " " + st.get(s));
                // }
                st.keys();
                break;
            case "get":
                System.out.println(st.get(cmd[1]));
                break;
            default:
                break;

            }

        }
    }
}
/**
 * class to create a symbol table.
 * it is a generic type.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * initial CAP for the arrays.
     */
    private static final int CAP = 2;
    /**
     * keys array to store keys of the give.
     * SYmbolTable
     */
    private Key[] keys;
    /**
     * values array to store values of the give.
     * SYmbolTable
     */
    private Value[] vals;
    /**
     * to track size of the array.
     */
    private int n = 0;
    /**
     * Constructor to initialize.
     * the SymbolTable.
     */
    SymbolTable() {
        keys = (Key[]) new Comparable[CAP];
        vals = (Value[]) new Object[CAP];
    }
    /**
     * method to return max value.
     *complexity O(1)
     * @return     { it return n-1 index of key array }
     */
    public Key max() {

        return keys[n - 1];
    }
    /**
     * method to send Key object.
     *befor the pramater Key
     *complexity O(1)
     * @param      key   The key
     *
     * @return     {if i=0 return null,
     * or returns i-1 index of the Key
     * or return the same Key if the
     * preveious Key is also same.}
     */
    public Key floor(final Key key) {

        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }
    /**
     * returns the index of the @param Key.
     *complexity O(Logn)
     * @param      key   The key
     *
     * @return returns mid if the lo less than high.
     * or returns the lo.
     */
    public int rank(final Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {

                return mid;
            }
        }
        return lo;
    }
    /**
     * return the first element. or the minimum of the ordered keys.
     *complexity O(1)
     * @return     keys[0];
     */
    public Key min() {

        return keys[0];
    }
    /**
     *
     * deletemin is used to delete.
     *  the min element of the element and it
     *  calls the delete function.
     */
    public void deleteMin() {

        delete(min());
    }
    /**
     * method to check weather.
     *  the element is present or not.
     *
     *complexity O(1)
     * @param      key   The key
     *
     * @return check for the get()
     * method is returning null or not
     */
    public boolean contains(final Key key) {

        return get(key) != null;
    }
    /**
     * get method returns the key element.
     *complexity O(1)
     *
     * @param      key   The key
     *
     * @return  null if empty.
     */

    public Value get(final Key key) {

        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }
    /**
     * put is used to insert the element in the.
     * SYmbolTable.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val)  {
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * Best case: O(n)
     * Worst case: O(n)
     * Average case: O(n)
     * method to resize the array.
     *
     * @param      ind   The ind
     */
    private void resize(final int ind) {
        Key[]   tempk = (Key[])   new Comparable[ind];
        Value[] tempv = (Value[]) new Object[ind];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    /**
     *
     * returns size of ST.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * method to delete the Key.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (isEmpty()) {
            return;
        }

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n - 1; j++)  {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        if (n > 0 && n == keys.length / (2 + 2)) {
            resize(keys.length / 2);
        }
    }
    /**
     * prints all values.
     * Best case: O(n)
     * Worst case: O(N)
     * Average case: O(N)
     */
    void keys() {
        for (int i = 0; i < n; i++) {
            if (vals[i] != null) {
                System.out.println(keys[i] + " " + vals[i]);
    }
        }
    }
}
