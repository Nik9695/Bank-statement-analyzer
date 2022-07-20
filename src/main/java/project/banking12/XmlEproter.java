package project.banking12;

public class XmlEproter {

    private static String directoryPath;
    private static String expectedFileName;
    private static FileCreator jsonCreator = new FileCreatorJson();

    public XmlEproter(String directoryPath, String expectedFileName){
        this.directoryPath = directoryPath;
        this.expectedFileName = expectedFileName;
    }
}
