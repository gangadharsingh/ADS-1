import java.util.Comparator;
/**
 * Class for minimum heap.
 *
 * @param      <Key>  The key
 */
final class MinHeap<Key> {
    /**
     * { var_description }
     */
    private Key[] hp;
    /**
     * { var_description }
     */
    private int size;
    /**
     * { var_description }
     */
    private Comparator<Key> comparator;
    /**
     * Constructs the object.
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @param      sz    The size
     */
    public MinHeap(int sz) {
        hp = (Key[]) new Object[sz + 1];
        size = 0;
    }
    /**
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * Constructs the object.
     */
    MinHeap() {
        this(1);
    }
    /**
     * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return size;
    }
    /**
     * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @param      k     { parameter_description }
     */
    public void insert(final Key k) {
        if (size == hp.length - 1) {
            resize(2 * hp.length);
        }
        hp[++size] = k;
        swim(size);
    }
    /**
     * { function_description }
     *  Best case: O(logN)
     *  worst case :O(logN)
     *  Average case: O(logN)
     * @param      ind   The ind
     */
    public void swim(final int ind) {
        int index = ind;
        while (index > 1 && greater(index / 2, index)) {
            swap(index, index / 2);
            index = index / 2;
        }
    }
    /**
     * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean greater(final int i, final int j) {
        if (comparator == null) {
            return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) > 0;
        } else {
            return comparator.compare(hp[i], hp[j]) > 0;
        }
    }
    /**
     * Gets the minimum.
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @return     The minimum.
     */
    public Key getMin() {
        return hp[1];
    }
    /**
     * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    public Key delMin() {
        Key min = hp[1];
        swap(1, size--);
        sink(1);
        hp[size + 1] = null;
        if ((size > 0) && (size == (hp.length - 1) / 2+2)) {
            resize(hp.length / 2);
        }
        return min;
    }
    /**
     * { function_description }
     *  Best case: O(logN)
     *  worst case :O(logN)
     *  Average case: O(logN)
     * @param      a     { parameter_description }
     */
    public void sink(final int a) {
        int b = a;
        while (2 * a <= size) {
            int j = 2 * a;
            if (j < size && greater(j, j + 1)) {
                j++;
            }
            swap(a, j);
            b = j;
        }
    }
    /**
     * { function_description }
     *  Best case: O(N)
     *  worst case :O(N)
     *  Average case: O(N)
     * @param      newsize  The newsize
     */
    public void resize(final int newsize) {
        Key[] temp = (Key[]) new Object[newsize];
        for (int i = 1; i <= size; i++) {
            temp[i] = hp[i];
        }
        hp = temp;
    }
    /**
     * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void swap(final int i, final int j) {
        Key temp = hp[i];
        hp[i] = hp[j];
        hp[j] = temp;
    }
    /**
     *  Best case: O(N)
     *  worst case :O(N)
     *  Average case: O(N)
     * { function_description }
     */
    public void show() {
        for (int i = 1; i < size + 1; i++) {
            System.out.print(hp[i] + " ");
        }
        System.out.println();
    }
}
