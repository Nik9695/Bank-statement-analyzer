package project.banking12;

import java.io.IOException;

/**
 * 1) BankStatementAnalyzer - make class more overall, delete exact path - DONE!
 *
 * 2) BankStatementProcessor - delete unused methods
 *
 *
 */

public class ApplicationMain {

    /**
     * to run program using maven it is needed to pass absolute path of the investigated file
     * for example: $mvn exec:java -Dexec.args="[absolute-file-path]"
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws IOException, InterruptedException {

        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parserCSV = new BankStatementCSVParser();
        final Exporter exporterHtml = new HtmlExporter();

        analyzer.analyze(args[0], parserCSV, exporterHtml);
    }
}
