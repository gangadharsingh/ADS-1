import java.util.Comparator;
/**.
 * Class for minimum heap.
 *
 * @param      <Key>  The key.
 */
final class MinHeap<Key> {
	/**.
	 * generic array.
	 */
	private Key[] hp;
	/**.
	 * size of array.
	 */
	private int size;
	/**.
	 * Comparator of generic type.
	 */
	private Comparator<Key> comparator;
	/**.
	 * Constructs the object.
	 *
	 * @param      sz    The size.
	 */
	public MinHeap(final int sz) {
		hp = (Key[]) new Object[sz + 1];
		size = 0;
	}
	/**.
	 * Constructs the object.
	 */
	public MinHeap() {
		this(1);
	}
	/**.
	 * getting size of array.
	 *
	 * @return     integer.
	 */
	public int getsize() {
		return size;
	}
	/**.
	 * inserting Key type element.
	 *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 * @param      k     generic type.
	 */
	public void insert(final Key k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swim(size);
	}
	/**.
	 * swimmin up the elements.
	 *  Best case: O(logN)
     *  worst case :O(logN)
     *  Average case: O(logN)
	 * @param      ind   The ind
	 */
	public void swim(final int ind) {
        int index = ind;
		while (index > 1 && greater(index / 2, index)) { //index is child and index/2 is parent.
			swap(index, index / 2); //exchange parent with child when parent is less than child.
			index = index / 2;
		}
	}
	/**.
	 * comparing two elements.
	 *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 * @param      i     integer value
	 * @param      j     integer value
	 *
	 * @return     boolean.
	 */
	public boolean greater(final int i, final int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) > 0;
		} else {
			return comparator.compare(hp[i], hp[j]) > 0;
		}
	}
	/**.
	 * deleting minimum.
	 *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 * @return     Key type.
	 */
	Key delMin() {
		Key min = hp[1];
		swap(1, size--);
		sink(1);
		hp[size + 1] = null;
		if ((size > 0) && (size == (hp.length - 1) / 4)) {
			resize(hp.length / 2);
		}
		return min;
	}
	/**.
	 * Gets the minimum.
	 *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 * @return     The minimum.
	 */
	Key getMin() {
		return hp[1];
	}
	/**.
	 * { function_description }
	 *  Best case: O(logN)
     *  worst case :O(logN)
     *  Average case: O(logN)
	 * @param      a     { parameter_description }
	 */
	void sink(final int a) {
        int b = a;
		while (2 * b <= size) {
			int j = 2 * a;
			if (j < size && greater(j, j + 1)) {
				j++;
			}
			swap(b, j);
			b = j;
		}
	}
	/**.
	 * { function_description }
	 *  Best case: O(N)
     *  worst case :O(N)
     *  Average case: O(N)
	 * @param      newsize  The newsize
	 */
	void resize(final int newsize) {
		Key[] temp = (Key[]) new Object[newsize];
		for (int i = 1; i <= size; i++) {
			temp[i] = hp[i];
		}
		hp = temp;
	}
	/**.
	 * { function_description }
	 *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	void swap(final int i, final int j) {
		Key temp = hp[i];
		hp[i] = hp[j];
		hp[j] = temp;
	}
	/**.
	 * { function_description }
     *  Best case: O(1)
     *  worst case :O(1)
     *  Average case: O(1)
	 */
	void show() {
		for (int i = 1; i < size + 1; i++) {
			System.out.print(hp[i] + " ");
		}
		System.out.println();
	}
}
