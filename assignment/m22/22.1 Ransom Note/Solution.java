import java.util.Scanner;
import java.util.Arrays;
class HashTable {
    class Node {
        private String key;
        private Integer val;
        private Node next;
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        Integer getValue() {
            return this.val;
        }
        String getkey() {
            return this.key;
        }
        void setvalue(final Integer v) {
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
    public void put(final String k, final Integer v) {
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
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
public class Solution {
    public static void main(String[] args) {
        HashTable map = new HashTable();
        Scanner s = new Scanner(System.in);
        String[] num = s.nextLine().split(" ");
        String[] mag = s.nextLine().split(" ");
        String[] note = s.nextLine().split(" ");
        int i = 0;
        boolean flag = false;
        if(Integer.parseInt(num[0]) > Integer.parseInt(num[1])) {
            for (String meg: mag) {
                map.put(meg, 1);
            }
            for(String n: note) {
                // System.out.println("mapping "+map.get(n));
                if(map.get(n)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } else {
            flag = false;
        }
        if(flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}