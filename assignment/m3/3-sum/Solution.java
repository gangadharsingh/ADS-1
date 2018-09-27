import java.util.*;
import java.util.Arrays;
/**
 * Class for solution.
 * @author: gangadharsingh.
 */
public class Solution {
	/**
	*constructor.
	*/
	Solution() { }
	/**
	 * main function.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] arr1 = new int[num];
		for (int i = 0;  i < num; i++) {
			arr1[i] = scan.nextInt();
		}
		Arrays.sort(arr1);
		Threesum three = new Threesum(arr1);
		System.out.println(three.tSum());
	}
}
/**
 * Class for threesum.
 */
class Threesum {
	/**
	 * { var_description }.
	 */
	private int[] array;
	/**
	 * Constructs the object.
	 *
	 * @param      arrthreesum  The arrthreesum
	 */
	Threesum(int[] arrthreesum) {
		array = arrthreesum;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }.
	 */
	int tSum() {
	
			int low, last;
			int count = 0;
			for (int s: array) {
			}
			for (int i = 0; i < array.length-2; i++) {
				low = i+1;
				last = array.length-1;
				while (low < last) {
						int total = array[low] +array[last];
						if (array[low] +array[last]+ array[i] < 0) {
							low++;
						} else if (array[low] +array[last]+ array[i] > 0) {
							last--;
						} else {
							count++;
							low++;
							last--;
						}
				}
			}
			return count;
        }
}