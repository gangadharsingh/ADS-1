import java.util.Scanner;
public class Solution implements Comparable<Solution> {
    private final int sum;
    private final int i;
    private final int j;

    public Solution(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(Solution that) {
    //     if (this.sum < that.sum) return -1;
    //     if (this.sum > that.sum) return +1;
        return 0;
    }

    public int getsum() {
        return sum;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);
        // initialize priority queue
        MinHeap<Solution> pq = new MinHeap<Solution>();
        for (int i = 0; i < 20; i++) {
            // for (int j = 0; j < 20; j++) {
                pq.insert(new Solution(i, i));
            // }
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            Solution s = pq.delMin();
            Solution s1 = pq.delMin();
            if (s.getsum() == s1.getsum()) {
                System.out.println(s.getsum());
            }
            System.out.println(s.getsum());
            if (s.j < 20 || s1.j < 20)
                pq.insert(new Solution(s.i, s.j + 1));
                // pq.insert(new Solution(s1.i, s1.j + 1));
        }
    }

}
