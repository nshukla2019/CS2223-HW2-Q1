import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    // stack items
    private Item[] a = (Item[]) new Object[1];

    // number of items
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    // Move stack to a new array of size max.
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    // Add item to top of stack.
    public void push(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    // Remove item from top of stack
    public Item pop() {
        Item item = a[--N];

        // Avoid loitering (see text).
        a[N] = null;

        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}
