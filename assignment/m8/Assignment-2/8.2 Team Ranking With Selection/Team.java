/**.
 * Class for team.
 */
public class Team {
	/**.
	 * { teamname .
	 */
	private String teamname;
	/**.
	 * { var_description .
	 */
	private int wins;
	/**.
	 * { var_description .
	 */
	private int loses;
	/**.
	 * { var_description .
	 */
	private int draw;
	/**.
	 * Constructs the object.
	 */
	private Team() { }
	/**.
	 * Constructs the object.
	 *
	 * @param      inp   The inp.
	 */
	public Team(final String[] inp) {
		teamname = inp[0];
		wins = Integer.parseInt(inp[1]);
		loses = Integer.parseInt(inp[2]);
		draw = Integer.parseInt(inp[3]);
	}
	/**.
	 * { function_description .
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public String geteam() {
		return teamname;
	}
	/**.
	 * { function_description .
	 *
	 * @param      tm    The time.
	 */
	public void seteam(final String tm) {
		teamname = tm;
	}
	/**.
	 * { function_description .
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public int getwins() {
		return wins;
	}
	/**.
	 * { function_description .
	 *
	 * @param      win   The window.
	 */
	public void sewins(final int win)  {
		wins = win;
	}
	/**.
	 * { function_description .
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public int getloses() {
		return loses;
	}
	/**.
	 * { function_description .
	 *
	 * @param      lose  The lose.
	 */
	public void seloses(final int lose)  {
		loses = lose;
	}
	/**.
	 * { function_description .
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public int getdraw() {
		return draw;
	}
	/**.
	 * { function_description .
	 *
	 * @param      dr    { parameter_description }.
	 */
	public void sedraw(final int dr)  {
		draw = dr;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		str = geteam();
		return str;
	}
}
