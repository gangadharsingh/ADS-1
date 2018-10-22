import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BST<Key extends Comparable<Key>, Value> {
	/**
	 * { var_description }
	 */
	private Node root;
	/**
	 * Class for node.
	 */
	private class Node {
		/**
		 * { var_description }
		 */
		private Key key;
		/**
		 * { var_description }
		 */
		private Value val;
		/**
		 * { var_description }
		 */
		private Node left, right;
		/**
		 * { var_description }
		 */
		private int size;
		/**
		 * Constructs the object.
		 *
		 * @param      key   The key
		 * @param      val   The value
		 * @param      size  The size
		 */
		public Node(Key key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public BST() {
	}

	/**
	 * Returns true if this symbol table is empty.
	 * @return {@code true} if this symbol table is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Does this symbol table contain the given key?
	 *
	 * @param  key the key
	 * @return {@code true} if this symbol table contains {@code key} and
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key.
	 *
	 * @param  key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 *         and {@code null} if the key is not in the symbol table
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (key == null) throw new IllegalArgumentException("calls get() with a null key");
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is {@code null}.
	 *
	 * @param  key the key
	 * @param  val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("calls put() with a null key");
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}


	/**
	 * Removes the smallest key and associated value from the symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * Removes the largest key and associated value from the symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
		root = delete(root, key);
	}
	private Node delete(Node x, Key key) {
		if (x == null) return null;

		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			if (x.right == null) return x.left;
			if (x.left  == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) return x;
		else                return min(x.left);
	}
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
		return max(root).key;
	}
	private Node max(Node x) {
		if (x.right == null) return x;
		else                 return max(x.right);
	}
	public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

    public Key floor2(Key key) {
        return floor2(root, key, null);
    }

    private Key floor2(Node x, Key key, Key best) {
        if (x == null) return best;
        int cmp = key.compareTo(x.key);
        if      (cmp  < 0) return floor2(x.left, key, best);
        else if (cmp  > 0) return floor2(x.right, key, x.key);
        else               return x.key;
    } 
	public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    }
	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("argument to select() is invalid: " + k);
		}
		Node x = select(root, k);
		return x.key;
	}
	private Node select(Node x, int k) {
		if (x == null) return null;
		int t = size(x.left);
		if      (t > k) return select(x.left,  k);
		else if (t < k) return select(x.right, k - t - 1);
		else            return x;
	}
	public int size(Key lo, Key hi) {
		if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
		if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

		if (lo.compareTo(hi) > 0) return 0;
		if (contains(hi)) return rank(hi) - rank(lo) + 1;
		else              return rank(hi) - rank(lo);
	}
	public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    }
}

public final class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        BST<String, Integer> st = new
        BST<String, Integer>();
        while (scan.hasNext()) {
            String l = scan.nextLine();
            if (l.length() == 0) {
                break;
            }
            String[] str = l.split(",");
            String sub = "";
            switch (str[0]) {
            case "put":
                st.put(sub, Integer.parseInt(str[2 + 2]));
                break;
            case "get":
            	sub = str[1] + " " + str[2] + " "  + str[2 + 1];
                System.out.print(st.get(sub));
                break;
            case "min":
            	System.out.print(st.min());
            	break;
            case "max":
            	System.out.print(st.max());
            	break;
            case "floor":
            	sub = str[1] + " " + str[2] + " "  + str[2 + 1];
            	System.out.print(st.floor(sub));
            	break;
            case "ceiling":
            	sub = str[1] + " " + str[2] + " "  + str[2 + 1];
            	System.out.print(st.ceiling(sub));
            	break;
            case "select":
            	// System.out.println(st.select(Integer.parseInt(str[1])));
            	break;
            default:
                break;
            }
            System.out.println();
        }
	}
}
