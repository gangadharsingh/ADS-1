/**
 * Class for minimum heap.
 */
class MinHeap {
	/**
	 * Constructs the object.
	 */
	private MinHeap() { }
	/**
	 * { var_description }
	 */
    private Stockdata[] array;
    /**
     * { var_description }
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
     * { function_description }
     *
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
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void swap(final int i, final int j) {
        Stockdata temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * { function_description }
     *
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
     * { function_description }
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    Stockdata getitem(int index) {
        return array[0];
    }
    /**
     * { function_description }
     *
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
			System.out.print(array[i]+" ");
		}
		System.out.print(array[array.length - 1]);
	}
}