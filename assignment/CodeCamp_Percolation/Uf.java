
/**
 * Class for uf.
 */
class Uf {
    /**
     * initializing fields.
     */
    private int[] id; //parent link
    private int[] size; //size of elements for roots
    private int count; //number of elements
    //
    // @param      n     { parameter_description }
    //
    Uf(final int n) {
        /**
         * constructs object.
         */
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    /**
     * {returning count of elements}.
     *
     * @return     { description_of_the_return_value }
     */
    public int count() {
        return count;
    }
    /**
     * {checking if connected or not}.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }
    /**
     * {checking for root of elements}.
     *
     * @param      p     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    /**
     * {making union of two inputs}.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     */
    public void union(final int p, final int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}