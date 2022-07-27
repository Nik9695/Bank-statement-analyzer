package project.banking;

/**
 * Interface giving an opportunity to filter ( or test ) {@link BankTransaction}
 * according to some condition.
 * @see BankTransaction
 */

@FunctionalInterface
public interface BankTransactionFilter {

    /**
     * Returns "true" if passed {@link BankTransaction} matches the condition, and "false" otherwise.
     *
     * The method has access to all properties of the {@link BankTransaction} object ,
     * which allows you to set any search criteria
     * @see BankTransaction
     * @param bankTransaction {@link BankTransaction} to be tested according to some condition.
     * @return boolean
     */
    boolean test(BankTransaction bankTransaction);
}
