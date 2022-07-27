package project.banking;

import java.util.List;

/**
 * Implementation of the interface give an opportunity for converting 'String' <br/>
 * line to 'BankTransaction' representation.
 */


public interface BankStatementParser {
    /**
     * Returns 'BankTransaction' element. It is required to pass a 'String' line as an argument.
     * @param line
     * @return BankTransaction
     */
    BankTransaction parseFrom(String line);

    /**
     * Returns 'List' of 'BankTransactions'. As argument 'List' of 'Strings' must be passed.
     * @param lines
     * @return List<BankTransaction>
     */
    List<BankTransaction> parseByLines(List<String> lines);
}
