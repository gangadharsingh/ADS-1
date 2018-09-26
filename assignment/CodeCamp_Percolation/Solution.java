import java.util.*;
/**
 * Class for percolation.
 * @author: gangadharsingh.
 */
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){}

    /**
     * creating main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * checking if percolates or not
         */
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Percolation percolate = new Percolation(n);
        while (scan.hasNextLine()) {
            String[] input = scan.nextLine().split(" ");
            percolate.open(Integer.parseInt(input[0]) - 1,
                Integer.parseInt(input[1]) - 1);
        }
        System.out.println(percolate.percolates());
    }
}