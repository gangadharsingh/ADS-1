import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
import Priority.MinPQ;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() { }
	/**
	 * compare.
	 *
	 * @param      pq    priority queue.
	 * @param      str   The string.
	 *
	 * @return     {compare it}.
	 */
	public static boolean compare(String pq, String str) {
		return pq.equals(str);
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
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
				String str = "";
				MinPQ<String> pq = new MinPQ<String>();
				if (line.length() != 0) {
					String[] token = line.split(",");
					for (int j = 0; j < token.length; j++) {
						pq.insert(token[j]);
						str += token[j];
					}
					System.out.println(compare(pq.show(), str));
				} else {
					System.out.println("false");
				}
			}
			break;
		case "Float":
			int numFloat = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numFloat; l++) {
				String line = scan.nextLine();
				String str = "";
				MinPQ<Float> pqFloat = new MinPQ<Float>();
				if (line.length() != 0) {
					String[] token = line.split(",");
					Float[] floatarray = new Float[token.length];
					for (int k = 0; k< token.length; k++) {
						floatarray[k] = Float.parseFloat(token[k]);
						pqFloat.insert(floatarray[k]);
						str += floatarray[k];
					}
					System.out.println(compare(pqFloat.show(), str));
				} else {
					System.out.println("false");
				}
			}
			break;
		case "Double":
			int numDouble = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numDouble; l++) {
				String line = scan.nextLine();
				String str = "";
				MinPQ<Double> pqDouble = new MinPQ<Double>();
				if (line.length() != 0) {
					String[] token = line.split(",");
					Double[] Doublearray = new Double[token.length];
					for (int k = 0; k< token.length; k++) {
						Doublearray[k] = Double.parseDouble(token[k]);
						pqDouble.insert(Doublearray[k]);
						str += Doublearray[k];
						}
					System.out.println(compare(pqDouble.show(), str));
				} else {
					System.out.println("false");
				}
			}
			break;
		case "Integer":
			int numInteger = scan.nextInt();
			scan.nextLine();
			for (int l = 0; l < numInteger; l++) {
				String line = scan.nextLine();
				String str = "";
				MinPQ<Integer> pqInteger = new MinPQ<Integer>();
				if (line.length() != 0) {
					String[] token = line.split(",");
					Integer[] integerarray = new Integer[token.length];
					for (int k = 0; k< token.length; k++) {
						integerarray[k] = Integer.parseInt(token[k]);
						pqInteger.insert(integerarray[k]);
						str += integerarray[k];
					}
					System.out.println(compare(pqInteger.show(), str));
				} else {
					System.out.println("false");
				}
			}
			break;
		default:
			break;
		}
	}
}
