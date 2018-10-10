import java.util.*;
import java.io.*;
class test{
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("out.txt"));
		Scanner sc1 = new Scanner(new File("output001.txt"));
			int i = 1;
		while(sc.hasNextLine()){
			if(!sc.nextLine().equals(sc1.nextLine())){
				System.out.println(i);
			}
			i++;
		}
		}catch(Exception e){
			System.out.println("hello");
		}
		
	}
}