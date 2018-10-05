package team;
public class Team {
	String teamname;
	int wins;
	int loses;
	int draw;
	Team() { }
	public Team(String[] inp) {
		teamname = inp[0];
		wins = Integer.parseInt(inp[1]);
		loses = Integer.parseInt(inp[2]);
		draw = Integer.parseInt(inp[3]);
	}
	public String geteam() {
		return teamname;
	}
	public void seteam(String tm) {
		teamname = tm;
	}

	public int getwins() {
		return wins;
	}
	public void sewins(int win)  {
		wins = win;
	}

	public int getloses() {
		return loses;
	}
	public void seloses(int lose)  {
		loses = lose;
	}

	public int getdraw() {
		return draw;
	}
	public void sedraw(int dr)  {
		draw = dr;
	}
	public String toString() {
		String str = "";
		str = geteam();
		return str;
	}
}
