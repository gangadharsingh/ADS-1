import java.util.Scanner;
// import java.util.Comparable;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int st = Integer.parseInt(s.nextLine());
        for (int i = 0; i < 6; i++) {
            MaxPQ<Stock> max = new MaxPQ<Stock> (st);
            MinPQ<Stock> min = new MinPQ<Stock> (st);
            for (int j = 0; j < st; j++) {
                String[] str = s.nextLine().split(",");
                max.insert(new Stock(str));
                min.insert(new Stock(str));
            }
            for(int j = 0; j < 5; j++) {
                System.out.println(max.delMax());
            }
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.println(min.delMin());
            }
            System.out.println();
        }
        
    }
}
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    public String nm;
    public float change;
    Stock(String[] a) {
        nm = a[0];
        change = Float.parseFloat(a[1]);
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return nm;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Float getchange() {
        return change;
    }
    /**
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.getchange() > that.getchange()) return 1;
        else if (this.getchange() < that.getchange()) return -1;
        else if ((this.getname().compareTo(that.getname())) > 0) return 1;
        else return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getname() + " " + getchange();
    }
}
