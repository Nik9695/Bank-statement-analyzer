package project.banking;

import java.util.List;

/**
 * Implementation of the interface give an opportunity to user for converting
 * {@link String} line to {@link BankTransaction} representation.
 * @see BankTransaction
 */


public interface BankStatementParser {
    /**
     * Returns {@link BankTransaction} element generated from {@link String}.
     * It is required to pass a {@link String} line as an argument.
     *
     * @param line a line from input file which contains information about transaction.
     * @return {@link BankTransaction}
     */
    BankTransaction parseFrom(String line);

    /**
     * Returns List<{@link BankTransaction}>. As argument List<{@link String}> must be passed.
     * @param lines {@link List<String>} container of initial information about bank transactions.
     * @return List<{@link BankTransaction}>.
     */
    List<BankTransaction> parseByLines(List<String> lines);
}
