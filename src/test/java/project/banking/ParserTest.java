package project.banking;



import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserTest {
    private static final String FILE_PATH = "src\\test\\resources\\transactionsForTest.txt";

    private static Path path = Paths.get(FILE_PATH);



    @Test
    public void parseFromCSVtest(){
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final String line = "30-01-2017,-100,Deliveroo";

        BankTransaction testingResult = bankStatementParser.parseFrom(line);

        BankTransaction expectedResult =
                new BankTransaction(LocalDate.of(2017, Month.JANUARY,30),-100,"Deliveroo");

        final double tolerance = 0d;

        Assert.assertEquals(expectedResult.getDate(), testingResult.getDate());
        Assert.assertEquals(expectedResult.getDescription(), testingResult.getDescription());
        Assert.assertEquals(expectedResult.getAmount(), testingResult.getAmount(), tolerance);

    }

    @Test
    public void parseLinesFromCSVtest() throws IOException {
        List<String> lines = Files.readAllLines(path);
        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        List<BankTransaction> expectedList = new ArrayList<>(Arrays.asList(
                new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo"),
                new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco"),
                new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 1), 6000, "Salary"),
                new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 2), 2000, "Royalties")));

        List<BankTransaction> result = bankStatementParser.parseByLines(lines);

        Assert.assertEquals(expectedList, result);
    }
}
