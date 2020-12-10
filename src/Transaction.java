public class Transaction implements Comparable<Transaction> {

    // customer
    private final String  who;

    // amount
    private final double  amount;

    public Transaction(String who, double amount) {
        this.who    = who;
        this.amount = amount;
    }


    /**
     * Returns the name of the customer involved in this transaction.
     *
     * @return the name of the customer involved in this transaction
     */
    public String who() {
        return who;
    }


    /**
     * Returns the amount of this transaction.
     *
     * @return the amount of this transaction
     */
    public double amount() {
        return amount;
    }

    /**
     * Returns a string representation of this transaction.
     *
     * @return a string representation of this transaction
     */
    @Override

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    /**
     * Compares this transaction to the specified object.
     *
     * @param  other the other transaction
     * @return true if this transaction is equal to {@code other}; false otherwise
     */
    @Override

    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Transaction that = (Transaction) other;
        return (this.amount == that.amount) && (this.who.equals(that.who));
    }


}
