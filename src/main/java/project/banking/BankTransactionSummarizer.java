package project.banking;

/**
 * The interface is designed to implement the concept
 * of sequential enumeration of all {@link BankTransaction} elements in some list.
 * @see BankTransaction
 */

@FunctionalInterface
public interface BankTransactionSummarizer {

    /**
     * Returns a double value. The method must be used when iterating over {@link BankTransaction} objects.
     * The method has access to all {@link BankTransaction} properties, but is expected to sum only 'Amount of transaction' values.
     * @param accumulator variable where a result will be stored.
     * @param bankTransaction {@link BankTransaction} element from which will be taken parameter to accumulate.
     * @return double
     */

    double summarize(double accumulator, BankTransaction bankTransaction);
}
