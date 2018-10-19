import java.util.Comparator;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key.
 */
public class  MinPQ<Key> {
	/**
	 * key array of type.
	 */
	public Key[] pq;
	/**
	 * size of key array.
	 */
	public int n;
	/**
	 * comparator for comparing data types.
	 */
	public Comparator<Key> comparator;
	/**
	 * Constructs the object.
	 *
	 * @param      initCapacity  The initialize capacity.
	 */
	public  MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}
	/**
	 * Constructs the object.
	 */
	public  MinPQ() {
		this(1);
	}
	/**
	 * Constructs the object.
	 *
	 * @param      keys  The keys.
	 */
	public  MinPQ(Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < n; i++)
			pq[i + 1] = keys[i];
		assert isMinHeap();
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	/**
	 * { size of key array }.
	 *
	 * @return     { void }.
	 */
	public int size() {
		return n;
	}
	/**
	 * resizing array.
	 *
	 * @param      capacity  The capacity.
	 */
	public void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}
	/**
	 * inserting key in priotiy queue.
	 *
	 * @param      x     {elements of the queue}.
	 */
	public void insert(Key x) {
		if (n == pq.length - 1) resize(2 * pq.length);

		pq[++n] = x;
		swim(n);
		assert isMinHeap();
	}
	/**
	 * show priotiy queue.
	 *
	 * @return     {String}.
	 */
	public String show() {
		String str = "";
		for (int i = 0; i < pq.length; i++) {
			if (pq[i] != null) {
				str += pq[i];
			}
		}
		return str;
	}

	public void swim(int k) {
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}
	public boolean greater(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		} else {
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}

	public void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	public boolean isMinHeap() {
		return isMinHeap(1);
	}

	public boolean isMinHeap(int k) {
		if (k > n) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= n && greater(k, left))  return false;
		if (right <= n && greater(k, right)) return false;
		return isMinHeap(left) && isMinHeap(right);
	}
}