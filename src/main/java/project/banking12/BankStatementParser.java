package project.banking12;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseByLines(List<String> lines);
}
