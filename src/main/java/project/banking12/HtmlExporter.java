package project.banking12;

/**
 * Class exports Summary Statistics into HTML format
 */

import java.io.File;

/**
 * TODO
 *
 * 1) class need to export Summary Statistics into HTML file
 *
 * 2) in the best case summary statistics should open browser and show everything on the new page
 *
 */

public class HtmlExporter implements  Exporter{

    private static String directoryPath;
    private static String expectedFileName;
    private static FileCreator htmlCreator = new FileCreatorHtml();


    public HtmlExporter(String directoryPath, String expectedFileName){
        this.directoryPath = directoryPath;
        this.expectedFileName = expectedFileName;
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

        htmlCreator.createFile(directoryPath,expectedFileName,result);

        return result;
    }

/*
    public File exportToFileHtml(FileCreator fileCreator){
        return fileCreator.createFile(filePath,expectedFileName);
    }
*/


}
