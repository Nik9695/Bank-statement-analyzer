package project.banking12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class ApplicationMain {

    private static final String FILE_PATH =
            "D:\\JavaPetProjects\\Banking-Analyzer-ver-1.2\\src\\main\\resources\\transactions.txt";

    private static Path path = Paths.get(FILE_PATH);

    public static void main(String[] args) throws IOException, InterruptedException {

        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parserCSV = new BankStatementCSVParser();
        final Exporter exporterHtml = new HtmlExporter();

        analyzer.analyze("transactions.txt", parserCSV, exporterHtml);
    }
}
