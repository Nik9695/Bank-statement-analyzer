package project.banking12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    /**
     * TODO
     *
     * 1) Remove exact path from the class, make it overall
     */

/*    private static final String RESOURCES =
            "D:\\JavaPetProjects\\Banking-Analyzer-ver-1.2\\src\\main\\resources\\";*/


    public void analyze(final String fileName, final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {

        final Path path = Paths.get(fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseByLines(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.createSummaryStatistics();

        System.out.println(exporter.export(summaryStatistics));

    }
}

