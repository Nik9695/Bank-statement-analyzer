package project.banking;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlExporter implements Exporter{

    private static String exportDirectoryPath;
    private final static String FILE_NAME = "XmlSummaryStatistics.xml";

    /**
     * Class constructor, receives directory path for export as an argument.
     * @param exportDirectoryPath
     */

    public XmlExporter(String exportDirectoryPath){
        this.exportDirectoryPath = exportDirectoryPath;
    }

    /**
     *  Returns 'String' result which corresponds to '.xml' file structure.
     *
     *  Creates '.xml' file in export directory path (src\main\resources).
     * @param summaryStatistics
     * @return
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
