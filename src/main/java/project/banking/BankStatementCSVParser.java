package project.banking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is a realisation of {@link BankStatementParser} which is designed for parsing .csv files.
 *
 * Class follows up single responsibility principle: class responsibility is "parsing";
 */
public class BankStatementCSVParser implements BankStatementParser{

    final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     *  Method parsing a {@link String} line, splitting it by expressions and
     *  generating new {@link BankTransaction} object.
     * @param line the source for parsing.
     * @return BankTransaction
     */
    public BankTransaction parseFrom(String line){
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    /**
     * Method iterates over the List<{@link String}> container.
     * For each element from container it applies method {@link BankStatementCSVParser#parseFrom(String)}.
     * Each new object accumulates to list of bank transactions.
     * @param lines the source for parsing.
     * @return List<{@link BankTransaction}>
     */
    public List<BankTransaction> parseByLines(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(String line : lines){
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
