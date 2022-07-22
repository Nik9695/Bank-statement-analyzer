package project.banking12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {

    private List<String> errorList = new ArrayList<>();

    public void addError(String errorMessage) {
        errorList.add(errorMessage);
    }

    public boolean hasErrors() {
        return !errorList.isEmpty();
    }

    public String errorMessage() {
        return errorList.toString();
    }

    public List<String> getErrors() {
        return errorList;
    }

    public ErrorCollector validate(List<BankTransaction> bankTransactions) {

        ErrorCollector errorCollector = new ErrorCollector();

        for (BankTransaction bankTransaction : bankTransactions) {

            if (bankTransaction.getDescription().length() > 30) {
                errorCollector.addError("Description length is exceeded!");
            } else if (bankTransaction.getDate().isAfter(LocalDate.now())) {
                errorCollector.addError("Date can not be in the future.");
            }
        }

        if(errorCollector.hasErrors()){
            System.out.println("Parsed transactions list has next errors: " + "\n" + errorCollector.getErrors());
        } else {
            System.out.println("All data in transactions list is valid.");
        }
        return errorCollector;
    }
}
