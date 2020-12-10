// should implement MaxPQ API (pg 309)
// delMax -> delMin
//delMin will remove and return the minimum key while maintaining heap order
// book discusses this at length
    // MaxPQ -> MinPQ by reversing the sense of the comparison in less()

// create a Data class
// create a class of your choosing after the Transaction class described in the book
// implement Comparable and sort more complex objects according to a property it holds

// main program:
// show that implementation can be used to sort an array of randomly generated Integers
// manually create an array of objects based on the class you defined
// show that these can be sorted as well


public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq; // heap-ordered complete binary tree

    private int N = 0; // in pq[1..N] with pq[0] unused

    public MinPQ(int minN) {
        pq = (Key[]) new Comparable[minN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key v) {
        N = N + 1;
        pq[N] = v;

        //swim up new item to it's right place
        swim(N);
    }

    public Key delMin() {
        Key Min = pq[1];
        exch(1, N);
        N = N - 1;
        sink(1);

        //memory clean up
        pq[N + 1] = null;
        return Min;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }


    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void swim(int v) {
        while (v > 1 && less(v, v / 2)) {
            exch(v / 2, v);
            v = v / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && (!less(j, j + 1))) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }

    }
}



