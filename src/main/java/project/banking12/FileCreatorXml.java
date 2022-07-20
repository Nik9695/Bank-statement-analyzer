package project.banking12;

import java.io.*;

public class FileCreatorXml implements FileCreator{

    @Override
    public File createFile(String directoryPath, String fileName, String exportResult) {

        File xmlFile = new File(directoryPath + fileName);

        try {
            if(xmlFile.createNewFile()){
                System.out.println("File was successfully created.");
            } else{
                System.out.println("Error while creating file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintStream output = new PrintStream(new FileOutputStream(xmlFile))){
            output.print(exportResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return xmlFile;
    }
}
