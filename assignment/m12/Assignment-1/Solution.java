import java.util.Scanner;
import java.util.ArrayList;

 /**
  * Class for solution.
  */
 public class Solution {
 	/**
 	 * Constructs the object.
 	 */
 	private Solution() { }

	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfStudqual = scan.nextInt();
		int noOfVac = scan.nextInt();
		int noOfUnresVac = scan.nextInt();
		int noOfBCVac = scan.nextInt();
		int noOfSCVac = scan.nextInt();
		int noOfSTVac = scan.nextInt();
		Student[] stud = new Student[30];
		int size = 0;
		String line = "";
		while(noOfStudqual >0) {
			line = scan.next();
			String[] token = line.split(",");
			if (!line.equals("")) {
				stud[size] = new Student(token);
				size++;
			}
			noOfStudqual--;
		}
			Mergesort.sort(stud);
		for (int i = 0; i < size-1; i++) {
			System.out.print(stud[i].print()+"\n");
		}
		System.out.print(stud[size-1].print());
	}
}
class Student implements Comparable<Student>{
	/**
	 * { var_description }
	 */
	private String studname;
	/**
	 * { var_description }
	 */
	private String dob;
	/**
	 * { var_description }
	 */
	private String sub1mark;
	/**
	 * { var_description }
	 */
	private String sub2mark;
	/**
	 * { var_description }
	 */
	private String sub3mark;
	/**
	 * { var_description }
	 */
	private String totalmark;
	/**
	 * { var_description }
	 */
	private String resCast;
	/**
	 * { var_description }
	 */
	private String[] date;

	/**
	 * Constructs the object.
	 *
	 * @param      inp   The inp
	 */
	public Student(final String[] inp) {
		studname = inp[0];
		dob = inp[1];
		sub1mark = inp[2];
		sub2mark = inp[3];
		sub3mark = inp[4];
		totalmark = inp[5];
		resCast = inp[6];
		date = dob.split("-");
	}
	/**
	 * { function_description }
	 *
	 * @param      stud  The stud
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(Student stud) {
		if (Integer.parseInt(this.totalmark) > Integer.parseInt(stud.totalmark)) {
			return 1;
		} else if (Integer.parseInt(this.totalmark) < Integer.parseInt(stud.totalmark)) {
			return -1;
		} else if (Integer.parseInt(this.sub3mark) > Integer.parseInt(stud.sub3mark)) {
			return 1;
		} else if (Integer.parseInt(this.sub3mark) < Integer.parseInt(stud.sub3mark)) {
			return -1;
		} else if (Integer.parseInt(this.sub2mark) > Integer.parseInt(stud.sub2mark)) {
			return 1;
		} else if (Integer.parseInt(this.sub2mark) < Integer.parseInt(stud.sub2mark)) {
			return -1;
		} else if (Integer.parseInt(this.date[0]) < Integer.parseInt(stud.date[0])) {
			return 1;
		} else if (Integer.parseInt(this.date[0]) < Integer.parseInt(stud.date[0])) {
			return -1;
		} else {
			return 0;
		}
	}

	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getstudname(){
	  return studname;
	 }

	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getdob(){
	  return dob;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String[] getdate(){
	  return date;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getsub1mark(){
	  return sub1mark;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getsub2mark(){
	  return sub2mark;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getsub3mark(){
	  return sub3mark;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String gettotalmark(){
	  return totalmark;
	 }
	 /**
	  * { function_description }
	  *
	  * @return     { description_of_the_return_value }
	  */
	 public String getresCast(){
	  return resCast;
	 }
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String print() {
		return getstudname() + "," + gettotalmark() + ","+getresCast();
	}
}
