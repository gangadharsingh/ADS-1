import java.util.*;
/**
 * Class for percolation.
 * @author: gangadharsingh.
 */

class Percolation {
	private boolean[][] grid;
	private Uf uf;
	private int size;
	public Percolation(int n) { // create n-by-n grid, with all sites blocked.
		grid = new boolean[n][n];
		uf = new Uf(n * n + 2);  // to create the one dimension array of size +
		size = n;
	}
	public void open(int row, int col) { // open site (row, col) if it is not open already
		if (grid[row][col] == false) {
			grid[row][col] = true;
		}
		if (row == 0) {
			uf.union(convert1D(row, col), size * size);
		} 
		if (row == size - 1) {
			uf.union(convert1D(row, col), size * size + 1);
		}
		if (row > 0 && grid[row - 1][col]) {	//top element.
			uf.union(convert1D(row, col), convert1D(row - 1, col));
		}
		if (row < size - 1 && grid[row + 1][col]) {	//bottom element.
			uf.union(convert1D(row, col), convert1D(row + 1, col));
		}
		if (col > 0 && grid[row][col - 1]) {	//left element.
			uf.union(convert1D(row, col), convert1D(row, col - 1));
		}
		if (col < size - 1 && grid[row][col + 1]) {	//right element.
			uf.union(convert1D(row, col), convert1D(row, col + 1));
		}
	}
	public int convert1D(int row, int col) {
		return row * size + col;
	}
	/*public boolean isOpen(int row, int col) { // is site (row, col) open?
		return grid[row][col] == 1;
	}
	public boolean isFull(int row, int col) { // is site (row, col) full?
		return grid[row][col] == 0;
	}*/
	/*public     int numberOfOpenSites() {      // number of open sites
		return opengridcount;
	}*/
	public boolean percolates() {             // does the system percolate?
		return uf.connected(size * size, size * size + 1);
	}
}
class Uf {
	private int[] id; //parent link
	private int[] size; //size of elements for roots
	private int count; // number of elements
	public Uf(int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	private int root(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	public void union(int p, int q) {
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
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Percolation percolate = new Percolation(n);
		while (scan.hasNextLine()) {
			String[] input = scan.nextLine().split(" ");
			percolate.open(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
		}
		System.out.println(percolate.percolates());
	}
}