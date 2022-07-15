package project.banking12;

@FunctionalInterface
public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
