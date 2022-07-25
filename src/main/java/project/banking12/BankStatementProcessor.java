package project.banking12;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Possible functions:
 *
 *      1) create Summary Statics ( max, min, sum, avg)
 *
 *      2) calculate transactions in exact Month
 *
 *      3) calculate number of transactions
 *
 *      4) filter transactions according to some condition
 */

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    public int calculateNumberOfTransactions(){
        System.out.println("Number of all transactions in the file: " + bankTransactions.size());
        return bankTransactions.size();
    }

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
                Math.round(doubleSummaryStatistics.getAverage()));
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
