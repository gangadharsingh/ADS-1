import java.util.Scanner;
import java.util.Arrays;
class HashTable {
    class Node {
        private String key;
        private String val;
        private Node next;
        Node(final String k, final String v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        String getValue() {
            return this.val;
        }
        String getkey() {
            return this.key;
        }
        void setvalue(final String v) {
            this.val = v;
        }
    }
    private Node[] st;
    private int size = (2 * (5)) * (2 * (5));
    HashTable() {
        st = new Node[size];
    }
    int hash(final String k) {
        final Integer num = 0x7fffffff;
        return (k.hashCode() & num) % size;
    }
    public void resize() {
        st = Arrays.copyOf(st, 2 * size);
    }
    public void put(final String k, final String v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    public String get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                return x.getValue();
            }
        }
        return "Student doesn't exists...";
    }
}
public class Solution {
    public static void main(String[] args) {
        HashTable map = new HashTable();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Student[] stud = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] detail = s.nextLine().split(".");
            // stud[i] = new Student(detail);
            String format = detail[1]+","+detail[2];
            map.put(detail[0], format);
        }
        int q = Integer.parseInt(s.nextLine());
        for (int i = 0; i < q; i++) {
            String[] query = s.nextLine().split(" ");
            String[] str = (map.get(query[1])).split(".");
            if(query[2].equals("1"))
                System.out.println(str[0]);
            else
                System.out.println(str[1]);
        }
    }
}
class Student{
    private String roll;
    private String name;
    private double totmarks;
    Student(String[] detail) {
        roll = detail[0];
        name = detail[1];
        totmarks = Double.parseDouble(detail[2]);
    }
     public String getroll(){
      return roll;
     }
     public String getname(){
      return name;
     }
     public Double gettotmarks(){
      return totmarks;
     }
}