package project.banking;

/**
 * The interface is designed to implement the concept
 * of sequential enumeration of all banking transactions.
 */

@FunctionalInterface
public interface BankTransactionSummarizer {

    /**
     * Returns a double value. The method must be used when iterating over 'BankTransaction' objects.
     * The method has access to all 'BankTransaction' properties, but is expected to sum only 'Amount' values.
     * @param accumulator
     * @param bankTransaction
     * @return double
     */

    double summarize(double accumulator, BankTransaction bankTransaction);
}
