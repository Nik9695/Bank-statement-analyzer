package project.banking;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class exports {@link SummaryStatistics} into XML format.
 * @see SummaryStatistics
 * @see Exporter
 */


public class XmlExporter implements Exporter{

    private static String exportDirectoryPath;
    private final static String FILE_NAME = "XmlSummaryStatistics.xml";

    /**
     * Class constructor, receives directory path for export as an argument.
     * @param exportDirectoryPath {@link String} value which specifies <i><b>directory path</b></i> for export.
     */

    public XmlExporter(String exportDirectoryPath){
        this.exportDirectoryPath = exportDirectoryPath;
    }

    /**
     *  Returns {@link String} result which corresponds to .xml file structure.
     *
     *  Creates .xml file in export directory path (src\main\resources).
     * @param summaryStatistics {@link SummaryStatistics} object which is already analyzed and need to be exported.
     * @return {@link String} representation of analyzed bank transaction statistics.
     */

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "";

        try(FileOutputStream output = new FileOutputStream(new File(exportDirectoryPath + FILE_NAME))){

            System.out.println("XML export file created.");

            XMLEncoder encoder = new XMLEncoder(output);
            encoder.writeObject(summaryStatistics);
            encoder.close();

        }catch (IOException e){
            System.out.println("Error while exporting to XML.");
        }
        System.out.println(result);
        return result;
    }
}
