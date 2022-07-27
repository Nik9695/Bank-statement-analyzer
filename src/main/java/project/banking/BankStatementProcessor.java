package project.banking;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Possible functions:
 *
 *      1) create Summary Statics ( max, min, sum, avg);
 *
 *      2) calculate transactions in exact Month;
 *
 *      3) calculate number of transactions;
 *
 *      4) filter transactions according to some condition;
 *
 * Class follows up single responsibility principle: class responsibility is "processing";
 */

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    /**
     * Class constructor.
     * Receives a list of bank transactions as an argument and saves to its field.
     * @param bankTransactions
     */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    /**
     * Method returns a domain object of output 'SummaryStatistics'.
     * @return SummaryStatistics
     */
    public SummaryStatistics createSummaryStatistics(){

        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                Math.round(doubleSummaryStatistics.getAverage()));
    }

    /**
     * Method for future function. Not used.
     * @param bankTransactionSummarizer
     * @return double
     */
    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            result = bankTransactionSummarizer.summarize(result,bankTransaction);
        }
        return result;
    }

    /**
     * Method for future function. Not used.
     * @return int
     */
    public int calculateNumberOfTransactions(){
        System.out.println("Number of all transactions in the file: " + bankTransactions.size());
        return bankTransactions.size();
    }

    /**
     * Method for future function. Not used.
     * @param month
     * @return
     */
    public double calculateTotalInMonth(final Month month){
        return summarizeTransactions((accumulator, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    /**
     * Method for future function. Not used.
     * @param filter
     * @return
     */
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
