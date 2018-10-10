import java.util.Comparator;
class MaxHeap<Key> {
	Key[] hp;
	int size;
	Comparator<Key> comparator;
	MaxHeap(int sz) {
		hp = (Key[]) new Object[sz + 1];
		size = 0;
	}
	MaxHeap() {
		this(1);
	}
	public int getsize() {
		return size;
	}
	void insertMax(Key k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swimMax(size);
	}
	void swimMax(int ind) {
		while (ind > 1 && minHP(ind / 2, ind)) { //ind is child and ind/2 is parent.
			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
			ind = ind / 2;
		}
	}
	boolean minHP(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) < 0;
		} else {
			return comparator.compare(hp[i], hp[j]) < 0;
		}
	}
	Key getMax() {
		return hp[1];
	}
	Key delMax() {
		Key max = hp[1];
		swap(1, size--);
		sinkMax(1);
		hp[size + 1] = null;
		if ((size > 0) && (size == (hp.length - 1) / 4)) {
			resize(hp.length / 2);
		}
		return max;
	}
	void sinkMax(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && minHP(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
		}
	}
	void resize(int newsize) {
		Key[] temp = (Key[]) new Object[newsize];
		for (int i = 1; i <= size; i++) {
			temp[i] = hp[i];
		}
		hp = temp;
	}
	void swap(int i, int j) {
		Key temp = hp[i];
		hp[i] = hp[j];
		hp[j] = temp;
	}
	void show() {
		for (int i = 1; i < size + 1; i++) {
			System.out.print(hp[i] + " ");
		}
		System.out.println();
	}
}
