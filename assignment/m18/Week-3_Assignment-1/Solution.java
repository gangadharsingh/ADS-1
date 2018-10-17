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
		Stockdata[] freqBest = new Stockdata[(5)*numStock];;
		Stockdata[] freqWorst = new Stockdata[(5)*numStock];
		SymbolTable<String, Integer> bestStock = new SymbolTable<String, Integer>();
		SymbolTable<String, Integer> worstStock = new SymbolTable<String, Integer>();
		while(run > 0) {
			for (int i = 0; i < numStock; i++) {
				String[] testcase = scan.nextLine().split(",");
				stdata[i] = new Stockdata(testcase[0], Float.parseFloat(testcase[1]));
			}
			minHp = new MinHeap(stdata, numStock);
			maxHp = new MaxHeap(stdata, numStock);
			minHp.sort();
			maxHp.sort();
			bestStock = new SymbolTable<String, Integer>();
			for (int i = 0; i < 5; i++) {
				freqWorst[i] = minHp.getitem(i);
				freqBest[i] = maxHp.getitem(i);
			}
			run--;
		}
		int[] bestcount = new int[freqBest.length];
		int[] worstcount = new int[freqWorst.length];
		int bcount = 0;
		int wcount = 0;
		String[] beststock = new String[freqBest.length];
		String[] worststock = new String[freqWorst.length];
		for (int i = 0; i < freqBest.length; i++) {
			for (int j = 1; j < freqBest.length-1; j++) {
				if (freqBest[i].getname().equals(freqBest[j].getname())) {
					beststock[i] = freqBest[i].getname();
					bestcount[i] = bcount++;
				} if (freqWorst[i].getname().equals(freqWorst[j].getname())) {
					worststock[i] = freqWorst[i].getname();
					worstcount[i] = wcount++;
				}
			}
		}
		for (int i = 0; i < freqBest.length; i++) {
			for (int j = 0; j < (5); j++) {
				System.out.println(freqBest[i].getname()+" "+freqBest[i].getperChange());
			}
			System.out.println();
			for (int j = 0; j < (5); j++) {
				System.out.println(freqWorst[i].getname()+" "+freqWorst[i].getperChange());
			}
			System.out.println();
		}
		int query = Integer.parseInt(scan.nextLine());
		stdata = new Stockdata[numStock];
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
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return name + " " + perChange;
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
