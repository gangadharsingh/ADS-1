import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for hash table.
 */
class HashTable {
    /**.
     * Class for node.
     */
    class Node {
        /**.
         * { var_description }
         */
        private String key;
        /**.
         * { var_description }
         */
        private Student val;
        /**.
         * { var_description }
         */
        private Node next;
        /**.
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      n     { parameter_description }
         */
        Node(final String k, final Student v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**.
         * Gets the value.
         *
         * @return     The value.
         */
        Student getValue() {
            return this.val;
        }
        /**.
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        String getkey() {
            return this.key;
        }
        /**.
         * { function_description }
         *
         * @param      v     { parameter_description }
         */
        void setvalue(final Student v) {
            this.val = v;
        }
    }
    /**.
     * { var_description }
     */
    private Node[] st;
    /**.
     * { var_description }
     */
    private int size = (2 * (2 + 2 + 1)) * (2 * (2 + 2 + 1));
    /**.
     * Constructs the object.
     */
    HashTable() {
        st = new Node[size];
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    int hash(final String k) {
        final Integer num = 0x7fffffff;
        return (k.hashCode() & num) % size;
    }
    /**.
     * { function_description }
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * size);
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     * @param      v     { parameter_description }
     */
    public void put(final String k, final Student v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(v);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Student get(final String k) {
        int i = hash(k);
        Node x = null;
        Student stud = null;
        for (x = st[i]; x != null; x = x.next) {
            // System.out.println(x.getValue().getname());
            if (k.equals(x.getkey())) {
                stud = x.getValue();
            }
        }
        return stud;
    }
}
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        HashTable map = new HashTable();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Student[] stud = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] detail = s.nextLine().split(",");
            stud[i] = new Student(detail);
            map.put(detail[0], stud[i]);
        }
        int q = Integer.parseInt(s.nextLine());
        for (int i = 0; i < q; i++) {
            String[] query = s.nextLine().split(" ");
            if (map.get(query[1]) == null) {
                System.out.println("Student doesn't exists...");
            } else {
            if (query[2].equals("1")) {
                System.out.println(map.get(query[1]).getname());
            }
            else {
                System.out.println(map.get(query[1]).gettotmarks());
            }
            }
        }
    }
}
/**.
 * Class for student.
 */
class Student {
    /**.
     * { var_description }
     */
    private String roll;
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * { var_description }
     */
    private double totmarks;
    /**.
     * Constructs the object.
     */
    private Student() { }
    /**.
     * Constructs the object.
     *
     * @param      detail  The detail
     */
    Student(final String[] detail) {
        roll = detail[0];
        name = detail[1];
        totmarks = Double.parseDouble(detail[2]);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getroll() {
        return roll;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Double gettotmarks() {
        return totmarks;
    }
}
