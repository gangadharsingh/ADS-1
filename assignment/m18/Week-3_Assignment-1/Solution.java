import java.util.Scanner;
class Solution {
	Solution() { }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numStock = Integer.parseInt(scan.nextLine());
		int run = numStock*6;
		MinHeap minHp; /*= new MinHeap<Stockdata>();*/
		MaxHeap maxHp;/* = new MaxHeap<Stockdata>();*/
		while(run > 0) {
			Stockdata[] stdata = new Stockdata[numStock];
			Stockdata[] freqBest = new Stockdata[5];
			Stockdata[] freqWorst = new Stockdata[5];
			for (int i = 0; i < numStock; i++) {
				String[] testcase = scan.nextLine().split(",");
				stdata[i] = new Stockdata(testcase[0], Float.parseFloat(testcase[1]));
				// minHp(testcase, testcase.size);
				// System.out.println(stdata[i]);
			}
			minHp = new MinHeap(stdata, numStock);
			minHp.sort();
			maxHp = new MaxHeap(stdata, numStock);
			maxHp.sort();
			for (int i = 1; i <= 5; i++) {
				freqWorst[i-1] = minHp.getitem(i);
				freqBest[i-1] = maxHp.getitem(i);
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(freqBest[i]);
				System.out.println("worst");
				System.out.println(freqWorst[i]);
			}
			run--;
		}
	}
}

class Stockdata {
	String name;
	Float perChange;
	Stockdata(String nm, Float pchange) {
		name = nm;
		perChange = pchange;
	}
	public String getname(){
	  return name;
	}
	public Float getperChange(){
	  return perChange;
	}
	public String toString() {
		return name + " " + perChange;
	}
	public int compareTo(final Stockdata that) {
        if (this.getperChange() > that.getperChange()) {
            return 1;
        } else if (this.getperChange() < that.getperChange()) {
            return -1;
        }
        return 0;
    }
}
class Querydata {
	Querydata() { }
}