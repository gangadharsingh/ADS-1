/**
 * Class for maximum heap.
 */
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
			heapifyUp(i);
		}
		for (int i = size - 1; i >= 0; i--) {
			swap(0, i);
			heapifyUp(0);
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
	// void heapify(final int n, final int i) {
	// 	int min = i;
	// 	int l = 2 * i + 1;
	// 	int r = 2 * i + 2;
	// 	if (l < n && array[l].compareTo(array[min]) < 0) {
	// 		min = l;
	// 	}
	// 	if (r < n && array[r].compareTo(array[min]) < 0) {
	// 		min = r;
	// 	}
	// 	if (min != i) {
	// 		swap(min, i);
	// 		heapify(min, n);
	// 	}
	// }
	public void heapifyUp(int i) {
        Stockdata temp = array[i];
        while(i>0 && temp.compareTo(array[(i-1)/2]) > 0){
            array[i] = array[(i-1)/2];
            i = (i-1)/2;
        }
        array[i] = temp;
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
		return array[0];
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
	/**
	 * { function_description }
	 */
	void print() {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i]+"--");
		}
		System.out.print(array[array.length - 1]);
	}
}
