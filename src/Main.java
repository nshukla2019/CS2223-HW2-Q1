import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // randomly generated array
        int[] A = IntStream.generate( ()
                -> new Random().nextInt(1000)).limit(20).toArray();

        // converting from int[] to Integer[]
        Integer[] Ai = Arrays.stream(A).boxed().toArray(Integer[]::new);

        // Min Priority Queue
        MinPQ<Integer> minPQ = new MinPQ<Integer>(Ai.length+1);

        // add each item from array to min Priority Queue
        for (Integer i : Ai) {
            minPQ.insert(i);
        }

        // temporary stack to take all the values
        Stack<Integer> stack = new Stack<Integer>();

        // push all minimums to stack
        while (!minPQ.isEmpty()) {
            stack.push(minPQ.delMin());
        }

        // show result by printing out what was put on the stack
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();

        // manual method
        // String name of client, int amount of dollars

        Transaction[] t = new Transaction[5];
        t[0] = new Transaction("Turing", 644.08);
        t[1] = new Transaction("Tarjan", 4121.85);
        t[2] = new Transaction("Knuth", 288.34);
        t[3] = new Transaction("Dijkstra",2678.40);
        t[4] = new Transaction("Justin",264724.40);

        // Min Priority Queue for transaction class
        MinPQ<Transaction> complexMinPQ = new MinPQ<Transaction>(t.length + 1);

        // insert each item into min priority queue
        for (Transaction j : t) {
            complexMinPQ.insert(j);
        }

        // temporary stack to hold values
        Stack<Transaction> transactionStack = new Stack<Transaction>();

        // push minimum items from MinPQ onto stack
        while (!complexMinPQ.isEmpty()) {
            transactionStack.push(complexMinPQ.delMin());
        }

        // show result by printing out what was put on the stack
        for (Transaction j : transactionStack) {
            System.out.print(j.amount() + " ");
        }
        System.out.println();

    }

}