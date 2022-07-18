package project.banking12;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1) BankStatementAnalyzer - make class more overall, delete exact path
 *
 * 2) BankStatementProcessor - delete unused methods
 *
 *
 */

public class ApplicationMain {

    public static void main(String[] args) throws IOException, InterruptedException {

        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parserCSV = new BankStatementCSVParser();
        final Exporter exporterHtml = new HtmlExporter();

        analyzer.analyze("transactions.txt", parserCSV, exporterHtml);
    }
}
