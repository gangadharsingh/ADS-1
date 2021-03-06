/**.
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class LinearProbingHashST<Key, Value> {
    /**.
     * capacity.
     */
    private static final int INIT_CAPACITY = 1;
    /**.
     * n var.
     */
    private int n;           // number of key-value pairs in the symbol table
    /**.
     * m var.
     */
    private int m;           // size of linear probing table
    /**.
     * key[] keys.
     */
    private Key[] keys;      // the keys
    /**.
     * value[] vals.
     */
    private Value[] vals;    // the values
    /**.
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**.
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    /**.
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**.
     * Returns true if this symbol table is empty.
     * Best: 1
     * Average: 1
     * Worst: 1
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * Returns true if this symbol table contains the specified key.
     *time complexity - O(n).
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    /**.
     * { function_description }
     * Best: 1
     * Average: 1
     * Worst: 1
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        // return (key.hashCode() & 0x7fffffff) % m;
        String s = (String) key;
        return ((int) s.charAt(0) * (2 * 2 * 2 + 2 + 1)) % m;
    }
    /**.
     * { function_description }
     *  Best: 1
     * Average: 1
     * Worst: N
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp = new
        LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }
    /**.
     * Best: 1
     * Average: 1
     * Worst: N
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**.
     * Returns the value associated with the specified key.
     * @param key the key
     *  Best: 1
     * Average: 1
     * Worst: N
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**.
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *  Best: 1
     * Average: 1
     * Worst: N
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / (2 * 2 * 2)) {
            resize(m / 2);
        }

        assert check();
    }

    /**.
     * Best: 1
     * Average: 1
     * Worst: N
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }
    /**.
     * { function_description }
     * Best: 1
     * Average: 1
     * Worst: N
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2 * n) {
            System.err.println("Hash table size m = " + m
                               + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) {
                continue;
            } else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = "
                                   + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }
}
