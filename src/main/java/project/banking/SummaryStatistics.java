package project.banking;

/**
 * A domain object representing summary information about the list of transactions,
 * which is exported to file and provided to the user.
 */

public class SummaryStatistics {

    private double sum,max,min,average;

    /**
     * Default constructor.
     * Used by "java.beans.XMLEncoder" to create .xml file
     * when it is requested by user ({@link project.banking.XmlExporter#export(SummaryStatistics)}).
     */
    public SummaryStatistics(){}

    /**
     * Class constructor.
     * @param sum sum of all transactions in the list.
     * @param max maximum transaction in the list.
     * @param min minimum transaction in the list.
     * @param average average of all transactions in the list.
     */
    public SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    /**
     * Setting {@link SummaryStatistics#sum} value.
     * @param sum set value of {@link SummaryStatistics#sum} parameter.
     */
    public void setSum(double sum) {
        this.sum = sum;
    }

    /**
     * Setting {@link SummaryStatistics#max} value.
     * @param max set value of {@link SummaryStatistics#max} parameter.
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Setting {@link SummaryStatistics#min} value.
     * @param min set value of {@link SummaryStatistics#min} parameter.
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Setting {@link SummaryStatistics#average} value.
     * @param average set value of {@link SummaryStatistics#average} parameter.
     */
    public void setAverage(double average) {
        this.average = average;
    }

    /**
     * Returns {@link SummaryStatistics#sum} parameter of {@link SummaryStatistics}.
     * @return {@link SummaryStatistics#sum}
     */
    public double getSum() {
        return sum;
    }

    /**
     * Returns {@link SummaryStatistics#max} parameter of {@link SummaryStatistics}.
     * @return {@link SummaryStatistics#max}
     */
    public double getMax() {
        return max;
    }

    /**
     *Returns {@link SummaryStatistics#min} parameter of {@link SummaryStatistics}.
     * @return {@link SummaryStatistics#min}
     */
    public double getMin() {
        return min;
    }

    /**
     *Returns {@link SummaryStatistics#average} parameter of {@link SummaryStatistics}.
     * @return {@link SummaryStatistics#average}
     */
    public double getAverage() {
        return average;
    }
}
