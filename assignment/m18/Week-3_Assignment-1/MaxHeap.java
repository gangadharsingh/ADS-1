import java.util.Comparator;
// /**
//  * Class for maximum heap.
//  *
//  * @param      <Key>  The key
//  */
// class MaxHeap<Key> {
// 	/**
// 	 * { var_description }
// 	 */
// 	public Key[] hp;
// 	/**
// 	 * { var_description }
// 	 */
// 	public int size;
// 	/**
// 	 * { var_description }
// 	 */
// 	public Comparator<Key> comparator;
// 	/**
// 	 * Constructs the object.
// 	 *
// 	 * @param      sz    The size
// 	 */
// 	public MaxHeap(int sz) {
// 		hp = (Key[]) new Object[sz + 1];
// 		size = 0;
// 	}
// 	/**
// 	 * Constructs the object.
// 	 */
// 	public MaxHeap() {
// 		this(1);
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @return     { description_of_the_return_value }
// 	 */
// 	public int getsize() {
// 		return size;
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      k     { parameter_description }
// 	 */
// 	public void insertMax(Key k) {
// 		if (size == hp.length - 1) {
// 			resize(2 * hp.length);
// 		}
// 		hp[++size] = k;
// 		swimMax(size);
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      ind   The ind
// 	 */
// 	public void swimMax(int ind) {
// 		while (ind > 1 && minHP(ind / 2, ind)) { //ind is child and ind/2 is parent.
// 			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
// 			ind = ind / 2;
// 		}
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      i     { parameter_description }
// 	 * @param      j     { parameter_description }
// 	 *
// 	 * @return     { description_of_the_return_value }
// 	 */
// 	public boolean minHP(int i, int j) {
// 		if (comparator == null) {
// 			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) < 0;
// 		} else {
// 			return comparator.compare(hp[i], hp[j]) < 0;
// 		}
// 	}
// 	/**
// 	 * Gets the maximum.
// 	 *
// 	 * @return     The maximum.
// 	 */
// 	public Key getMax() {
// 		return hp[1];
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @return     { description_of_the_return_value }
// 	 */
// 	public Key delMax() {
// 		Key max = hp[1];
// 		swap(1, size--);
// 		sinkMax(1);
// 		hp[size + 1] = null;
// 		if ((size > 0) && (size == (hp.length - 1) / 4)) {
// 			resize(hp.length / 2);
// 		}
// 		return max;
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      a     { parameter_description }
// 	 */
// 	public void sinkMax(int a) {
// 		while (2 * a <= size) {
// 			int j = 2 * a;
// 			if (j < size && minHP(j, j + 1)) {
// 				j++;
// 			}
// 			swap(a, j);
// 			a = j;
// 		}
// 	}
// 	public void resize(int newsize) {
// 		Key[] temp = (Key[]) new Object[newsize];
// 		for (int i = 1; i <= size; i++) {
// 			temp[i] = hp[i];
// 		}
// 		hp = temp;
// 	}
// 	public void swap(int i, int j) {
// 		Key temp = hp[i];
// 		hp[i] = hp[j];
// 		hp[j] = temp;
// 	}
// 	public void show() {
// 		for (int i = 1; i < size + 1; i++) {
// 			System.out.print(hp[i] + " ");
// 		}
// 		System.out.println();
// 	}
// }
class MaxHeap {
    /**
     * array.
     */
    private Stockdata[] array;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      a     { parameter_description }
     * @param      n     { parameter_description }
     */
    MaxHeap(final Stockdata[] a, final int n) {
        array = a;
        size = n;
    }
    /**
     * sorts.
     * Best case: O(N)
     *  worst case: O(N)
     *  Average case: O(N)
     * @return     { description_of_the_return_value }
     */
    Stockdata[] sort() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
        return array;
    }
    /**
     * swaps.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void swap(final int i, final int j) {
        Stockdata temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * heapifies.
     *  Best case: O(logN)
     *  worst case: O(logN)
     *  Average case: O(logN)
     * @param      n     { parameter_description }
     * @param      i     { parameter_description }
     */
    void heapify(final int n, final int i) {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l].compareTo(array[min]) > 0) {
            min = l;
        }
        if (r < n && array[r].compareTo(array[min]) > 0) {
            min = r;
        }
        if (min != i) {
            swap(i, min);
            heapify(n, min);
        }
    }
    /**
     * gets item.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    Stockdata getitem(final int index) {
        return array[index];
    }
    /**
     * get size.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getsize() {
        return size;
    }
}
