import java.util.Scanner;
import java.util.ArrayList;
class Solution {
	public static void main(String[] args) {
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
		while(scan.hasNext() && scan.next().equals(null)) {
			line = scan.next();
			String[] token = line.split(",");
			stud[size] = new Student(token);
			size++;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(stud);
		}
	}
}
class Student implements Comparable<Student>{
	public String studname;
	public String dob;
	public String sub1mark;
	public String sub2mark;
	public String sub3mark;
	public String totalmark;
	public String resCast;
	String[] date;
	public Student(String[] inp) {
		studname = inp[0];
		dob = inp[1];
		sub1mark = inp[2];
		sub2mark = inp[3];
		sub3mark = inp[4];
		totalmark = inp[5];
		resCast = inp[6];
		date = dob.split("-");
	}
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

	 public String getstudname(){
	  return studname;
	 }
	 public void setstudname(String studname){
	  this.studname = studname;
	 }
	 public String getdob(){
	  return dob;
	 }
	 public void setdob(String dob){
	  this.dob = dob;
	 }
	 public String[] getdate(){
	  return date;
	 }
	 public void setdate(String[] date){
	  this.date = date;
	 }
	 public String getsub1mark(){
	  return sub1mark;
	 }
	 public void setsub1mark(String sub1mark){
	  this.sub1mark = sub1mark;
	 }
	 public String getsub2mark(){
	  return sub2mark;
	 }
	 public void setsub2mark(String sub2mark){
	  this.sub2mark = sub2mark;
	 }
	 public String getsub3mark(){
	  return sub3mark;
	 }
	 public void setsub3mark(String sub3mark){
	  this.sub3mark = sub3mark;
	 }
	 public String gettotalmark(){
	  return totalmark;
	 }
	 public void settotalmark(String totalmark){
	  this.totalmark = totalmark;
	 }
	 public String getresCast(){
	  return resCast;
	 }
	 public void setresCast(String resCast){
	  this.resCast = resCast;
	 }
	public String toString() {
		return getstudname() + "," + gettotalmark() + ","+getresCast();
	}
}