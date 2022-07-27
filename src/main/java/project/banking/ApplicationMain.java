package project.banking;

import java.io.IOException;

/**
 * Class represents entrance to the application.
 */

public class ApplicationMain {

    final static String resourcesFilePath = "src\\main\\resources\\transactions.txt";

    private static String exportDirectoryPath = "src\\main\\resources\\";

    /**
     * Method is called to run the application.
     *
     * @param args as parameters can be passed directory path for input file,
     *             otherwise application will be looking for input file in
     *             directory specified in {@link ApplicationMain#resourcesFilePath} inside of class {@link ApplicationMain}.
     */

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
