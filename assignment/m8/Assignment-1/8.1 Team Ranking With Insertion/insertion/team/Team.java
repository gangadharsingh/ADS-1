package team;
/**
 * Class for team.
 */
public class Team {
	/**
	 * teamname field.
	 */
	public String teamname;
	/**
	 * no of wins.
	 */
	public int wins;
	/**
	 * no of losses.
	 */
	public int loses;
	/**
	 * no of draw.
	 */
	public int draw;
	/**
	 * Constructs the object.
	 * Best: O(1)
     * Avg: O(1)
     * Worst : O(1)
	 * @param      inp   The inp
	 */
	public Team(String[] inp) {
		teamname = inp[0];
		wins = Integer.parseInt(inp[1]);
		loses = Integer.parseInt(inp[2]);
		draw = Integer.parseInt(inp[3]);
	}
	/**
	 * get team name.
	 *
	 * @return     { respestive value of filds }
	 */
	public String geteam() {
		return teamname;
	}
	/**
	 * { getters and setters method }
	 *
	 * @param      tm    The time
	 */
	public void seteam(String tm) {
		teamname = tm;
	}
	/**
	 * { getters and setters method }
	 *
	 * @return     { respestive value of filds }
	 */
	public int getwins() {
		return wins;
	}
	/**
	 * { getters and setters method }
	 *
	 * @param      win   The window
	 */
	public void sewins(int win)  {
		wins = win;
	}

	/**
	 * { getters and setters method }
	 *
	 * @return     { respestive value of filds }
	 */
	public int getloses() {
		return loses;
	}
	/**
	 * { getters and setters method }
	 *
	 * @param      lose  The lose
	 */
	public void seloses(int lose)  {
		loses = lose;
	}

	/**
	 * { getters and setters method }
	 *
	 * @return     { respestive value of filds }
	 */
	public int getdraw() {
		return draw;
	}
	/**
	 * { getters and setters method }
	 *
	 * @param      dr    { parameter_description }
	 */
	public void sedraw(int dr)  {
		draw = dr;
	}
	/**
	 * Returns a string representation of the object.
	 * Best: O(1)
     * Avg: O(1)
     * Worst : O(1)
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		str = geteam();
		return str;
	}
}
