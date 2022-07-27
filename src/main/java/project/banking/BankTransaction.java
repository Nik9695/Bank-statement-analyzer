package project.banking;

import java.time.LocalDate;

/**
 * Class is a data transfer object (DTO).
 *
 * Represents bank transaction itself.
 */

public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

    /**
     * Class constructor.
     * @param date
     * @param amount
     * @param description
     */
    public BankTransaction(LocalDate date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    /**
     * Getter, returns date of the transaction.
     * @return LocalDate
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Getter, returns amount of the transaction.
     * @return double
     */

    public double getAmount() {
        return amount;
    }

    /**
     * Getter, returns description of the transaction.
     * @return String
     */
    public String getDescription() {
        return description;
    }

    public String toString(){
        return "{ " + this.getDate()+ ", " + this.getAmount() + ", " + this.getDescription() + " }";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if(this == null || getClass() != o.getClass()){return false;}
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
    }

    @Override
    public int hashCode(){
        int result = 17;

        result = result * 34 + this.getDate().hashCode();

        return result;
    }


}
