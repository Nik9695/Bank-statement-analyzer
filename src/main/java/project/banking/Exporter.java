package project.banking;

/**
 * Interface giving an opportunity to export 'SummaryStatistics' into
 * different formats (depends on realisation).
 *
 * According to open/closed principle, this interface makes it possible
 * to avoid the strong connection of various exporters with each other.
 */

public interface Exporter {

    /**
     * Returns 'String' value.
     *
     * The result 'String' of the method can be passed to any output (file,console,email etc.).
     *
     * @param summaryStatistics
     * @return String
     */
    String export(SummaryStatistics summaryStatistics);
}