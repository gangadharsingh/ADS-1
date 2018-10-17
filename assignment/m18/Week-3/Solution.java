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
		int run = numStock*(2+2+2);
		MinHeap minHp;
		MaxHeap maxHp;
		Stockdata[] stdata = new Stockdata[numStock];
		Stockdata[] freqBest = new Stockdata[((2+2+1))*numStock];;
		Stockdata[] freqWorst = new Stockdata[((2+2+1))*numStock];
		SymbolTable<String, Integer> bestStock = new SymbolTable<String, Integer>();
		SymbolTable<String, Integer> worstStock = new SymbolTable<String, Integer>();
		while(run > 0) {
			minHp = new MinHeap(stdata, numStock);
			maxHp = new MaxHeap(stdata, numStock);
			for (int i = 0; i < numStock; i++) {
				String[] testcase = scan.nextLine().split(",");
				stdata[i] = new Stockdata(testcase[0], Float.parseFloat(testcase[1]));
				maxHp.insertMax(stdata[i]);
				minHp.insert(stdata[i]);
			}
			bestStock = new SymbolTable<String, Integer>();
			for (int i = 0; i < (2+2+1); i++) {
				freqWorst[i] = minHp.delMin();
				freqBest[i] = maxHp.delMax();
			}
			run--;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(freqBest[i]);
			System.out.println(freqWorst[i]);
		}
		
	}
}

/**
 * Class for stockdata.
 */
class Stockdata {
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
	public String getname(){
	  return name;
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Float getperChange(){
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
        if (this.getperChange() < that.getperChange()) {
            return 1;
        } else if (this.getperChange() > that.getperChange()) {
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
/**
 * Class for querydata.
 */
class Querydata {
	/**
	 * Constructs the object.
	 */
	Querydata() { }
	/**
	 * { var_description }
	 */
	SymbolTable<String, Integer> stock;
	/**
	 * Constructs the object.
	 *
	 * @param      st    { parameter_description }
	 */
	Querydata(SymbolTable<String, Integer> st) {
		stock = st;
	}
}