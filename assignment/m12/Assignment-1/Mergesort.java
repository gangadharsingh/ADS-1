/**
 * Class for mergesort.
 */
public class Mergesort {
    /**
     * Constructs the object.
     */
    public Mergesort() { }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      mid   The middle
     * @param      hi    The higher
     */
    public static void mergesort(final Comparable[] a, final Comparable[] aux, final int lo, final int mid, final int hi) {
        // System.out.println(lo+"::"+mid+"::"+hi);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (aux[i] == null || a[i] == null) {
                break;
            }
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      aux   The auxiliary
     * @param      lo    The lower
     * @param      hi    The higher
     */
    public static void sort(final Comparable[] a, final Comparable[] aux, final int lo, final int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        mergesort(a, aux, lo, mid, hi);
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     */
    public static void sort(final Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }
    /**
     * { function_description }
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static boolean less(final Comparable v, final Comparable w) {
        return v.compareTo(w) > 0;
    }
        
    /**
     * Determines if sorted.
     *
     * @param      a     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * Determines if sorted.
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] a, final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    /**
     * { function_description }
     *
     * @param      a      { parameter_description }
     * @param      index  The index
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      mid    The middle
     * @param      hi     The higher
     */
    public static void mergesort(final Comparable[] a, final int[] index, final int[] aux, final int lo, final int mid, final int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = index[k]; 
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                    index[k] = aux[j++];
            else if (j > hi)                     index[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else                                 index[k] = aux[i++];
        }
    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[] indexSort(final Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        int[] aux = new int[n];
        sort(a, index, aux, 0, n-1);
        return index;
    }

    /**
     * { function_description }
     *
     * @param      a      { parameter_description }
     * @param      index  The index
     * @param      aux    The auxiliary
     * @param      lo     The lower
     * @param      hi     The higher
     */
    public static void sort(final Comparable[] a, final int[] index, final int[] aux, final int lo, final int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid + 1, hi);
        mergesort(a, index, aux, lo, mid, hi);
    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     */
    public static void show(final Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
