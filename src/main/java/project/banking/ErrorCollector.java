package project.banking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is a representation of "Notification pattern".
 *
 * Class is used to collect errors occurred while parsing input file.
 */

public class ErrorCollector {

    private List<String> errorList = new ArrayList<>();

    /**
     * Method adding <b>String</b> error message to the {@link ErrorCollector#errorList};
     * @param errorMessage information which describes error;
     */

    public void addError(String errorMessage) {
        errorList.add(errorMessage);
    }

    /**
     * Method returns 'true' if there are no elements in {@link ErrorCollector#errorList},
     * otherwise returns 'false'.
     * @return boolean
     */
    public boolean hasErrors() {
        return !errorList.isEmpty();
    }

    /**
     * Method returns {@link String} representation of {@link ErrorCollector#errorList}.
     * @return List<String>
     */
    public List<String> getErrors() {
        return errorList;
    }

    /**
     * Method receives and checks for errors list of bank transactions.
     * Using sequential enumeration method checks bank transactions one by one.
     * Returns 'true' if at least one bank transaction has an error, otherwise returns 'false'.
     * @param bankTransactions List<{@link BankTransaction}> to be checked for errors.
     * @return boolean
     */
    public boolean validate(List<BankTransaction> bankTransactions) {

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
            return true;
        } else {
            System.out.println("All data in transactions list is valid.");
            return false;
        }
    }
}
