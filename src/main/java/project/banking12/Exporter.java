package project.banking12;

/**
 * Interface for exporting Summary Statistics to different formats
 */

@FunctionalInterface
public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
