package project.banking;

import java.time.LocalDate;

/**
 * Java bean
 */

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

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

/*        result = result * 34 + (int)this.getAmount();

        result = result * 34 + this.getDescription().length();*/

        result = result * 34 + this.getDate().hashCode();

        return result;
    }


}
