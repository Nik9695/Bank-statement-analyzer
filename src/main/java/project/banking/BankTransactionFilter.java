package project.banking;

/**
 * Interface giving an opportunity to sort 'Bank transactions' list
 * according to some condition.
 */

@FunctionalInterface
public interface BankTransactionFilter {

    /**
     * Returns "true" if passed 'BankTransaction' matches the condition, and "false" otherwise.
     *
     * Еhe method has access to all properties of the 'BankTransaction' object,
     * which allows you to set any search criteria
     *
     *  @param bankTransaction
     * @return boolean
     */
    boolean test(BankTransaction bankTransaction);
}
