package project.banking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {

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

