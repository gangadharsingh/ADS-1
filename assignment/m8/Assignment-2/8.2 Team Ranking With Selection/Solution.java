import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * magic number.
     */
    public static final int NUM = 10;
    /**
     * {main function}.
     * Best: O(N).
     * Avg: O(N).
     * Worst : O(N).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Team[] tm = new Team[NUM];
        int size = 0;
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] tokens =  input.split(",");
            tm[size++] = new Team(tokens);
        }
        SelectionSort select = new SelectionSort(tm, size);
        tm = select.sort();
        String str = "";
        for (int i  = 0; i < size - 1; i++) {
            str += tm[i].toString() + ",";
        }
        str += tm[size - 1].toString();
        System.out.println(str);
    }
}
