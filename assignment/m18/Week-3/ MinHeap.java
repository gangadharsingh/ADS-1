import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The Key
 */
class MinHeap<Key> implements Iterable<Key> {
    /**
     * { var_description }
     */
    private Key[] pq;
    /**
     * { var_description }
     */
    private int n;
    /**
     * { var_description }
     */
    private Comparator<Key> comparator;
    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param      initCapacity  the initial capacity of this priority queue
     */
    public MinHeap(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     */
    public MinHeap() {
        this(1);
    }
    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param      initCapacity  the initial capacity of this priority queue
     * @param      comparator    the order in which to compare the Keys
     */
    public MinHeap(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param      comparator  the order in which to compare the Keys
     */
    public MinHeap(Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**
     * Initializes a priority queue from the array of Keys. Takes time
     * proportional to the number of Keys, using sink-based heap
     * construction.
     *
     * @param      Keys  the array of Keys
     */
    public MinHeap(Key[] Keys) {
        n = Keys.length;
        pq = (Key[]) new Object[Keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = Keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }
    /**
     * Returns true if this priority queue is empty.
     *
     * @return     { true} if this priority queue is empty; { false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * Returns the number of Keys on this priority queue.
     *
     * @return     the number of Keys on this priority queue
     */
    public int size() {
        return n;
    }
    /**
     * Returns a largest Key on this priority queue.
     *
     * @return     a largest Key on this priority queue
     * @throws     NoSuchElementException  if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    /**
     * { function_description }
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Adds a new Key to this priority queue.
     *
     * @param      x     the new Key to add to this priority queue
     */
    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }
    /**
     * Removes and returns a largest Key on this priority queue.
     *
     * @return     a largest Key on this priority queue
     * @throws     NoSuchElementException  if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }
    /**
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    /**
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
    /**
     * Returns an iterator that iterates over the Keys on this priority queue
     * in descending order.
     * @return an iterator that iterates over the Keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MinHeap<Key> copy;
        public HeapIterator() {
            if (comparator == null) copy = new MinHeap<Key>(size());
            else                    copy = new MinHeap<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }
        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
