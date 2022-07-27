package project.banking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The class encapsulates all parsing, processing and exporting functions.
 *
 * Class follows up single responsibility principle: class responsibility is "analyzing";
 */
public class BankStatementAnalyzer {

    /**
     * Method purpose is to encapsulate actions of parsing, processing and exporting in single event.
     * <br/><br/>
     * Method's working steps:<br/><br/>
     *  1) Method opens file with corresponding <b>file name</b>;<br/><br/>
     *  2) Parsing it by lines with received {@link BankStatementParser} entity;<br/><br/>
     *  3) An instance of {@link ErrorCollector} is generating inside the method;<br/><br/>
     *  4) The created list of transactions is passing to the {@link BankStatementProcessor} in the constructor;<br/><br/>
     *  5) An instance of {@link SummaryStatistics} created using method {@link BankStatementProcessor#createSummaryStatistics()};<br/><br/>
     *  6) {@link ErrorCollector} is checking list of transactions for errors using method {@link project.banking.ErrorCollector#validate(List<BankTransaction>)};<br/><br/>
     *  7) The {@link Exporter} object making export to a file(type of file depends on type of exporter).<br/><br/>
     *
     * @param fileName name of the file which will be analyzed.
     * @param bankStatementParser instance of {@link BankStatementParser} , depends on format of input final.
     * @param exporter instance of {@link Exporter},
     * this parameter the choice of this parameter depends on the format in which the user wants to export the processing results.
     * @throws IOException
     */
    public void analyze(final String fileName, final BankStatementParser bankStatementParser, final Exporter exporter) throws IOException {

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

