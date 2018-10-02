class SelectionSort {
 	Team[] team;
 	int size;
 	SelectionSort(Team[] tm, int sz) {
 		team = tm;
 		size = sz;
 	}
 	Team[] sort() {
 		for (int i = 0; i < size - 1; i++) {
 			int max = i;
 			for (int j = i+1; j < size; j++) {
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
