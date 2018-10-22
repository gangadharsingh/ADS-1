import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
    long sum;
    long i;
    long j;

    public CubeSum(long i, long j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }
    public long sum() {return sum;}
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

}


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MinHeap<CubeSum> pq = new MinHeap<CubeSum>();
        for (int i = 1; i <= 1000; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // int i = 0;
        CubeSum prev = new CubeSum(0, 0);
        long sum = 0;
        // for (k < n; k++) {
        int p = 1;
        int k = 0;
        while (!pq.isEmpty()) {
            CubeSum c = pq.delMin();
            if (prev.sum() == c.sum()) {
                p++;
                if (p == m)
                {
                    sum = c.sum();

                    if (++k == n) break;
                }
            }
            else {
                p = 1;
            }
            prev = c;
            if (c.j < 1500)
                pq.insert(new CubeSum(c.i, c.j + 1));
            // }
        }
        System.out.println(sum);

    }
}
