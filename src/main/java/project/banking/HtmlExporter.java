package project.banking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Class exports {@link SummaryStatistics} into HTML format.
 * @see SummaryStatistics
 * @see Exporter
 */

public class HtmlExporter implements  Exporter{

    private static String exportDirectoryPath;
    private final static String FILE_NAME = "HtmlSummaryStatistics.html";

    /**
     * Class constructor, receives directory path for export as an argument.
     * @param exportDirectoryPath {@link String} value which specifies <i><b>directory path</b></i> for export.
     */

    public HtmlExporter(String exportDirectoryPath){
        this.exportDirectoryPath = exportDirectoryPath;
    }

    /**
     *  Returns {@link String} result which corresponds to .html file structure.
     *
     *  Creates .xml file in export directory path (src\main\resources).
     * @param summaryStatistics {@link SummaryStatistics} object which is already analyzed and need to be exported.
     * @return {@link String} representation of analyzed bank transaction statistics.
     */

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
