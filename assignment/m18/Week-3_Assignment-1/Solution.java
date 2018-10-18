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
        BinarySearchST<String, Integer> beststock = new BinarySearchST<String, Integer> (st);
        BinarySearchST<String, Integer> worststock = new BinarySearchST<String, Integer> (st);
        for (int i = 0; i < 6; i++) {
            MaxPQ<Stock> max = new MaxPQ<Stock> (st);
            MinPQ<Stock> min = new MinPQ<Stock> (st);
            for (int j = 0; j < st; j++) {
                String[] str = s.nextLine().split(",");
                max.insert(new Stock(str));
                min.insert(new Stock(str));
            }
            for(int j = 0; j < 5; j++) {
                Stock empty = max.delMax();
                System.out.println(empty);
                beststock = putInBST(empty, beststock);
            }
            System.out.println();
            for (int j = 0; j < 5; j++) {
                Stock empty = min.delMin();
                System.out.println(empty);
                worststock = putInBST(empty, worststock);
            }
            System.out.println();
        }
        int query = Integer.parseInt(s.nextLine());
        for (int i = 0; i < query; i++) {
            String[] str = s.nextLine().split(",");
            switch(str[0]) {
                case "get":
                    if (str[1].equals("maxST")) {
                        if (beststock.contains(str[2])) {
                            System.out.println(beststock.get(str[2]));
                        } else {
                            System.out.println(0);
                        }
                    } else if (str[1].equals("minST")) {
                        if (worststock.contains(str[2])) {
                            System.out.println(worststock.get(str[2]));
                        } else {
                            System.out.println(0);
                        }
                    }
                    break;
                case "intersection":
                    for (i = 0; i < st; i++) {
                        if (beststock.get(beststock.select(i)).equals(worststock.get(worststock.select(i)))) {
                            System.out.println(beststock.get(beststock.select(i)));
                        }
                    }
                    break;
            }
        }
        
    }
    public static BinarySearchST<String, Integer> putInBST(final Stock key, final BinarySearchST<String, Integer> bst) {
        if (bst.contains(key.getname())) {
            bst.put(key.getname(), bst.get(key.getname()) + 1);
        }
        else {
            bst.put(key.getname(), 1);
        }
        return bst;
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
