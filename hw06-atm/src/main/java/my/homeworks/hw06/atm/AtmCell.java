package my.homeworks.hw06.atm;

import my.homeworks.hw06.atm.exception.NotEnoughBanknotesException;

public class AtmCell {

    private BanknoteBatch batch;
    private int banknote;

    AtmCell(int banknote, int count) {
        batch = new BanknoteBatch(banknote, count);
        this.banknote = banknote;
    }

    AtmCell(int banknote) {
        this(banknote, 0);
    }

    public void insert(int count) {
        batch.append(banknote, count);
    }

    public BanknoteBatch extract(int count) throws NotEnoughBanknotesException {
        return batch.extract(banknote, count);
    }

    public BanknoteBatch getBatch() {
        return batch;
    }

}
