package project.banking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Class exports {@link SummaryStatistics} into JSON format.
 * @see SummaryStatistics
 * @see Exporter
 */

public class JsonExporter implements Exporter{

    private static String exportDirectoryPath;
    private final static String FILE_NAME = "JsonSummaryStatistics.json";

    /**
     * Class constructor, receives directory path for export as an argument.
     * @param exportDirectoryPath {@link String} value which specifies <i><b>directory path</b></i> for export.
     */

    public JsonExporter(String exportDirectoryPath){
        this.exportDirectoryPath = exportDirectoryPath;
    }

    /**
     *  Returns {@link String} result which corresponds to .json file structure.
     *
     *  Creates .xml file in export directory path (src\main\resources).
     * @param summaryStatistics {@link SummaryStatistics} object which is already analyzed and need to be exported.
     * @return {@link String} representation of analyzed bank transaction statistics.
     */

    @Override
    public String export(SummaryStatistics summaryStatistics) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        stringBuilder.append("\"Summary Statistics\"" + " : {");
        stringBuilder.append("\"Sum of all transactions\"" + " : " + summaryStatistics.getSum() + ",");
        stringBuilder.append("\"Maximum transaction\"" + " : " + summaryStatistics.getMax() + ",");
        stringBuilder.append("\"Minimum transaction\"" + " : " + summaryStatistics.getMin() + ",");
        stringBuilder.append("\"Average of all transactions\"" + " : " + summaryStatistics.getAverage());
        stringBuilder.append("}");
        stringBuilder.append("}");

        String result = String.valueOf(stringBuilder);

        try(PrintStream output = new PrintStream(new FileOutputStream(new File(exportDirectoryPath + FILE_NAME)))){
            System.out.println("JSON export file created.");
            output.print(result);
        } catch (IOException e) {
            System.out.println("Error while exporting to JSON.");
        }

        return result;
    }

}


