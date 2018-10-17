import java.util.Scanner;
/**
 * Class for solution.
 */
// class Solution {
//     /**
//      * Constructs the object.
//      */
//     Solution() { }
//     /**
//      * { function_description }
//      *
//      * @param      args  The arguments
//      */
//     public static void main(final String[] args) {
//         Scanner scan = new Scanner(System.in);
//         int numStock = Integer.parseInt(scan.nextLine());
//         int run = (2 + 2 + 2);

//         Stock[] freqBest = new Stock[(5) * numStock];;
//         Stock[] freqWorst = new Stock[(5) * numStock];
//         SymbolTable<String, Float> bstStock = new SymbolTable<String, Float>(5);
//         SymbolTable<String, Float> wstStock = new SymbolTable<String, Float>(5);
//         while (run > 0) {
//             Stock stdata;
//             MinHeap<Stock> minHp = new MinHeap<Stock> ();
//             MaxHeap<Stock> maxHp = new MaxHeap<Stock> ();
//             for (int i = 0; i < numStock; i++) {
//                 String[] testcase = scan.nextLine().split(",");
//                 stdata = new Stock(testcase[0], Float.parseFloat(testcase[1]));
//                 minHp.insert(stdata);
//                 maxHp.insert(stdata);
//             }
//             for (int i = 0; i < 5; i++) {
//                 freqBest[i] = maxHp.delMax();
//                 bstStock.put(freqBest[i].getname(), freqBest[i].getperChange());
//                 System.out.println(freqBest[i]);
//             } System.out.println();
//             for (int i = 0; i < 5; i++) {
//                 freqWorst[i] = minHp.delMin();
//                 wstStock.put(freqWorst[i].getname(), freqWorst[i].getperChange());
//                 System.out.println(freqWorst[i]);
//             } System.out.println();
//             run--;
//         }
//         int numQuery = Integer.parseInt(scan.nextLine());
//         String[] query = scan.nextLine().split(",");
//         while (numQuery > 0) {
//             switch (query[0]) {
//             case "get":
//                 if (query[1].equals("maxST")) {
//                     System.out.println(bstStock.get(query[1]));
//                 } else if (query[1].equals("minST")) {
//                     System.out.println(wstStock.get(query[1]));
//                 }
//                 break;
//             case "intersection":
//                 // for (int i = 0; i < bstStock.size(); i++) {
//                 //     for (int j = 0; j < wstStock.size(); j++ ) {
//                 //         if (bstStock[i]) {

//                 //         }
//                 //     }
//                 // }
//                 break;
//             }
//             numQuery--;
//         }
//     }
// }
final class Solution {
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SymbolTable best = new SymbolTable(n);
        SymbolTable worst = new SymbolTable(n);
        /**
         * to exit this loop it takes O(n^2) time.
         */
        for (int i = 0; i < 6; i++) {
            MaxPQ<Stock> maxpq = new MaxPQ<Stock>();
            MinPQ<Stock> minpq = new MinPQ<Stock>();
            for (int j = 0; j < n; j++) {
                String[] input = sc.nextLine().split(",");
                maxpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
                minpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
            }
            /**
             * to delete max it takes logN and to delete five maxs its takes NlogN.
             */
            int top = 5;
            while (top > 0) {
                Stock res = maxpq.delMax();
                System.out.println(res);
                Integer val = best.get(res.getname());
                if (val == null) {
                    best.put(res.getname(), 1);
                } else {
                    best.put(res.getname(), val + 1);
                }
                top--;
            }
            System.out.println();
            /**
             * to delete mix it takes logN and to delete five mins its takes NlogN.
             */
            top = 5;
            while (top > 0) {
                Stock res = minpq.delMin();
                System.out.println(res);
                /**
                 * to get the value from symbol table it takes logN.
                 */
                Integer val = worst.get(res.getname());
                if (val == null) {
                    worst.put(res.getname(), 1);
                } else {
                    worst.put(res.getname(), val + 1);
                }
                top--;
            }
            System.out.println();
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String tokens[] = sc.nextLine().split(",");
            /**
             * to get the value of key from symbol table it takes logN.
             */
            if (tokens[0].equals("get")) {
                if (tokens[1].equals("maxST")) {
                    Integer res = best.get(tokens[2]);
                    if (res == null) {
                        System.out.println("0");
                    } else {
                        System.out.println(res);
                    }
                } else {
                    Integer res = worst.get(tokens[2]);
                    if (res == null) {
                        System.out.println("0");
                    } else {
                        System.out.println(res);
                    }
                }
            } else {
                /**
                 * to get all the keys in symbol table it takes O(N)
                 * to print common elements it takes O(N)
                 */
                String[] keys = best.keys();
                for (String each : keys) {
                    if (worst.contains(each)) {
                        System.out.println(each);
                    }
                }
            }
        }
    }
}
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * { var_description }
     */
    String name;
    /**
     * { var_description }
     */
    Double perChange;
    /**
     * Constructs the object.
     *
     * @param      nm       { parameter_description }
     * @param      pchange  The pchange
     */
    Stock(String nm, Double pchange) {
        name = nm;
        perChange = pchange;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Double getperChange() {
        return perChange;
    }
    /**
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.getperChange() > that.getperChange()) {
            return 1;
        } else if (this.getperChange() < that.getperChange()) {
            return -1;
        } else if (this.getname().compareTo(that.getname()) > 0) {
            return 1;
        } else if (this.getname().compareTo(that.getname()) < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + " " + perChange;
    }
}
