import java.util.Comparator;
/**
 * Class for maximum heap.
 *
 * @param      <Key>  The key
 */
public final class MaxHeap<Key> {
	/**
	 * { var_description }
	 */
	public Key[] hp;
	/**
	 * { var_description }
	 */
	public int size;
	/**
	 * { var_description }
	 */
	public Comparator<Key> comparator;
	/**
	 * Constructs the object.
	 *  Best case: O(1)
	 *  worst case :O(1)
	 *  Average case: O(1)
	 * @param      sz    The size
	 */
	public MaxHeap(int sz) {
		hp = (Key[]) new Object[sz + 1];
		size = 0;
	}
	/**
	 *  Best case: O(1)
	 *  worst case :O(1)
	 *  Average case: O(1)
	 * Constructs the object.
	 */
	public MaxHeap() {
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
	public void insertMax(Key k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swimMax(size);
	}
	/**
	 * { function_description }
	 *  Best case: O(logN)
	 *  worst case :O(logN)
	 *  Average case: O(logN)
	 * @param      ind   The ind
	 */
	public void swimMax(int ind) {
		while (ind > 1 && minHP(ind / 2, ind)) { //ind is child and ind/2 is parent.
			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
			ind = ind / 2;
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
	public boolean minHP(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) < 0;
		} else {
			return comparator.compare(hp[i], hp[j]) < 0;
		}
	}
	/**
	 * Gets the maximum.
	 *  Best case: O(1)
	 *  worst case :O(1)
	 *  Average case: O(1)
	 * @return     The maximum.
	 */
	public Key getMax() {
		return hp[1];
	}
	/**
	 * { function_description }
	 *  Best case: O(1)
	 *  worst case :O(1)
	 *  Average case: O(1)
	 * @return     { description_of_the_return_value }
	 */
	public Key delMax() {
		Key max = hp[1];
		swap(1, size--);
		sinkMax(1);
		hp[size + 1] = null;
		if ((size > 0) && (size == (hp.length - 1) / 2 + 2)) {
			resize(hp.length / 2);
		}
		return max;
	}
	/**
	 * { function_description }
	 *  Best case: O(logN)
	 *  worst case :O(logN)
	 *  Average case: O(logN)
	 * @param      a     { parameter_description }
	 */
	public void sinkMax(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && minHP(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
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
