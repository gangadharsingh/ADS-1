import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort st = new MergeSort();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            st.sort(tokens);
            String str = "[";
            int i;
            for (i = 0; i < tokens.length - 1; i++) {
                str += tokens[i] + ", ";
            }
            str += tokens[i] + "]";
            System.out.println(str);
            System.out.println();
        }
    }
}

/**
 * Class for merge sort.
 */
final class MergeSort {
    /**
     * cut off for sending to isertionsort to improvement.
     */
    private int cutoff = 2 + 2 + 2 + 1;
    /**
     * getter method.
     *
     * @return     { description_of_the_return_value }
     */
     public int getcutoff() {
      return cutoff;
     }
     /**
      * setter for cutoff.
      *
      * @param      cutof  The cutof
      */
     public void setcutoff(final int cutof) {
      this.cutoff = cutof;
     }
    /**
     * Constructs the object.
     */
    MergeSort() { }
    /**
     * sort method to divide in to equals.
     *  halves using the recursion.
     *complexity for this method is O(N)
     * @param      arr   The arr
     */
    public void sort(final Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }
        sort(aux, arr, 0, arr.length - 1);
    }
    /**
     * helper sort method for above sort method where.
     * actual division takes place.
     * complexity is O(log(N))
     *
     * @param      arr   The arr
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      high  The high
     */
    public void sort(
final Comparable[] arr, final Comparable[] aux,
 final int lo, final int high) {
        if (high <= lo + getcutoff()) {
            insertionSort(aux, lo, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid =  lo + (high - lo) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, high);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = lo; i <= high; i++) {
                aux[i] = arr[i];
            }
            System.out.println(
"Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(arr, aux, lo, mid, high);
    }
    /**
     * issorted helper method it will call.
     *  overloaded issorted method
     *complexxity is 1
     * @param      a     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted or not.
     * complexity is O(N)
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      high  The high
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int lo, final int high) {
        for (int i = lo + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * this method helps to merge the two arrays.
     * complexity is O(N).
     *
     * @param      arr   The arr
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      mid   The middle
     * @param      high  The high
     */
    public void merge(final Comparable[] arr, final Comparable[] aux,
                      final int lo, final int mid, final int high) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= high; k++) {
            if (i > mid) {
                aux[k] = arr[j++];
            } else if (j > high) {
                aux[k] = arr[i++];
            } else if (less(arr[j], arr[i])) {
                aux[k] = arr[j++];
            } else {
                aux[k] = arr[i++];
            }
        }
    }
    /**
     * this method helps to determine weather the given.
     * array is sorted o not.
     * complexity is O(1)
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * this method is called when it reaches the cutoff mark.
     * or less
     * complexity is O(N^2).
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      high  The high
     */
    public void insertionSort(final Comparable[] a,
                              final int lo, final int high) {
        for (int i = lo; i <= high; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }
            }
        }
    }
    /**
     * this method help to swap two different elements.
     * complexity is O(1).
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void swap(final Comparable[] a,
                     final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}