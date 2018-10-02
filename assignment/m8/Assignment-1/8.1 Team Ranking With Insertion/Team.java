class Team {
	String teamname;
	int wins;
	int loses;
	int draw;
	Team() { }
	Team(String[] inp) {
		teamname = inp[0];
		wins = Integer.parseInt(inp[1]);
		loses = Integer.parseInt(inp[2]);
		draw = Integer.parseInt(inp[3]);
	}
	String geteam() {
		return teamname;
	}
	void seteam(String tm) {
		teamname = tm;
	}

	int getwins() {
		return wins;
	}
	void sewins(int win)  {
		wins = win;
	}

	int getloses() {
		return loses;
	}
	void seloses(int lose)  {
		loses = lose;
	}

	int getdraw() {
		return draw;
	}
	void sedraw(int dr)  {
		draw = dr;
	}
	public String toString() {
		String str = "";
		str = geteam();
		return str;
	}
}
