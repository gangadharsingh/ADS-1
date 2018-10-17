import java.util.Comparator;
/**
 * Class for minimum heap.
 *
 * @param      <Stockdata>  The Stockdata.
 */
class MinHeap {
	/**
	 * generic array.
	 */
	public Stockdata[] hp;
	/**
	 * size of array.
	 */
	public int size;
	/**
	 * Comparator of generic type.
	 */
	public Comparator<Stockdata> comparator;
	/**
	 * Constructs the object.
	 *
	 * @param      sz    The size.
	 */
	public MinHeap(Stockdata[] stdata, int sz) {
		hp = stdata;
		size = sz;
	}
	/**
	 * getting size of array.
	 *
	 * @return     integer.
	 */
	public int getsize() {
		return size;
	}
	/**
	 * inserting Stockdata type element.
	 *
	 * @param      k     generic type.
	 */
	public void insert(final Stockdata k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swim(size);
	}
	/**
	 * swimmin up the elements.
	 *
	 * @param      ind   The ind
	 */
	public void swim(int ind) {
		while (ind > 1 && greater(ind / 2, ind)) { //ind is child and ind/2 is parent.
			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
			ind = ind / 2;
		}
	}
	/**
	 * comparing two elements.
	 *
	 * @param      i     integer value
	 * @param      j     integer value
	 *
	 * @return     boolean.
	 */
	public boolean greater(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Stockdata>) hp[i]).compareTo(hp[j]) > 0;
		} else {
			return comparator.compare(hp[i], hp[j]) > 0;
		}
	}
	/**
	 * deleting minimum.
	 *
	 * @return     Stockdata type.
	 */
	Stockdata delMin() {
		Stockdata min = hp[1];
		swap(1, size--);
		sink(1);
		hp[size + 1] = null;
		if ((size > 0) && (size == (hp.length - 1) / 4)) {
			resize(hp.length / 2);
		}
		return min;
	}
	/**
	 * Gets the minimum.
	 *
	 * @return     The minimum.
	 */
	Stockdata getMin() {
		return hp[1];
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 */
	void sink(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && greater(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      newsize  The newsize
	 */
	void resize(int newsize) {
		Stockdata[] temp = (Stockdata[]) new Object[newsize];
		for (int i = 1; i <= size; i++) {
			temp[i] = hp[i];
		}
		hp = temp;
	}
	/**
	 * { function_description }
	 *
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	void swap(int i, int j) {
		Stockdata temp = hp[i];
		hp[i] = hp[j];
		hp[j] = temp;
	}
	/**
	 * { function_description }
	 */
	void show() {
		for (int i = 1; i < size + 1; i++) {
			System.out.print(hp[i] + " ");
		}
		System.out.println();
	}
}
