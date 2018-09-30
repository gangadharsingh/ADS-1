import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 * @author: gangadharsingh.
 */
public class Solution {
	/**
	*
	*/
	private Solution() { }
	/**
	 * main function.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] pair = scan.nextLine().split(",");
		Iterate it = new Iterate(pair);
		System.out.println(it.countpair());
	}
}
/**
 * Class for iterate.
 */
class Iterate {
	/**
	 * initializing array.
	 */
	String[] array;
	/**
	 * Constructs the object.
	 *
	 * @param      arr   The arr
	 */
	Iterate(String[] arr) {
		array = arr;
	}
	/**
	 * { counting pair }.
	 *
	 * @return     number of pair of elements.
	 */
	int countpair() {
		String point = array[0];
		int count  = 1;
		int sum = 0;
		Arrays.sort(array);
		for (int i = 1; i < array.length; i++) {
			if (array[i].equals(point)) {
				count++;
			} else {
				sum += (count * (count - 1)) / 2;
				count = 1;
				point = array[i];
			}
		}
		sum += (count * (count - 1)) / 2;
		return sum;
	}
}
