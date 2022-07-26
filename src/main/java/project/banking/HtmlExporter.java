package project.banking;

/**
 * Class exports Summary Statistics into HTML format
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class HtmlExporter implements  Exporter{

    private static String exportDirectoryPath;
    private final static String FILE_NAME = "HtmlSummaryStatistics.html";

    public HtmlExporter(String exportDirectoryPath){
        this.exportDirectoryPath = exportDirectoryPath;
    }

    @Override
    public String export(final SummaryStatistics summaryStatistics) {

        String result = "<!doctype html>";

        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";

        try(PrintStream output = new PrintStream(new FileOutputStream(new File(exportDirectoryPath + FILE_NAME)))){
            System.out.println("HTML export file created.");
            output.print(result);
        } catch (IOException e) {
            System.out.println("Error while exporting to HTML.");
        }

        return result;
    }

}
