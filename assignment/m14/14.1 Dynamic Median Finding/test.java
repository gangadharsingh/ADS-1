import java.util.*;
import java.io.*;
/**.
 * Class for test.
 */
class test{
	/**.
	 * Constructs the object.
	 */
	test() { }
	/**.
	 * { function_description }
	 *  Best case: O(N)
     *  worst case :O(N)
     *  Average case: O(N)
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		try{
			Scanner sc = new Scanner(new File("out.txt"));
		Scanner sc1 = new Scanner(new File("output001.txt"));
			int i = 1;
		while(sc.hasNextLine()){
			if(!sc.nextLine().equals(sc1.nextLine())){
				System.out.println(i);
			}
			i++;
		}
		}catch(Exception e){
			System.out.println();
		}
	}
}
