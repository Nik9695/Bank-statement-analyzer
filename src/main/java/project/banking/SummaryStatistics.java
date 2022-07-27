package project.banking;

/**
 * A domain object representing summary information about the list of transactions,
 * which is exported to files and provided to the user
 */

public class SummaryStatistics {

    private double sum,max,min,average;

    /**
     * Default constructor.
     * Created only for proper work of "java.beans.XMLEncoder".
     */
    public SummaryStatistics(){}

    /**
     * Class constructor.
     * @param sum
     * @param max
     * @param min
     * @param average
     */
    public SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }
}
