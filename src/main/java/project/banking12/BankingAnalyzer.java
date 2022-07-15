package project.banking12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankingAnalyzer {



    public void collectSummary(BankStatementProcessor bankStatementProcessor){
        bankStatementProcessor.calculateNumberOfTransactions();
        bankStatementProcessor.claculateTotalAmount();
        bankStatementProcessor.displayMaximumTransaction();
        bankStatementProcessor.calculateTotalInMonth(Month.JANUARY);
    }

    public void analyze( final Path path, BankStatementParser bankStatementParser) throws IOException {

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseByLines(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }
}

