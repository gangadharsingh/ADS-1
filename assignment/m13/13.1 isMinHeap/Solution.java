import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Solution {
	private Solution() { }
	public static boolean compare(String pq, String str) {
		return pq.equals(str);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String check = scan.nextLine();
		switch (check) {
		case "String":
			int numString = scan.nextInt();
			scan.nextLine();
			int count = 0;
			for (int i = 0; i < numString; i++) {
				String line = scan.nextLine();
				String[] token = line.split(",");
				MinPQ<String> pq = new MinPQ<String>();
				String str = "";
				for (int j = 0; j < token.length; j++) {
					pq.insert(token[j]);
					str += token[j];
				}
				System.out.println(compare(pq.show(), str));
			}
			break;
		case "Float":
			int numFloat = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numFloat; l++) {
				String line = scan.nextLine();
				String[] token = line.split(",");
				Float[] floatarray = new Float[token.length];
				String str = "";
				MinPQ<Float> pqFloat = new MinPQ<Float>();
				for (int k = 0; k< token.length; k++) {
					floatarray[k] = Float.parseFloat(token[k]);
					pqFloat.insert(floatarray[k]);
					str += floatarray[k];
				}
				System.out.println(compare(pqFloat.show(), str));
			}
			break;
		case "Double":
			int numDouble = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numDouble; l++) {
				String line = scan.nextLine();
				String[] token = line.split(",");
				Double[] Doublearray = new Double[token.length];
				String str = "";
				MinPQ<Double> pqDouble = new MinPQ<Double>();
				for (int k = 0; k< token.length; k++) {
					// System.out.println("BATMAN");
					// System.out.println(Double.parseDouble(token[k]));
					Doublearray[k] = Double.parseDouble(token[k]);
					pqDouble.insert(Doublearray[k]);
					str += Doublearray[k];
				}
				System.out.println(compare(pqDouble.show(), str));
			}
			break;
		case "Integer":
			int numInteger = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numInteger; l++) {
				String line = scan.nextLine();
				String[] token = line.split(",");
				Integer[] integerarray = new Integer[token.length];
				String str = "";
				MinPQ<Integer> pqInteger = new MinPQ<Integer>();
				for (int k = 0; k< token.length; k++) {
					// System.out.println("WonderWoMAN");
					// System.out.println(Integer.parseInt(token[k]));
					integerarray[k] = Integer.parseInt(token[k]);
					pqInteger.insert(integerarray[k]);
					str += integerarray[k];
				}
				System.out.println(compare(pqInteger.show(), str));
			}
			break;
		default:
			break;
		}
	}
}
class  MinPQ<Key> {
	private Key[] pq;
	private int n;
	private Comparator<Key> comparator;
	public  MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}
	public  MinPQ() {
		this(1);
	}
	public  MinPQ(Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < n; i++)
			pq[i + 1] = keys[i];
		assert isMinHeap();
	}
	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}
	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}
	public void insert(Key x) {
		if (n == pq.length - 1) resize(2 * pq.length);

		pq[++n] = x;
		swim(n);
		assert isMinHeap();
	}
	public String show() {
		String str = "";
		for (int i = 0; i < pq.length; i++) {
			if (pq[i] != null) {
				str += pq[i];
			}
		}
		return str;
	}

	private void swim(int k) {
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}
	private boolean greater(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		} else {
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private boolean isMinHeap() {
		return isMinHeap(1);
	}

	private boolean isMinHeap(int k) {
		if (k > n) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left  <= n && greater(k, left))  return false;
		if (right <= n && greater(k, right)) return false;
		return isMinHeap(left) && isMinHeap(right);
	}
}