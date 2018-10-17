/**
 * Class for selection sort.
 */
public class SelectionSort {
    /**
     * { field }.
     */
    private Team[] team;
    /**
     * { field }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      tm    The time.
     * @param      sz    The size.
     */
    public SelectionSort(final Team[] tm, final int sz) {
        team = tm;
        size = sz;
    }
    /**
     * { sorting Team array }.
     * Best: O(N^2).
     * Avg: O(N^2).
     * Worst : O(N^2).
     * @return     { Team array }.
     */
    public Team[] sort() {
        for (int i = 0; i < size - 1; i++) {
            int max = i;
            for (int j = i + 1; j < size; j++) {
                if (team[j].getwins() > team[max].getwins()) {
                    max = j;
                } else if (team[j].getwins() == team[max].getwins()) {
                    if (team[j].getloses() < team[max].getloses()) {
                        max = j;
                    }
                    if (team[j].getloses() == team[max].getloses()) {
                        if (team[j].getdraw() > team[max].getdraw()) {
                            max = j;
                        }
                    }
                }
            }
            Team temp = team[i];
            team[i] = team[max];
            team[max] = temp;
        }
        return team;
    }
}
