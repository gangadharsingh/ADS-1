/**
 * Class for team.
 */
public class Team {
    /**
     * teamname field.
     */
    private String teamname;
    /**
     * no of wins.
     */
    private int wins;
    /**
     * no of losses.
     */
    private int loses;
    /**
     * no of draw.
     */
    private int draw;
    /**
     * Constructs the object.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @param      inp   The inp.
     */
    public Team(final String[] inp) {
        teamname = inp[0];
        wins = Integer.parseInt(inp[1]);
        loses = Integer.parseInt(inp[2]);
        draw = Integer.parseInt(inp[2 + 1]);
    }
    /**
     * get team name.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @return     { respestive value of filds }.
     */
    public String geteam() {
        return teamname;
    }
    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @param      tm    The time.
     */
    public void seteam(final String tm) {
        teamname = tm;
    }
    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @return     { respestive value of filds }.
     */
    public int getwins() {
        return wins;
    }
    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @param      win   The window.
     */
    public void sewins(final int win)  {
        wins = win;
    }

    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @return     { respestive value of filds }.
     */
    public int getloses() {
        return loses;
    }
    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @param      lose  The lose.
     */
    public void seloses(final int lose)  {
        loses = lose;
    }

    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @return     { respestive value of filds }.
     */
    public int getdraw() {
        return draw;
    }
    /**
     * { getters and setters method }.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @param      dr    { parameter_description }.
     */
    public void sedraw(final int dr)  {
        draw = dr;
    }
    /**
     * Returns a string representation of the object.
     * Best: O(1).
     * Avg: O(1).
     * Worst : O(1).
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = geteam();
        return str;
    }
}
