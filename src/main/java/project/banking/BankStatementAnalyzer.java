package project.banking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Еhe class is an entity with the function of processing the list of bank transactions.
 *
 * Class follows up single responsibility principle: class responsibility is "analyzing";
 */
public class BankStatementAnalyzer {

    /**
     * Method receives:
     *  1) 'String' fileName - representing name of the file under investigation;
     *  2) 'BankStatementParser' - an instance of any parser entity;
     *  3) 'Exporter' - an instance of exporter entity;
     *
     * Method's working steps:
     *  1) Method opens file with corresponding 'fileName';
     *  2) Parsing it by lines with received 'BankStatementParser' entity;
     *  3) An instance of 'ErrorCollector' is generating inside the method;
     *  4) The created list of trnasactions is passing to the 'BankStatementProcessor' in the constructor;
     *  5) An instance of 'SummaryStatistics' created using method 'createSummaryStatistics()';
     *  6) 'ErrorCollector' is checking list of transactions for errors using method 'validate()';
     *  7) The exporter object making export to a file(type of file depends on type of exporter).
     *
     * @param fileName
     * @param bankStatementParser
     * @param exporter
     * @throws IOException
     */
    public void analyze(final String fileName, final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {

        final Path path = Paths.get(fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseByLines(lines);

        final ErrorCollector errorCollector = new ErrorCollector();

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.createSummaryStatistics();

        errorCollector.validate(bankTransactions);

        exporter.export(summaryStatistics);

        System.out.println("<--------------------------->");

    }
}

