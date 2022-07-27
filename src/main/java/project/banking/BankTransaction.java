package project.banking;

import java.time.LocalDate;

/**
 * Class is a data transfer object (DTO).
 *
 * Represents bank transaction with all characteristics: <br/><br/>
 *
 *  1) Date - when transaction was performed;<br/><br/>
 *
 *  2) Amount - amount of transaction (can be negative, marked with sign "-");<br/><br/>
 *
 *  3) Description - text description of transaction.
 */

public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

    /**
     * Class constructor, setting all information about transaction :
     * {@link BankTransaction#date}, {@link BankTransaction#amount},{@link BankTransaction#description}.
     *
     * @param date when transaction was performed.
     * @param amount amount of transaction.
     * @param description text description of transaction.
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
