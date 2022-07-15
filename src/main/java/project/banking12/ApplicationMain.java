package project.banking12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class ApplicationMain {

    private static final String FILE_PATH =
            "E:\\Java pet projects\\Banking Analyzer ver 1.2\\BankingAnalyzer1_2\\src\\main\\resources\\transactions.txt";

    private static Path path = Paths.get(FILE_PATH);

    public static void main(String[] args) throws IOException, InterruptedException {

/*        BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();
        BankingAnalyzer bankingAnalyzer = new BankingAnalyzer();
        HistogramProcessor histogramProcessor = new HistogramProcessor();

        bankingAnalyzer.analyze(path,bankStatementCSVParser);
        System.out.println();
        histogramProcessor.drawHistogram(path,bankStatementCSVParser);*/


        BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();
        BankTransactionFilter simpleFilter = new SimpleBankTransactionFilter();

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseByLines(lines);

        BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);


        //final List<BankTransaction> result = processor.findTransaction(simpleFilter);
        final List<BankTransaction> result = processor.findTransaction(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 3000);
        System.out.println(result);
    }
}
