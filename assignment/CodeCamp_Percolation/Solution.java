import java.util.*;
/**
 * Class for percolation.
 * @author: gangadharsingh.
 */

/**
 * Class for percolation.
 */
class Percolation {
    /**
     * boolean string 2d array.
     */
    private boolean[][] grid;
    private Uf uf;
    private int size;
    public Percolation(final int n) { // create n-by-n grid, with all sites blocked.
        grid = new boolean[n][n];
        uf = new Uf(n * n + 2);  // to create the one dimension array of size +
        size = n;
    }
    /**
     * {opening sites}
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) { // open site (row, col) if it is not open already
        if (grid[row][col] == false) {
            grid[row][col] = true;
        }
        if (row == 0) {
            uf.union(convert1D(row, col), size * size);
        }
        if (row == size - 1) {
            uf.union(convert1D(row, col), size * size + 1);
        }
        if (row > 0 && grid[row - 1][col]) {    //top element.
            uf.union(convert1D(row, col), convert1D(row - 1, col));
        }
        if (row < size - 1 && grid[row + 1][col]) { //bottom element.
            uf.union(convert1D(row, col), convert1D(row + 1, col));
        }
        if (col > 0 && grid[row][col - 1]) {    //left element.
            uf.union(convert1D(row, col), convert1D(row, col - 1));
        }
        if (col < size - 1 && grid[row][col + 1]) { //right element.
            uf.union(convert1D(row, col), convert1D(row, col + 1));
        }
    }
    /**
     * {converting 2D array into 1D array}.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     {boolean value}.
     */
    public int convert1D(final int row, final int col) {
        return row * size + col;
    }
    /**
     * {checking if percolated or not}.
     *
     * @return     {boolean value}.
     */
    public boolean percolates() {             // does the system percolate?
        return uf.connected(size * size, size * size + 1);
    }
}
/**
 * Class for uf.
 */
class Uf {
    /**
     * initializing fields.
     */
    private int[] id; //parent link
    private int[] size; //size of elements for roots
    private int count; //number of elements
    //
    // @param      n     { parameter_description }
    //
    Uf(final int n) {
        /**
         * constructs object.
         */
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    /**
     * {returning count of elements}.
     *
     * @return     { description_of_the_return_value }
     */
    public int count() {
        return count;
    }
    /**
     * {checking if connected or not}.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }
    /**
     * {checking for root of elements}.
     *
     * @param      p     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public  int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    /**
     * {making union of two inputs}.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     */
    public void union(final int p, final int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}
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