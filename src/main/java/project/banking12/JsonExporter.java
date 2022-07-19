package project.banking12;

public class JsonExporter implements Exporter{

    private static String directoryPath;
    private static String expectedFileName;
    private static FileCreator jsonCreator = new FileCreatorJson();

    public JsonExporter(String directoryPath, String expectedFileName){
        this.directoryPath = directoryPath;
        this.expectedFileName = expectedFileName;
    }

    @Override
    public String export(SummaryStatistics summaryStatistics) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        stringBuilder.append("\"Summary Statistics\"" + " : {");
        stringBuilder.append("\"Sum of all transactions\"" + " : " + summaryStatistics.getSum() + ",");
        stringBuilder.append("\"Maximum transaction\"" + " : " + summaryStatistics.getMax() + ",");
        stringBuilder.append("\"Minimum transaction\"" + " : " + summaryStatistics.getMin() + ",");
        stringBuilder.append("\"Average of all transactions\"" + " : " + String.format("%.2f",summaryStatistics.getAverage()));
        stringBuilder.append("}");
        stringBuilder.append("}");

        String result = String.valueOf(stringBuilder);

        jsonCreator.createFile(directoryPath,expectedFileName,result);

        return String.valueOf(stringBuilder);
    }

}


