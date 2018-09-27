import java.util.*;
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
		Threesum three = new Threesum(arr1);
		System.out.println(three.tSum());
	}
}
class Threesum {
	private int[] array;
	Threesum(int[] arrthreesum) {
		array = arrthreesum;
		/*System.out.println("constructor");*/
	}
	int tSum() {
		/*System.out.println("tSum");*/
			int low, last;
			int count = 0;
			for (int s: array) {
				/*System.out.println("array:"+s);*/
			}
			for (int i = 0; i < array.length-2; i++) {
				int complement = 0 - array[i];
				/*System.out.println("complement:"+complement);*/
				low = i+1;
				last = array.length-1;
				while (low < last) {
					/*System.out.println("while");*/
						int total = array[low] +array[last];
						if (total < complement) {
							low++;
						} else if (total > complement) {
							last--;
						} else {
							System.out.println("first:"+array[i]+", low:"+array[low]+", last:"+array[last]);
							count++;
							break;
						}
				}
			}
			return count;
        }
}