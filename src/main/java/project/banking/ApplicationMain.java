package project.banking;

import java.io.IOException;

/**
 *
 * TODO
 *
 * 1) BankStatementAnalyzer - make class more overall, delete exact path - DONE!
 *
 * 2) BankStatementProcessor - delete unused methods - DONE!
 *
 * 3) Create export function to JSON - DONE!
 *
 * 4) Create export function to XML - DONE!
 *
 * 5) Create class Notification for collecting errors - DONE!
 *
 * 6) Create Web application for analyzing bank transactions - NONE
 *
* 7) Round 'average' in summary statistics - DONE!
 *
 * 8) Create new tests to cover new functions:
 *      a)
 *      b)
 *      c)
 *
 * 9) Write comments for each class - NONE
 */

public class ApplicationMain {

    final static String resourcesFilePath = "src\\main\\resources\\transactions.txt";

    private static String exportDirectoryPath = "src\\main\\resources\\";

    public static void main(String[] args){

        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        final BankStatementParser parserCSV = new BankStatementCSVParser();

        final Exporter exporterHtml = new HtmlExporter(exportDirectoryPath);
        final Exporter exporterJson = new JsonExporter(exportDirectoryPath);
        final Exporter exporterXml = new XmlExporter(exportDirectoryPath);


        try{
            if(args.length == 0){
                analyzer.analyze(resourcesFilePath, parserCSV, exporterHtml);
                analyzer.analyze(resourcesFilePath, parserCSV, exporterJson);
                analyzer.analyze(resourcesFilePath, parserCSV, exporterXml);
            } else {
                analyzer.analyze(args[0], parserCSV, exporterHtml);
                analyzer.analyze(args[0], parserCSV, exporterJson);
                analyzer.analyze(args[0], parserCSV, exporterXml);
            }
        } catch (IOException e){
            System.out.println("Error in main method.");;
        }
    }
}
