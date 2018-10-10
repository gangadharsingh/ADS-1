import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int token = Integer.parseInt(scan.nextLine());
		MinHeap<Integer> heapMin = new MinHeap<Integer>();
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		double median = 0;
		// int s = token;
		while(token > 0) {
			// System.out.println(token+"::BATin token");
			int key = Integer.parseInt(scan.nextLine());
			heapMin.insert(key);
			if (key < median) {
				heapMax.insertMax(key);
				// heapMax.show();
			} else if (key > median) {
				heapMin.insert(key);
				// heapMin.show();
			}
			if ((heapMin.getsize() - heapMax.getsize() == 2)) {
				int temp = heapMin.delMin();
				heapMax.insertMax(temp);
				// median = heapMin.delMin();
				// heapMax.insertMax(median);
				// heapMax.show();
			} else if ((heapMin.getsize() - heapMax.getsize() == -2)) {
				int temp = heapMax.delMax();
				heapMin.insert(temp);
				// median = heapMax.delMax();
				// heapMin.insert(median);
				// heapMin.show();
			}
			if (heapMin.getsize() == heapMax.getsize()) {
				median = (heapMin.getMin() + heapMax.getMax() ) / 2;
			} else if (heapMin.getsize() > heapMax.getsize()) {
				median = heapMin.getMin();
			} else if (heapMin.getsize() < heapMax.getsize()) {
				median = heapMax.getMax();
			}
			
		// System.out.println(median+":BATout");
			token--;
			System.out.println(median);
		}
		// System.out.println();
		// heapMax.show();
		// System.out.println();
		// heapMin.show();
	}
}