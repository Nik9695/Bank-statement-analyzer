package project.banking12;

import java.time.Month;

public class SimpleBankTransactionFilter implements BankTransactionFilter{
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY &&
                bankTransaction.getAmount() >= 3000;
    }
}
