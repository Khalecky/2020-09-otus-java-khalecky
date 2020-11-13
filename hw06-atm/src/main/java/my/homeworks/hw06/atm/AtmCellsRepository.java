package my.homeworks.hw06.atm;

import my.homeworks.hw06.atm.exception.NotEnoughBanknotesException;

import java.util.HashMap;

public class AtmCellsRepository {

    private final HashMap<Integer, AtmCell> cells = new HashMap<>();

    public BanknoteBatch allBanknotesToBatch()
    {
        BanknoteBatch batch = new BanknoteBatch();
        for (Integer banknoteValue : cells.keySet()) {
            batch.appendBatch(cells.get(banknoteValue).getBatch());
        }
        return batch;
    }

    public void insertBanknotes(int banknote, int count) {
        getAtmCell(banknote).insert(count);
    }

    public BanknoteBatch extractBanknotes(int banknote, int count) throws NotEnoughBanknotesException {
        return getAtmCell(banknote).extract(count);
    }

    private AtmCell getAtmCell(int banknote) {
        if (!cellExists(banknote)) {
            cells.put(banknote, new AtmCell(banknote));
        }
        return cells.get(banknote);
    }

    private boolean cellExists(int banknote) {
        return cells.containsKey(banknote);
    }

}
