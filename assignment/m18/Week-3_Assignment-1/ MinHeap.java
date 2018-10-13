// import java.util.Comparator;
// /**
//  * Class for minimum heap.
//  *
//  * @param      <Key>  The key.
//  */
// class MinHeap<Key> {
// 	/**
// 	 * generic array.
// 	 */
// 	public Key[] hp;
// 	/**
// 	 * size of array.
// 	 */
// 	public int size;
// 	/**
// 	 * Comparator of generic type.
// 	 */
// 	public Comparator<Key> comparator;
// 	/**
// 	 * Constructs the object.
// 	 *
// 	 * @param      sz    The size.
// 	 */
// 	public MinHeap(final int sz) {
// 		hp = (Key[]) new Object[sz + 1];
// 		size = 0;
// 	}
// 	/**
// 	 * Constructs the object.
// 	 */
// 	public MinHeap() {
// 		this(1);
// 	}
// 	/**
// 	 * getting size of array.
// 	 *
// 	 * @return     integer.
// 	 */
// 	public int getsize() {
// 		return size;
// 	}
// 	/**
// 	 * inserting Key type element.
// 	 *
// 	 * @param      k     generic type.
// 	 */
// 	public void insert(final Key k) {
// 		if (size == hp.length - 1) {
// 			resize(2 * hp.length);
// 		}
// 		hp[++size] = k;
// 		swim(size);
// 	}
// 	/**
// 	 * swimmin up the elements.
// 	 *
// 	 * @param      ind   The ind
// 	 */
// 	public void swim(int ind) {
// 		while (ind > 1 && greater(ind / 2, ind)) { //ind is child and ind/2 is parent.
// 			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
// 			ind = ind / 2;
// 		}
// 	}
// 	/**
// 	 * comparing two elements.
// 	 *
// 	 * @param      i     integer value
// 	 * @param      j     integer value
// 	 *
// 	 * @return     boolean.
// 	 */
// 	public boolean greater(int i, int j) {
// 		if (comparator == null) {
// 			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) > 0;
// 		} else {
// 			return comparator.compare(hp[i], hp[j]) > 0;
// 		}
// 	}
// 	/**
// 	 * deleting minimum.
// 	 *
// 	 * @return     Key type.
// 	 */
// 	Key delMin() {
// 		Key min = hp[1];
// 		swap(1, size--);
// 		sink(1);
// 		hp[size + 1] = null;
// 		if ((size > 0) && (size == (hp.length - 1) / 4)) {
// 			resize(hp.length / 2);
// 		}
// 		return min;
// 	}
// 	/**
// 	 * Gets the minimum.
// 	 *
// 	 * @return     The minimum.
// 	 */
// 	Key getMin() {
// 		return hp[1];
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      a     { parameter_description }
// 	 */
// 	void sink(int a) {
// 		while (2 * a <= size) {
// 			int j = 2 * a;
// 			if (j < size && greater(j, j + 1)) {
// 				j++;
// 			}
// 			swap(a, j);
// 			a = j;
// 		}
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      newsize  The newsize
// 	 */
// 	void resize(int newsize) {
// 		Key[] temp = (Key[]) new Object[newsize];
// 		for (int i = 1; i <= size; i++) {
// 			temp[i] = hp[i];
// 		}
// 		hp = temp;
// 	}
// 	/**
// 	 * { function_description }
// 	 *
// 	 * @param      i     { parameter_description }
// 	 * @param      j     { parameter_description }
// 	 */
// 	void swap(int i, int j) {
// 		Key temp = hp[i];
// 		hp[i] = hp[j];
// 		hp[j] = temp;
// 	}
// 	/**
// 	 * { function_description }
// 	 */
// 	void show() {
// 		for (int i = 1; i < size + 1; i++) {
// 			System.out.print(hp[i] + " ");
// 		}
// 		System.out.println();
// 	}
// }
class MinHeap {
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
    MinHeap(final Stockdata[] a, final int n) {
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
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l].compareTo(array[largest]) < 0) {
            largest = l;
        }
        if (r < n && array[r].compareTo(array[largest]) < 0) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
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