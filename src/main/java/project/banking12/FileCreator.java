package project.banking12;

import java.io.File;

@FunctionalInterface
public interface FileCreator {
    File createFile(String directoryPath, String fileName, String exportResult);
}
