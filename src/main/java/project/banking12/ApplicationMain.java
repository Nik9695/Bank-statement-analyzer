package project.banking12;

import java.io.IOException;

/**
 *
 * TODO
 *
 * 1) BankStatementAnalyzer - make class more overall, delete exact path - DONE!
 *
 * 2) BankStatementProcessor - delete unused methods
 *
 * 3) Create export function to JSON - DONE!
 *
 * 4) Create export function to XML -
 *
 * 5) Create class Notification for collecting errors
 *
 * 6) Create Web application for analyzing bank transactions
 */

public class ApplicationMain {

    /**
     * to run program using maven it is needed to pass absolute path of the investigated file
     * for example: $mvn exec:java -Dexec.args="[absolute-file-path]"
     *
     * variable filePath is the absolute path to the file located on local computer.
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */

    final static String resourcesFilePath = "D:\\JavaPetProjects\\Banking-Analyzer-ver-1.2\\src\\main\\resources\\transactions.txt";
    private static String directoryPath = "D:\\JavaPetProjects\\Banking-Analyzer-ver-1.2\\src\\main\\resources\\";
    private static String expectedFileNameJson = "JsonSummaryStatistics.json";
    private static String expectedFileNameHtml = "HtmlSummaryStatistics.html";


    public static void main(String[] args){

        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parserCSV = new BankStatementCSVParser();

        final Exporter exporterHtml = new HtmlExporter(directoryPath,expectedFileNameHtml);
        final Exporter exporterJson = new JsonExporter(directoryPath,expectedFileNameJson);


        try{
            if(args.length < 1){
                analyzer.analyze(resourcesFilePath, parserCSV, exporterHtml);
                analyzer.analyze(resourcesFilePath, parserCSV, exporterJson);

            } else {
                analyzer.analyze(args[0], parserCSV, exporterHtml);
                analyzer.analyze(args[0], parserCSV, exporterJson);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
