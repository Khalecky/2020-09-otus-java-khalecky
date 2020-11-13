package my.homeworks.hw06.atm;

import my.homeworks.hw06.atm.output.strategy.BanknoteOutputStrategy;
import my.homeworks.hw06.atm.exception.AmountNotAvailableException;
import my.homeworks.hw06.atm.exception.ModuleNotAvailableException;

public class Atm {

    private BanknoteOutputStrategy banknoteOutputStrategy;
    private AtmCellsRepository atmCellsRepository;

    public Atm(AtmCellsRepository atmCellsRepository) {
        this.atmCellsRepository = atmCellsRepository;
    }

    public void setBanknoteOutputStrategy(BanknoteOutputStrategy banknoteOutputStrategy) {
        this.banknoteOutputStrategy = banknoteOutputStrategy;
    }

    public BanknoteBatch output(int amount) throws RuntimeException {
        validateOutputStrategy();
        return processDebit(amount);
    }

    public void inputBatch(BanknoteBatch banknoteBatch) {
        for (var banknote : banknoteBatch.banknotes()) {
            inputBanknotes(banknote, banknoteBatch.banknoteCount(banknote));
        }
    }

    public void inputBanknotes(int banknote, int count) {
        atmCellsRepository.insertBanknotes(banknote, count);
    }

    public BanknoteBatch getAllBanknotes() {
        return atmCellsRepository.allBanknotesToBatch();
    }

    private void validateOutputStrategy() throws ModuleNotAvailableException {
        if (banknoteOutputStrategy == null) {
            throw new ModuleNotAvailableException("выдача");
        }
    }

    private BanknoteBatch processDebit(int amount) throws RuntimeException {
        BanknoteBatch batch = banknoteOutputStrategy.execute(amount, atmCellsRepository.allBanknotesToBatch());

        if (batch.amount() != amount) {
            throw new AmountNotAvailableException();
        }
        for (int banknote : batch.banknotes()) {
            atmCellsRepository.extractBanknotes(banknote, batch.banknoteCount(banknote));
        }
        return batch;
    }

}
