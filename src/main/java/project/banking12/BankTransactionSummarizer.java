package project.banking12;

/**
 * Interface for summarizing bank transactions
 */

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
