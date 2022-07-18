package project.banking12;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Remove old unused methods
 */

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }


    /**
     * Must be replaced by method using interface BankTransactionSummarizer
     * @return
     */
    public double claculateTotalAmount(){
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions)
            total += bankTransaction.getAmount();
        System.out.println("Total amount of all transactions: " + total);
        return total;
    }
    /**
     *
     */


/*    public double calculateTotalInMonth(final Month month){

        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        double totalMonth = 0d;
        for(BankTransaction bankTransaction : bankTransactions){
            if(month == bankTransaction.getDate().getMonth())
                totalMonth += bankTransaction.getAmount();
        }
        System.out.println("Total amount of transactions on " + month + " : " + totalMonth);
        return totalMonth;
    }*/


    public  double displayMaximumTransaction(){
        double maxValue = Double.MIN_VALUE;
        BankTransaction biggestBankTransaction = null;
        for(BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getAmount() > maxValue){
                maxValue = bankTransaction.getAmount();
                biggestBankTransaction = bankTransaction;
            }
        }
        System.out.println("The biggest bank transaction is: " + biggestBankTransaction );
        return 0d;
    }

    public int calculateNumberOfTransactions(){
        System.out.println("Number of all transactions in the file: " + bankTransactions.size());
        return bankTransactions.size();
    }

    /**
     *
     * New methods
     *
     */

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            result = bankTransactionSummarizer.summarize(result,bankTransaction);
        }
        return result;
    }

    public SummaryStatistics createSummaryStatistics(){

        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

    public double calculateTotalInMonth(final Month month){
        return summarizeTransactions((accumulator, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    public List<BankTransaction> findTransaction(final BankTransactionFilter filter){
        final List<BankTransaction> result = new ArrayList<>();
        for(BankTransaction bankTransaction : bankTransactions){
            if(filter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }


}
