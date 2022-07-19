package project.banking12;

import java.io.*;

public class FileCreatorJson implements FileCreator{

    @Override
    public File createFile(String directoryPath, String fileName, String exportResult) {

        File jsonFile = new File(directoryPath + fileName);

        try {
            if(jsonFile.createNewFile()){
                System.out.println("File was successfully created.");
            } else{
                System.out.println("Error while creating file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintStream output = new PrintStream(new FileOutputStream(jsonFile))){
            output.print(exportResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }
}
