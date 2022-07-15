package project.banking12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Formatter;
import java.util.List;

public class HistogramProcessor {

    private static String signOfHistogramColumn;

    public void drawHistogram(Path path, BankStatementParser bankStatementParser) throws IOException, InterruptedException {
        System.out.println("Histogram is preparing, please wait a second... ;)");

        for (int j = 1; j < 6; j++) {
            System.out.println(".");
            Thread.sleep(1000);
        }

        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseByLines(lines);
        Formatter form1 = new Formatter();

        form1.format("%s : ",bankTransactions.get(0).getDate());

        form1.format("|%-10s : %s",bankTransactions.get(0).getDescription(),
                amountToColumns(bankTransactions.get(0).getAmount()));
        System.out.println(form1);
        form1.close();

        for(int i = 1; i < bankTransactions.size();++i){
            if(bankTransactions.get(i).getDate().equals(bankTransactions.get(i-1).getDate())){
                Formatter form2 = new Formatter();

                form2.format("%14s%-10s : %s","|",bankTransactions.get(i).getDescription(),
                        amountToColumns(bankTransactions.get(i).getAmount()));

                System.out.println(form2);
                form2.close();
            } else {
                Formatter form3 = new Formatter();
                form3.format("%s : ",bankTransactions.get(i).getDate());
                form3.format("|%-10s : %s",bankTransactions.get(i).getDescription(),
                        amountToColumns(bankTransactions.get(i).getAmount()));
                System.out.println("^\n*\n*\n*\n");
                System.out.println(form3);
                form3.close();
            }
        }

    }

    public static String amountToColumns(double amount){

        String column = "";
        int lengthOfHistogramColumn;

        if(amount > 0){
            signOfHistogramColumn = "+";
        } else {
            signOfHistogramColumn = "-";
        }

        lengthOfHistogramColumn = (int) amount / 100;

        if (Math.abs(amount) <= 50){
            lengthOfHistogramColumn = 0;
        }

        for (int i = 0; i <= Math.abs(lengthOfHistogramColumn); i++) {
            column += signOfHistogramColumn;
        }
        return column;
    }

}
