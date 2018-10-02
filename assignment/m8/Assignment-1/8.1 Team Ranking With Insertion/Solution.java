import java.util.Scanner;
class Solution {
    public static void main(final String[] args) {
        Scanner scan =  new Scanner(System.in);
        Team[] team = new Team[10];
        int size = 0;
        while (scan.hasNextLine()) {
            String line =  scan.nextLine();
            if (line.equals("")) {
                break;
            }
            String[] tokens = line.split(",");
            team[size++] = new Team(tokens);
        }
        Insertionsort itsort = new Insertionsort(team, size);
        team = itsort.insertsort();
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str += team[i].geteam() + ",";
        }
        str += team[size - 1].geteam();
        System.out.println(str);
    }
}
