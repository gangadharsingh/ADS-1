import java.util.Comparator;
import java.util.Scanner;
class MinHeap<Key> {
	Key[] hp;
	int size;
	Comparator<Key> comparator;
	MinHeap(int sz) {
		hp = (Key[]) new Object[sz + 1];
		size = 0;
	}
	MinHeap() {
		this(1);
	}
	public int getsize() {
		return size;
	}
	void insert(Key k) {
		if (size == hp.length - 1) {
			resize(2 * hp.length);
		}
		hp[++size] = k;
		swim(size);
	}
	void swim(int ind) {
		while (ind > 1 && greater(ind / 2, ind)) { //ind is child and ind/2 is parent.
			swap(ind, ind / 2); //exchange parent with child when parent is less than child.
			ind = ind / 2;
		}
	}
	boolean greater(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) hp[i]).compareTo(hp[j]) > 0;
		} else {
			return comparator.compare(hp[i], hp[j]) > 0;
		}
	}
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
	Key getMin() {
		return hp[1];
	}
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
