package project.banking;

/**
 * Interface for filtering bank transactions according to any principle
 */

@FunctionalInterface
public interface BankTransactionFilter {
    /**
     * DESCRIPTION
     *
     *
     * @param bankTransaction
     * @return
     */
    boolean test(BankTransaction bankTransaction);
}
