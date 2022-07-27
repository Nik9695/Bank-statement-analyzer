package project.banking;

/**
 * Interface giving an opportunity to export {@link SummaryStatistics} into
 * different formats (depends on realisation).
 *
 * According to open/closed principle, this interface makes it possible
 * to avoid the strong connection of various exporters with each other.
 *
 * @see SummaryStatistics
 */

public interface Exporter {

    /**
     * Returns {@link String} representation of parsed input file.
     *
     * @param summaryStatistics {@link SummaryStatistics} domain object which represents analyzed input file.
     * @return String
     */
    String export(SummaryStatistics summaryStatistics);
}