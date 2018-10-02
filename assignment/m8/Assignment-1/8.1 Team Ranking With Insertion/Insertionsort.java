class Insertionsort {
	Team[] team;
	int size;
	Insertionsort(final Team[] inp, final int len) {
		team = inp;
		size = len;
	}
	Team[] insertsort() {
		for (int i = 1; i > size-1; i++) {
			// int max = i;
			for (int j = i; j > 0; j--) {
				System.out.println(team);
				System.out.println(team[j].getwins()+":team[j], team[j-1]:"+team[j-1].getwins());
				if (team[j].getwins() < team[j-1].getwins()) {
					swap(team, j, j-1);
					System.out.println(team[j]+":team[j], team[j-1]:"+team[j-1]);
				}
			}
		}
		return team;
	}
	void swap(final Team[] tm, final int i, final int j) {
		Team temp = tm[i];
		tm[i] = tm[j];
		tm[j] = temp;
	}
}