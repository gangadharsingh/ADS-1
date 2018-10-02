class Insertionsort {
	Team[] team;
	int size;
	Insertionsort(final Team[] inp, final int len) {
		team = inp;
		size = len;
	}
	Team[] insertsort() {
		for (int i = 1; i < size; i++) {
 			for (int j = i; j > 0; j--) {
 				int max = j;
	 			if (team[j-1].getwins() < team[j].getwins()) {
	 				max = j-1;
				} else if (team[j].getwins() == team[j-1].getwins()) {
	 				if (team[j].getloses() < team[j-1].getloses()) {
	 					max = j-1;
	 				}
	 				if (team[j].getloses() == team[j-1].getloses()) {
		 				if (team[j].getdraw() > team[j-1].getdraw()) {
		 					max = j-1;
		 					}
		 				}
	 			}
				swap(team, j, max);

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