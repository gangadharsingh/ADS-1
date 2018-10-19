import java.util.Scanner;public class Solution implements Comparable<Solution> {
    private final int i;
    private final int j;
    private final long sum;   // i^3 + j^3, cached to avoid recomputation

    // create a new tuple (i, j, i^3 + j^3)
    public Solution(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }

    // compare by i^3 + j^3, breaking ties by i
    public int compareTo(Solution that) {
        if      (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else if (this.i < that.i)     return -1;
        else if (this.i > that.i)     return +1;
        else                          return  0;
    }

    public String toString() {
        return i + "^3 + " + j + "^3";
    }


    public static void main(String[] args) {
        MinHeap<Solution> pq = new MinHeap<Solution>();
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        for (int i = 1; i <= 1000; i++) {
            pq.insert(new Solution(i, i));
        }
        int run = 1;
        int c = 0;
        Solution prev = new Solution(0, 0);
        while (!pq.isEmpty()) {
            Solution curr = pq.delMin();
            if (prev.sum == curr.sum) {
                run++;
                if (run == b) {
                  System.out.println(prev.sum);
                  break;
                }
                c++;
            }
            else {
                // if (run > 1) System.out.println();
                run = 1;
            }
            if (c == a) {
                break;
            }
            prev = curr;
            if (curr.j < 1000) pq.insert(new Solution(curr.i, curr.j + 1));
            if (c == a) {
                break;
            }
        }
        if (run > 1) System.out.println();
    }
}
