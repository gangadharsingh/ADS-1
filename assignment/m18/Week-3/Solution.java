import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() { }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numStock = Integer.parseInt(scan.nextLine());
        int run = (2 + 2 + 2);

        Stockdata[] freqBest = new Stockdata[((2 + 2 + 1)) * numStock];;
        Stockdata[] freqWorst = new Stockdata[((2 + 2 + 1)) * numStock];
        SymbolTable<String, Float> bstStock = new SymbolTable<String, Float>((2 + 2 + 1));
        SymbolTable<String, Float> wstStock = new SymbolTable<String, Float>((2 + 2 + 1));
        while (run > 0) {
            Stockdata stdata;
            MinHeap<Stockdata> minHp = new MinHeap<Stockdata> ();
            MaxHeap<Stockdata> maxHp = new MaxHeap<Stockdata> ();
            for (int i = 0; i < numStock; i++) {
                String[] testcase = scan.nextLine().split(",");
                stdata = new Stockdata(testcase[0], Float.parseFloat(testcase[1]));
                minHp.insert(stdata);
                maxHp.insert(stdata);
            }
            for (int i = 0; i < 5; i++) {
                freqBest[i] = maxHp.delMax();
                bstStock.put(freqBest[i].getname(), freqBest[i].getperChange());
                System.out.println(freqBest[i]);
            } System.out.println();
            for (int i = 0; i < 5; i++) {
                freqWorst[i] = minHp.delMin();
                wstStock.put(freqWorst[i].getname(), freqWorst[i].getperChange());
                System.out.println(freqWorst[i]);
            } System.out.println();
            run--;
        }
        int numQuery = Integer.parseInt(scan.nextLine());
        String[] query = scan.nextLine().split(",");
        while (numQuery > 0) {
            switch (query[0]) {
            case "get":
                if (query[1].equals("maxST")) {
                    System.out.println(bstStock.get(query[1]));
                } else if (query[1].equals("minST")) {
                    System.out.println(wstStock.get(query[1]));
                }
                break;
            case "intersection":
                // for (int i = 0; i < bstStock.size(); i++) {
                //     for (int j = 0; j < wstStock.size(); j++ ) {
                //         if (bstStock[i]) {

                //         }
                //     }
                // }
                break;
            }
            numQuery--;
        }
    }
}

/**
 * Class for stockdata.
 */
class Stockdata implements Comparable<Stockdata> {
    /**
     * { var_description }
     */
    String name;
    /**
     * { var_description }
     */
    Float perChange;
    /**
     * Constructs the object.
     *
     * @param      nm       { parameter_description }
     * @param      pchange  The pchange
     */
    Stockdata(String nm, Float pchange) {
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
    public Float getperChange() {
        return perChange;
    }
    /**
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stockdata that) {
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
