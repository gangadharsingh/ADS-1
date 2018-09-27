import java.util.*;
public class Solution {
	/**
	*
	*/
	Solution() { }
	/**
	 * main function.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] arr1 = scan.nextLine().split(",");
		Threesum three = new Threesum(arr1);
		System.out.println(three.tSum());
	}
}
class Threesum {
	private String[] array;
	Threesum(String[] arrthreesum) {
		array = arrthreesum;
		/*System.out.println("constructor");*/
	}
	int tSum() {
		/*System.out.println("tSum");*/
			int low, last;
			int count = 0;
			for (String s: array) {
				/*System.out.println("array:"+s);*/
			}
			for (int i = 0; i < array.length-2; i++) {
				int complement = 0 - Integer.parseInt(array[i]);
				/*System.out.println("complement:"+complement);*/
				low = i+1;
				last = array.length-1;
				while (low < last) {
					/*System.out.println("while");*/
						int total = Integer.parseInt(array[low]) +Integer.parseInt(array[last]);
						if (total < complement) {
							low++;
						} else if (total > complement) {
							last--;
						} else {
							count++;
							break;
						}
				}
			}
			return count;
        }
}