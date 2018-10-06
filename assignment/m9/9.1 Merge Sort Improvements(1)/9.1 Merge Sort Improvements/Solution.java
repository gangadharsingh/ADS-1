import java.util.Scanner;
import java.util.Comparator;
import java.lang.*;
class Mergesrt {
    public Mergesrt() { }
    public static final int CUTOFF = 7;
    public static void merge(Comparable[] a, Comparable[] aux, int lo,
        int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
              aux[k] = a[i++];  
            } else if (less(a[j], a[i])) {
              aux[k] = a[j++];  
            } else {
                aux[k] = a[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    public static void sort(Comparable[] a, Comparable[] aux,
        int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            System.out.println("Insertion sort method invoked...");
            insertionsort(aux, lo, hi);
            return ;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) {
            System.arraycopy(a, lo, aux, lo, hi-lo+1);
            return ;
        }
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }
    public static void insertionsort(Comparable[] a,
        int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
        }
    }
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) { return false; }
        }
        return true;
    }
    public static void show(Object[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1]+"]");
            System.out.println();
    }
}
public class Solution {
    public Solution() { }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line  = scan.nextLine();
        while(!line.equals("")) {
            // String line = "";
            String[] a = line.split(" ");
            Mergesrt.sort(a);
            Mergesrt.show(a);
            line  = scan.nextLine();
        }
        // Mergesrt mergesrt = new Mergesrt();
    }
}