package my.homeworks.hw06.atm.output.strategy;

import my.homeworks.hw06.atm.BanknoteBatch;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinBanknotesCountOutputStrategy implements BanknoteOutputStrategy {

    @Override
    public BanknoteBatch execute(int amount, BanknoteBatch banknoteBatch) {

        BanknoteBatch batchResult = new BanknoteBatch();

        List<Integer> banknotes = getBanknotes(banknoteBatch);

        int remainder = amount;
        for (int banknote : banknotes) {
            int totalCount = banknoteBatch.banknoteCount(banknote);
            int count = remainder / banknote;
            if (count > totalCount) {
                count = totalCount;
            }
            remainder -= count * banknote;
            batchResult.append(banknote, count);
        }

        return batchResult;
    }

    /**
     * Возвращает список банкнот, упорядоченный в порядке убывания номинала.
     * Список отфильтровывается от банкнот, для которых количество 0.
     *
     * @param banknoteBatch
     * @return
     */
    private List<Integer> getBanknotes(BanknoteBatch banknoteBatch) {

        return banknoteBatch.banknotes().stream()
                .filter(nominal -> banknoteBatch.exists(nominal))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
