import java.util.Scanner;
import java.util.Arrays;
class HashTable<Key, Value> {
    int keyCount;
    int size;
    Node[] node = (Node[]) new Object[size];
    class Node {
        Key key;
        Value value;
        Node next;
        Node(Key k, Value v) {
            key = k;
            value = v;
            next = null;
        }
        public Key getkey() {
            return key;
        }
        public Value getvalue() {
            return value;
        }
        public void setvalue(Value v) {
            value = v;
        }
    }
    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % size;
    }
    public void put(Key k, Value v) {
        int i = hash(k);
        for (Node nod = node[i]; nod != null; nod = nod.next) {
            if (k.equals(nod.key)) {
                nod.value = v;
            } else {
                node[i] = new Node(k, v);
            }
        }
    }
    public boolean get(Key key) {
        int i = hash(key);
        for (Node x = node[i]; x != null; x = x.next)
            if (key.equals(x.key)) {
                if(x.getvalue().compareTo(0) < 0) {
                    x.setvalue(x.setvalue(value));
                    return true;
                }else {
                    return false;
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
        int flag = 0;
        if (Integer.parseInt(num[0]) > Integer.parseInt(num[1])) {
            for (String meg : mag) {
                map.put(meg, 1);
            }
            for (String n : note) {
                // System.out.println("mapping "+map.get(n));
                if (map.get(n)) {
                    flag++;
                } else {
                    flag--;
                }
            }
            if (flag == note.length) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }
}