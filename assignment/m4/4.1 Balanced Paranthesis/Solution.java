import java.util.Scanner;
/**
 * Class for solution.
 * @author: gangadharsingh
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * empty constructor.
         */
    }
    /**
     * { main class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        Balanceparenthesis balance = new Balanceparenthesis();
        while (size > 0) {
            String input = sc.next();
            if (balance.checkParanthesis(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            size--;
        }
    }
}
