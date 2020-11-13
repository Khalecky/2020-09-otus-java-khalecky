package my.homeworks.hw06.atm;

import my.homeworks.hw06.atm.exception.NotEnoughBanknotesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BanknoteBatch {

    private final HashMap<Integer, Integer> banknotesCounts = new HashMap<>();

    public BanknoteBatch() {
    }

    public BanknoteBatch(int banknote, int count) {
        append(banknote, count);
    }

    public BanknoteBatch append(int banknote, int count)
    {
        if (exists(banknote)) {
            count += banknotesCounts.get(banknote);
        }
        banknotesCounts.put(banknote, count);
        return this;
    }

    public BanknoteBatch appendBatch(BanknoteBatch banknoteBatch) {
        for (int banknote : banknoteBatch.banknotes()) {
            append(banknote, banknoteBatch.banknotesCounts.get(banknote));
        }
        return this;
    }

    public BanknoteBatch extract(int banknote, int count) throws NotEnoughBanknotesException {

        int newCount = banknotesCounts.get(banknote) - count;
        if (newCount < 0) {
            throw new NotEnoughBanknotesException();
        }
        if (newCount == 0) {
            banknotesCounts.remove(banknote);
        } else {
            banknotesCounts.put(banknote, newCount);
        }
        return new BanknoteBatch(banknote, count);
    }

    public int banknoteCount(int banknote) {
        return banknotesCounts.get(banknote);
    }

    public Set<Integer> banknotes()
    {
        return banknotesCounts.keySet();
    }

    public boolean exists(int banknote) {
        return banknotesCounts.containsKey(banknote) && banknotesCounts.get(banknote) > 0;
    }

    public int amount() {
        int amount = 0;
        for (var banknote : banknotes()) {
            amount += banknotesCounts.get(banknote) * banknote;
        }
        return amount;
    }

    public void printBatch() {
        banknotes().forEach(nominal -> System.out.println(
                "Банкнота " + nominal + ": " + banknoteCount(nominal))
        );

    }

}
